package edu.ucsb.cs56.S12.sbaldwin.baseball;

import java.util.ArrayList;

/** StatManager manages all of the statistics. It receives stats from XMLContentHandler and changes player stats accordingly.
 @author Sam Baldwin
*/
public class StatManager
{
	private ArrayList<Player> players;
	
	private int year;
	private int month;
	private int day;
	
	public StatManager()
	{
		players = new ArrayList<Player>(30);
		year = -1;
	}
	
	/** Takes in an input Statistic and player ID and increments that players Statistic by the input Statistic's value. If the Statistic does not already exist in the player then a new instance is created.
	
	     @param id The ID of the player to add the Statistic to
	     @param stat The statistic to increment
	 
	*/
	public void incrementPlayerStat(int id, Statistic stat)
	{
		int index = this.getPlayerIndex(id);
		
		if(index == -1)
		{
			Player p = new Player(id);
			p.addStatistic(stat);
			players.add(p);
			
			return;
		}
		
		players.get(index).addStatistic(stat);
	}
	
	/** returns the index in the ArrayList of the player with the input ID
	    @param id ID of the player to search for	 
	*/
	public int getPlayerIndex(int id)
	{
		for(int counter = 0; counter < players.size(); counter ++)
		{
			if(players.get(counter).getID() == id)
			{
				return counter;
			}
		}
		
		return -1;
	}
	
	public void setPlayerName(int id, String fullName)
	{
		int index = this.getPlayerIndex(id);
		
		if(index == -1)
		{
			return;
		}
		
		players.get(index).setFullName(fullName);
	}
	
	/** Saving for later use. Not currently useful.	 
	*/
	public void startNewGame(int day, int month, int year)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/** Tells the StatManager that the current game is over. The StatManager then sends the Player list to StatKeeper and then creates a new ArrayList of players to get ready for the next game.
	 
	*/
	public void endGame()
	{		
		Main.getStatKeeper().addPlayer(players);
		
		//System.out.println("\n" + this);
		
		players = new ArrayList<Player>(30);		
	}
	
	public String toString()
	{
		String returnString = "Game Stats:\n";
		
		for(int counter = 0; counter < players.size(); counter ++)
		{
			returnString += players.get(counter) + "\n";
		}
		
		return returnString;
	}
}
