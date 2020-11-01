package iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

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

	public String getAvgWiseSortedCensusData(String filePath) throws IPLLeagueAnalyserException 
	{
		if(runsList == null || runsList.size() == 0)
		{
			throw new IPLLeagueAnalyserException("No census data", ExceptionType.WRONG_STATISTICS_DATA);
		}
		
		Comparator<FactsheetMostRuns> runsComparator = Comparator.comparing(data -> data.avg);
		this.sortRunsData(runsComparator);
		String sortedRunsJson = new Gson().toJson(runsList);
		return sortedRunsJson;
	}

	private void sortRunsData(Comparator<FactsheetMostRuns> runsComparator) 
	{
		for (int i = 0; i < runsList.size()-1; i++) 
		{	
            for (int j = 0; j < runsList.size()-i-1; j++) 
            {
            	FactsheetMostRuns data1 = runsList.get(j);
            	FactsheetMostRuns data2 = runsList.get(j+1);
            	
                if (runsComparator.compare(data1, data2) < 0) 
                { 
                	runsList.set(j, data2);
                	runsList.set(j+1, data1);
                } 
            }
		}
	}
}
