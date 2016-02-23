package edu.ucsb.cs56.projects.scrapers.baseball_stats;

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

        /** Creates a new Player with ID  
	   @param id the id number of the player
        */
	public Player(int id)
	{
		this(id, "Unknown");
	}
	
        /** Creates a new Player with id and first/last name  
	   @param id the ID number of the player
	   @param firstname the first name of the player
	   @param lastname the last name of the player
        */

	public Player(int id, String firstname, String lastname)
	{
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.fullName = firstName + " " + lastName;
		
		stats = new ArrayList<Statistic>();
	}

	/** Creates a new Player with id and full name  
	   @param id the ID number of the player
	   @param fullName the first name of the player
        */
	public Player(int id, String fullName)
	{
		this.id = id;
		this.firstName = "";
		this.lastName = "";
		this.fullName = fullName.substring(0,fullName.length()-1);
		setPlayerFirstLast(fullName);
		
		stats = new ArrayList<Statistic>();
	}

    //First and Last names will be set.
    public void setPlayerFirstLast(String fullName){
	boolean first = true;
	for(int i = 0; i <fullName.length(); i++){
	    if(fullName.charAt(i) == ' ' && first ){
		first = false;
	    }
	    else if(first){
		this.firstName = this.firstName + fullName.charAt(i);
	    }
	    else if (i < (fullName.length()-1)){
		this.lastName = this.lastName + fullName.charAt(i);
	    }
	}
    }
	
        /** Adds a Statistic to a player's Statistic ArrayList  
	   @param s the Statistic to add
        */
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
	
        /** Returns the index of a certain Statistic  
	   @param s the Statistic to find the index of
	   @return the Statistic's index
        */
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
	
        /** Returns the value of a certain Statistic  
	   @param stat the certain statistic
	   @return the Statistic's value
        */
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
        /**
	 @return player's ID number
	*/
	public int getID()
	{
		return id;
	}
	
        /**
	 @return player's first name
	*/
	public String getFirstName()
	{
		return firstName;
	}
	
        /**
	 @return player's last name
	*/
	public String getLastName()
	{
		return lastName;
	}
	
        /**
	 @return player's full name
	*/
	public String getFullName()
	{
		return fullName;
	}
	
        /**
	  @param s first name to set
	*/ 
	public void setFirstName(String s)
	{
		firstName = s;
	}
	
        /**
	  @param s last name to set
	*/ 
	public void setLastName(String s)
	{
		lastName = s;
	}
	
        /**
	  @param s full name to set
	*/ 
	public void setFullName(String s)
	{
		fullName = s;
	}
	
        /**
	 @return player's amount of different statistics stored
	*/
	public int getStatsAmount()
	{
		return stats.size();
	}
	
        /**
	 @param index used to search the Statistic ArrayList
	 @return player's statistic at a certain index
	*/
	public Statistic getStat(int index)
	{
		return stats.get(index);
	}
	
        /** Compares one player with another based on ID number
	 @param o player to compare
	 @return true if player has same ID, false otherwise
	*/
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

        /**
	   @return a string representation of the player's name, ID and stats
	   such as "Jim Jones| ID = 1234567: "
	*/
	public String toString()
	{
		String returnString= fullName + "| ID = " + id + ": ";
		
		for(int counter = 0; counter < stats.size(); counter ++)
		{
			returnString += stats.get(counter);
			
			if(counter != stats.size() - 1)
			{
				returnString += "\n";
			}
		}
		
		return returnString;
	}

}
