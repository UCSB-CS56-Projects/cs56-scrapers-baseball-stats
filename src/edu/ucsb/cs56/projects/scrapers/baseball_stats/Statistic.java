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

        /** Creates a Statistic with a name and a value of type integer
	    @param name name of statistic
	    @param value value of statistic as integer
        */
	public Statistic(String name, int value)
	{
		this.name = name;
		this.iValue = value;
		
		isFloat = false;
		
		splits = new ArrayList<Split>();
	}
	
        /** Creates a Statistic with a name and a value of type float
	    @param name name of statistic
	    @param value value of statistic as float
        */
	public Statistic(String name, float value)
	{
		this.name = name;
		this.fValue = value;
		
		isFloat = true;
		
		splits = new ArrayList<Split>();
	}

        /** Increments the ivalue and Split ArrayList by a specified value
	    @param i value to increment ivalue by
	    @param s Split to increment to the ArrayList of Splits
	 */
	public void increment(int i, ArrayList<Split> s)
	{
		this.iValue += i;
		
		for(int counter = 0; counter < s.size(); counter ++)
		{
			this.incrementSplit(s.get(counter));
		}
	}

        /** Adds a Split to the Split ArrayList	
	    @param s Split to be added
        */
	public void addSplit(Split s)
	{
		splits.add(s);	
	}

        /** Returns true if specified Split exists in the ArrayList of Splits
	    @param s Split to check for in the ArrayList of Splits
	*/ 
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
	
        /** Returns the index of the specified Split. Returns -1 if Split does not exist in the ArrayList of Splits. 
	    @param s Split to find in the ArrayList of Splits
	    @return index of the specified Split
        */
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
	
        /** Increments specific Split in ArrayList of Splits
	    @param s Split with value to increment
	*/
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
	
        /**
	   @return the iValue of the Statistic
	*/
	public int getValue()
	{
		return iValue;
	}
	
        /**
	   @return the iValue of the Statistic as an int
	*/
	public int getIntValue()
	{
		return iValue;
	}
	
        /**
	   @return the iValue of the Statistic as a float
	*/
	public float getFloatValue()
	{
		return fValue;
	}
	
        /**
	   @return the ArrayList of Splits
	*/
	public ArrayList<Split> getSplits()
	{
		return splits;
	}
	
        /**
	   @return true if float is being used instead of integer
	*/
	public boolean isFloat()
	{
		return isFloat;
	}
	
        /**
	   @return name of Statistic
	*/
	public String getName()
	{
		return this.name;
	}
	
        /** Compares two Statistics based on name
	    @param o Statistic to compare
	    @return true if both Statistics have same name
	*/
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

        /**
	   @return a string representation of Statistic's name and value
	*/
	public String toString()
	{
		String returnString = name + " = " + iValue;
		return returnString;
	}
}
