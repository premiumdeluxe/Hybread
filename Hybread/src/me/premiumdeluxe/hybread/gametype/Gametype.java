package me.premiumdeluxe.hybread.gametype;


public class Gametype
{
	String name;
	String description;
	int scoreLimit;
	int timeLimit;
	
	public Gametype(String name, String description, int scoreLimit, int timeLimit)
	{
		this.name = name;
		this.description = description;
		this.scoreLimit = scoreLimit;
		this.timeLimit = timeLimit;
	}
	
	public void load()
	{
		// place game specific objects (flags, zones, etc.)
		// teleport players to 
	}
	
	public void update()
	{
		// register kills
		// update points
	}
	
	public int getScoreLimit()
	{
		return scoreLimit;
	}
	
	public int getTimeLimit()
	{
		return timeLimit;
	}
}
