package iplleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class FactsheetMostRuns 
{
	@CsvBindByName(column = "POS", required = true)
	public int pos;
	
	@CsvBindByName(column = "PLAYER", required = true)
	public String player;
	
	@CsvBindByName(column = "Mat", required = true)
	public int mat;
	
	@CsvBindByName(column = "Inns", required = true)
	public int inns;
	
	@CsvBindByName(column = "NO", required = true)
	public int no;
	
	@CsvBindByName(column = "Runs", required = true)
	public int runs;
	
	@CsvBindByName(column = "HS", required = true)
	public String hs;
	
	@CsvBindByName(column = "Avg", required = true)
	public double avg;
	
	@CsvBindByName(column = "BF", required = true)
	public int bf;
	
	@CsvBindByName(column = "SR", required = true)
	public double sr;
	
	@CsvBindByName(column = "100", required = true)
	public int hundreds;
	
	@CsvBindByName(column = "50", required = true)
	public int fifties;
	
	@CsvBindByName(column = "4s", required = true)
	public int fours;
	
	@CsvBindByName(column = "6s", required = true)
	public int sixes;	
	
	@Override
	public String toString()
	{
		return "Player: " + player;
	}
}
