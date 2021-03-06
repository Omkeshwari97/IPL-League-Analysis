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
			assertEquals("David Warner", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc7
	@Test
	public void givenWktsCSVFile_WhenSortedOnBowlingAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getAvgWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Anukul Roy", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc8
	@Test
	public void givenWktsCSVFile_WhenSortedOnStrikeRate_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getStrikeRateWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Alzarri Joseph", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}

	//uc9
	@Test
	public void givenWktsCSVFile_WhenSortedOnEconomy_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getEconomyWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Shivam Dube", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc10
	@Test
	public void givenWktsCSVFile_WhenSortedOnStrikeRate5w4w_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getSR5w4wWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Alzarri Joseph", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}

	//uc11
	@Test
	public void givenWktsCSVFile_WhenSortedOnBowlingAvgAndStrikeRate_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getBowlingavgSRWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Anukul Roy", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc12
	@Test
	public void givenWktsCSVFile_WhenSortedOnWicketsAndAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String sortedWktsData = iplLeagueAnalysis.getWicketsAndAverageWiseSortedWktsData();
			FactsheetMostWkts[] wktsCSV = new Gson().fromJson(sortedWktsData, FactsheetMostWkts[].class);
			assertEquals("Imran Tahir", wktsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc13
	@Test
	public void givenRunsAndWktsCSVFile_WhenSortedOnBattingSAvgBowlingAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String playerData = iplLeagueAnalysis.getBattingAvgBowlingAvgWiseSortedData();
			String[] player = new Gson().fromJson(playerData, String[].class);
			assertEquals("Andre Russell", player[0]);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc14
	@Test
	public void givenRunsAndWktsCSVFile_WhenSortedOnRunsAndWickets_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			iplLeagueAnalysis.loadWktsData(FILE_PATH_WKTS);
			String playerData = iplLeagueAnalysis.getRunsAndWicketsWiseSortedData();
			String[] player = new Gson().fromJson(playerData, String[].class);
			assertEquals("Andre Russell", player[0]);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc15
	@Test
	public void givenRunCSVFile_WhenSortedOn100sAndBattingAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.get100sAndBattingAvgWiseSortedData();
			FactsheetMostRuns[] runsCsv = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("David Warner", runsCsv[0].player);
			assertEquals("Jonny Bairstow", runsCsv[1].player);			
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
	
	//uc16
	@Test
	public void givenRunCSVFile_WhenSortedOnXero100s50sAndBattingAvg_ShouldReturnTopDesiredPlayer()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.getZero100s50sAndBattingAvgWiseSortedData();
			FactsheetMostRuns[] runsCsv = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("Marcus Stoinis", runsCsv[0].player);	
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
}
