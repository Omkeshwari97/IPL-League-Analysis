package iplleagueanalysis;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IPLLeagueAnalysisTest 
{
	
	private static final String FILE_PATH_RUNS = "C:\\Users\\omkes\\eclipse-workspace\\IPLLeagueAnalysis\\FactsheetMostRuns.csv";
	private static final String FILE_PATH_WKTS = "C:\\Users\\omkes\\eclipse-workspace\\IPLLeagueAnalysis\\FactsheetMostWkts.csv";
	IPLLeagueAnalysis iplLeagueAnalysis = null;
	
	@Before
	public void setUp()
	{
		iplLeagueAnalysis = new IPLLeagueAnalysis();
	}
	
	//uc1
	@Test
	public void givenRunsCSVFile_WhenSortedOnBattingAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.getAvgWiseSortedRunsData();
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("MS Dhoni", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc2
	@Test
	public void givenRunsCSVFile_WhenSortedOnStrikeRate_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.getStrikeRateWiseSortedRunsData();
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("Ishant Sharma", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc3
	@Test
	public void givenRunsCSVFile_WhenSortedOnFourSixes_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.getFoursSixesWiseSortedRunsData();
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("Andre Russell", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc4
	@Test
	public void givenRunsCSVFile_WhenSortedOnSROnFourSixes_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String player = iplLeagueAnalysis.getSROnFoursSixesWiseSortedRunsData();
			assertEquals("Andre Russell", player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc5
	@Test
	public void givenRunsCSVFile_WhenSortedOnStrikeRateAndAverage_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.geStrikeRateAvgWiseSortedRunsData();
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("Andre Russell", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc6
	@Test
	public void givenRunsCSVFile_WhenSortedOnMaxRunsAndBestAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.geMAxRunsBestAvgWiseSortedRunsData();
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("David Warner ", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
}
