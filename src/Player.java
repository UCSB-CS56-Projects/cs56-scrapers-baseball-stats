package edu.ucsb.cs56.S12.sbaldwin.baseball;

import java.util.ArrayList;

/** Player hold all of the statistics for one player. 
 @author Sam Baldwin
*/
public class Player
{
	private int id;
	
	String firstName;
	String lastName;
	
	String fullName;
	
	ArrayList<Statistic> stats;
	
	public Player(int id)
	{
		this(id, "Unknown");
	}
	
	public Player(int id, String firstname, String lastname)
	{
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.fullName = firstName + " " + lastName;
		
		stats = new ArrayList<Statistic>();
	}
	
	public Player(int id, String fullName)
	{
		this.id = id;
		this.fullName = fullName;
		
		stats = new ArrayList<Statistic>();
	}
	
	public void addStatistic(Statistic s)
	{
		int index = getStatisticIndex(s);
		
		if(index == -1)
		{
			stats.add(s);
			return;
		}
		
		stats.get(index).increment(s.getValue(), s.getSplits());
	
	}
	
	public int getStatisticIndex(Statistic s)
	{
		for(int counter = 0; counter < stats.size(); counter ++)
		{
			if(stats.get(counter).equals(s))
			{
				return counter;
			}
		}
		
		return -1;
	}
	
	public int getStatValue(String stat)
	{
		Statistic s = new Statistic(stat, 0);
		int index = this.getStatisticIndex(s);
		
		if(index == -1)
		{
			return 0;
		}
		
		return this.getStat(index).getValue();	
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setFirstName(String s)
	{
		firstName = s;
	}
	
	public void setLastName(String s)
	{
		lastName = s;
	}
	
	public void setFullName(String s)
	{
		fullName = s;
	}
	
	public int getStatsAmount()
	{
		return stats.size();
	}
	
	public Statistic getStat(int index)
	{
		return stats.get(index);
	}
	
	public boolean equals(Object o) 
	{
		if (o == null)
		    return false;
		if (!(o instanceof Player))
		    return false;

		Player p = (Player) o;

		if(p.getID() == (this.getID()))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	public String toString()
	{
		String returnString= fullName + "| ID = " + id + ": ";
		
		for(int counter = 0; counter < stats.size(); counter ++)
		{
			returnString += stats.get(counter);
			
			if(counter != stats.size() - 1)
			{
				returnString += ", ";
			}
		}
		
		return returnString;
	}

}
