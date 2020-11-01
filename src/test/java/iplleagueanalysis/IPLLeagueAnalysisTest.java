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
	
	@Test
	public void givenRunsCSVFile_WhenSortedOnBattingAvg_ShouldReturnTopBattingAvg()
	{
		try 
		{
			iplLeagueAnalysis.loadRunsData(FILE_PATH_RUNS);
			String sortedRunsData = iplLeagueAnalysis.getAvgWiseSortedCensusData(FILE_PATH_RUNS);
			FactsheetMostRuns[] runsCSV = new Gson().fromJson(sortedRunsData, FactsheetMostRuns[].class);
			assertEquals("MS Dhoni", runsCSV[0].player);
		}
		catch (IPLLeagueAnalyserException e) 
		{
					e.printStackTrace();
		}
	}
}
