package iplleagueanalysis;

public class IPLLeagueAnalyserException extends Exception
{
	public enum ExceptionType
	{WRONG_STATISTICS_DATA, FILE_PROBLEM}
	
	public ExceptionType type;
	
	public IPLLeagueAnalyserException(String message, ExceptionType type)
	{
		super(message);
		this.type = type;
	}
}
