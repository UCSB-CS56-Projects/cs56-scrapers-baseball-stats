package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;

/** Split represents the circumstances in which a stat was earned. For example, the name of a split could be "vs. L" (vs. left handed pitcher) or "Runner on 2nd". Each Split holds a String name and an integer value representing how many times the stat was accrued under the circumstance represented by the name. If a player hit two doubles against a left handed pitchers, then the Statistic with name "double" would have a "vs. L" Split which would hold a value of 2.
   @author Sam Baldwin
*/
public class Split
{
	private String name;
	private int value;
	
	public Split(String name)
	{
		this(name, 0);
	}
	
	public Split(String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public void increment(int v)
	{
		this.value += v;
	}
	
	public void setValue(int v)
	{
		this.value = v;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean equals(Object o) 
	{
		if (o == null)
		    return false;
		if (!(o instanceof Split))
		    return false;

		Split p = (Split) o;

		if(p.getName().equals(this.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
}
