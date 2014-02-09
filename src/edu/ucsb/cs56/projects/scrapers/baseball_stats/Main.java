package edu.ucsb.cs56.projects.scrapers.baseball_stats;

/** Main is a class that contains the main() method. The program starts here.
 @author Sam Baldwin
*/

public class Main
{
	public static MainWindow mainwindow;
	public static StatReader statReader;
	public static StatKeeper statKeeper;

	public static void main(String args[])
	{
		mainwindow = new MainWindow(500, 375);
		statReader = new StatReader();
		statKeeper = new StatKeeper();
		
		//statReader.readStats(1, 6, 2012, 1, 6, 2012);
	}
	
	public static MainWindow getMainWindow()
	{
		return mainwindow;
	}
	
	public static StatReader getStatReader()
	{
		return statReader;
	}
	
	public static StatKeeper getStatKeeper()
	{
		return statKeeper;
	}
}
