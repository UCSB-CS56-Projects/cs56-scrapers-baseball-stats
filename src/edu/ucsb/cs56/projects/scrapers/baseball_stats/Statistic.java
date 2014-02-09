package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;

/** Statisic represents one stat for a player. It has a name (String) and an integer or float value. 
	Statistic also contains an ArrayList of "splits" which represent the circumstances 
	underwhich the stat was earned. 
	Examples of names for Statistics are: "Single", "Double", "Home Run", "Strikeout", "Walk", etc. 
	All of the event names can be discovered by looking through the .xmls and reading the "event" 
	attributes under the at-bat elements. 
	
   @author Sam Baldwin
*/
public class Statistic
{
	private String name;
	
	private int iValue;
	private float fValue;
	
	boolean isFloat;
	
	ArrayList<Split> splits;
	
	public Statistic(String name, int value)
	{
		this.name = name;
		this.iValue = value;
		
		isFloat = false;
		
		splits = new ArrayList<Split>();
	}
	
	public Statistic(String name, float value)
	{
		this.name = name;
		this.fValue = value;
		
		isFloat = true;
		
		splits = new ArrayList<Split>();
	}
	
	public void increment(int i, ArrayList<Split> s)
	{
		this.iValue += i;
		
		for(int counter = 0; counter < s.size(); counter ++)
		{
			this.incrementSplit(s.get(counter));
		}
	}
	
	public void addSplit(Split s)
	{
		splits.add(s);	
	}
	
	public boolean hasSplit(Split s)
	{
		for(int counter = 0; counter < splits.size(); counter ++)
		{
			if(splits.get(counter).equals(s))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int getSplitIndex(Split s)
	{
		for(int counter = 0; counter < splits.size(); counter ++)
		{
			if(splits.get(counter).equals(s))
			{
				return counter;
			}
		}
		
		return -1;
	}
	
	public void incrementSplit(Split s)
	{
		int index = this.getSplitIndex(s);
		
		if(index == -1)
		{
			this.addSplit(s);
			return;
		}
		
		splits.get(index).increment(s.getValue());
	}
	
	public int getValue()
	{
		return iValue;
	}
	
	public int getIntValue()
	{
		return iValue;
	}
	
	public float getFloatValue()
	{
		return fValue;
	}
	
	public ArrayList<Split> getSplits()
	{
		return splits;
	}
	
	public boolean isFloat()
	{
		return isFloat;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean equals(Object o) 
	{
		if (o == null)
		    return false;
		if (!(o instanceof Statistic))
		    return false;

		Statistic s = (Statistic) o;

		if(s.getName().equals(this.getName()))
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
		String returnString = name + " = " + iValue;
		return returnString;
	}
}
