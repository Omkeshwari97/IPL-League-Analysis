package iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import IPLJar.CSVBuilderException;
import IPLJar.CSVBuilderFactory;
import IPLJar.ICSVBuilder;
import iplleagueanalysis.IPLLeagueAnalyserException.ExceptionType;

public class IPLLeagueAnalysis 
{
	List<FactsheetMostRuns> runsList = null;
	List<FactsheetMostWkts> wktsList = null;
	
	public void loadRunsData(String csvFilePath) throws IPLLeagueAnalyserException
	{
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) 
		{
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			runsList = csvBuilder.getCSVFileList(reader, FactsheetMostRuns.class);
		} 
		catch (CSVBuilderException e)
		{
			throw new IPLLeagueAnalyserException(e.getMessage(), ExceptionType.WRONG_STATISTICS_DATA);
		}
		catch (IOException e) 
		{
			throw new IPLLeagueAnalyserException(e.getMessage(), ExceptionType.FILE_PROBLEM);
		}
	}
	
	public int loadWktsData(String csvFilePath) throws IPLLeagueAnalyserException
	{
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) 
		{
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			wktsList = csvBuilder.getCSVFileList(reader, FactsheetMostWkts.class);
			
			return wktsList.size();
		} 
		catch (CSVBuilderException e)
		{
			throw new IPLLeagueAnalyserException(e.getMessage(), ExceptionType.WRONG_STATISTICS_DATA);
		}
		catch (IOException e) 
		{
			throw new IPLLeagueAnalyserException(e.getMessage(), ExceptionType.FILE_PROBLEM);
		}
	}

	//uc1
	public String getAvgWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.avg);
		this.sortData(runsList, runsComparator);
		String sortedRunsJson = new Gson().toJson(runsList);
		return sortedRunsJson;
	}

	//uc2
	public String getStrikeRateWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.sr);
		this.sortData(runsList, runsComparator);
		String sortedRunsJson = new Gson().toJson(runsList);
		return sortedRunsJson;
	}
	
	//uc3
	public String getFoursSixesWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.fours + data.sixes);
		this.sortData(runsList, runsComparator);
		String sortedRunsJson = new Gson().toJson(runsList);
		return sortedRunsJson;
	}
	
	//uc4
	public String getSROnFoursSixesWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		double max = 0, temp = 0;
		double maxSR = 0, tempSR = 0;
		String name = null;
		
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}

		for (int i = 0; i < runsList.size(); i++) 
		{
			temp = (runsList.get(i).fours * 4 + runsList.get(i).sixes * 6);
			tempSR = temp / runsList.get(i).bf;
			if (temp > max && tempSR > maxSR) 
			{
				max = temp;
				maxSR = tempSR;
				name = runsList.get(i).player;

			}
		}
		return name;
	}
	
	//uc5
	public String geStrikeRateAvgWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.avg);
		this.sortData(runsList, runsComparator);
		
		List<FactsheetMostRuns> tempList = runsList.stream().limit(10).collect(Collectors.toList());
		
		this.sortData(tempList, Comparator.comparing(data -> data.sr));
		
		String sortedRunsJson = new Gson().toJson(tempList);
		return sortedRunsJson;
	}
	
	//uc6
	public String geMAxRunsBestAvgWiseSortedRunsData() throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.runs);
		this.sortData(runsList, runsComparator);
		
		List<FactsheetMostRuns> tempList = runsList.stream().limit(10).collect(Collectors.toList());
		
		this.sortData(tempList, Comparator.comparing(data -> data.avg));
		
		String sortedRunsJson = new Gson().toJson(tempList);
		return sortedRunsJson;
	}
	
	//uc7
	public String getAvgWiseSortedWktsData() throws IPLLeagueAnalyserException 
	{
		if(wktsList == null || wktsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		wktsList.removeIf(data -> data.avg == 0);
		
		Comparator<FactsheetMostWkts> wktsComparator = Comparator.comparing(data -> data.avg, Comparator.reverseOrder());
		this.sortData(wktsList, wktsComparator);
		String sortedWktsJson = new Gson().toJson(wktsList);
		return sortedWktsJson;
	}
	
	//uc8
	public String getStrikeRateWiseSortedWktsData() throws IPLLeagueAnalyserException 
	{
		if(wktsList == null || wktsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		wktsList.removeIf(data -> data.sr == 0);
		
		Comparator<FactsheetMostWkts> wktsComparator = Comparator.comparing(data -> data.sr, Comparator.reverseOrder());
		this.sortData(wktsList, wktsComparator);
		String sortedWktsJson = new Gson().toJson(wktsList);
		return sortedWktsJson;
	}
	
	private <E> void sortData(List<E> list,Comparator<E> runsComparator) 
	{
		for (int i = 0; i < list.size()-1; i++) 
		{	
            for (int j = 0; j < list.size()-i-1; j++) 
            {
            	E data1 = list.get(j);
            	E data2 = list.get(j+1);
            	
                if (runsComparator.compare(data1, data2) < 0) 
                { 
                	list.set(j, data2);
                	list.set(j+1, data1);
                } 
            }
		}
	}
}
