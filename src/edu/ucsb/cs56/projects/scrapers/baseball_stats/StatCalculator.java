package edu.ucsb.cs56.projects.scrapers.baseball_stats;

/** StatCalculator hold static utility methods for calculating various stats
 @author Sam Baldwin
*/
public class StatCalculator
{
	/** Returns the batting average for the player. 
		Batting average is calculated by the formula:     (1B + 2B + 3B + HR)/(PA-BB).   
		The official formula also involves sacrifice flys and so forth, however these are not accounted 
		for in this version of the program.

	    @param p Player to calculate stat for.
	*/
	public static float calculateAVG(Player p)
	{
		float avg = 0.0f;
		int atbats = 0;
		int hits = 0;
		
		atbats = p.getStatValue("PA") - p.getStatValue("Walk");
		
		if(atbats == 0)
		{
			return 0.0f;
		}
		
		hits = p.getStatValue("Single") + p.getStatValue("Double") + p.getStatValue("Triple") + p.getStatValue("Home Run");
		
		return (float)hits/(float)atbats;
	}

	/** Returns the plate appearances of the Player
	    @param p Player to calculate stat for.
	*/
	public static int calculatePA(Player p)
	{
		return p.getStatValue("PA");
	}
	
	/** Returns the official at-bats for the player. Calculated by:   PA - BB.     
		The official formula also involves sacrifice flys and so forth, however these are not accounted 
		for in this version of the program.
	    @param p Player to calculate stat for.
	*/
	public static int calculateAB(Player p)
	{
		return p.getStatValue("PA") - p.getStatValue("Walk");
	}
	
	/** Returns the on-base percentage for the player. 
		This is calculated by the formula:      (1B + 2B + 3B + HR + BB)/PA.      
		The official formula also involves sacrifice flys and so forth, however these are not 
		accounted for in this version of the program.

	    @param p Player to calculate stat for.
	*/
	public static float calculateOBP(Player p)
	{
		float avg = 0.0f;
		int pa = 0;
		int onbase = 0;
		
		pa = p.getStatValue("PA");
		
		onbase = p.getStatValue("Single") + 
			p.getStatValue("Double") + 
			p.getStatValue("Triple") + 
			p.getStatValue("Home Run") + 
			p.getStatValue("Walk");
		
		return (float)onbase/(float)pa;
	}
	
	/** Returns the slugging percentage for the player. 
		Calculated by:   (1*1B + 2*2B + 3*3B + 4*HR)/AB.     
		The official formula also involves sacrifice flys and so forth, however these are not accounted 
		for in this version of the program.

	    @param p Player to calculate stat for.
	*/
	public static float calculateSLG(Player p)
	{
		float avg = 0.0f;
		int atbats = 0;
		int slg = 0;
		
		atbats = p.getStatValue("PA") - p.getStatValue("Walk");
		
		if(atbats == 0)
		{
			return 0.0f;
		}
		
		slg = p.getStatValue("Single") + 2*p.getStatValue("Double") + 3*p.getStatValue("Triple") + 4*p.getStatValue("Home Run");
		
		return (float)slg/(float)atbats;
	}
	
	/** Returns the on-base plus slugging statistic. Calculated by:  OBP + SLG.     
		The official formula also involves sacrifice flys and so forth, however these are not accounted 
		for in this version of the program.
		
	    @param p Player to calculate stat for.
	*/
	public static float calculateOPS(Player p)
	{
		return calculateOBP(p) + calculateSLG(p);
	}
	
	public static int calculateHR(Player p)
	{
		return p.getStatValue("Home Run");
	}
	
	public static int calculate3B(Player p)
	{
		return p.getStatValue("Triple");
	}
	
	public static int calculate2B(Player p)
	{
		return p.getStatValue("Double");
	}
	
	public static int calculate1B(Player p)
	{
		return p.getStatValue("Single");
	}
	
	public static int calculateSO(Player p)
	{
		return p.getStatValue("Strikeout");
	}
	
	public static int calculateBB(Player p)
	{
		return p.getStatValue("Walk");
	}
}
