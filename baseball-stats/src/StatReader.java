package edu.ucsb.cs56.S12.sbaldwin.baseball;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

/** StatReader sets up the SAXParserFactory and proper XMLParser. It then parses through all of the XML data which is sent to the StatKeeper class.
 @author Sam Baldwin
*/
public class StatReader
{
	private SAXParserFactory factory;
	private SAXParser parser;
	private XMLReader reader;
	private XMLContentHandler handler;
	
	private StatManager statManager;
	
	public StatReader()
	{
		// Get SAX Parser Factory
   		factory = SAXParserFactory.newInstance();

    		// Turn on validation, and turn off namespaces
    		factory.setValidating(false);
    		factory.setNamespaceAware(false);
		factory.setXIncludeAware(false);
		
		try
		{
			parser = factory.newSAXParser();
		} 
		catch (Exception ex)
		{
			// Error Code here
			System.out.println("Error creating new SAXParser.");
		}
		
		try
		{
			reader = parser.getXMLReader();
		} 
		catch (Exception ex)
		{
			// Error Code here
			System.out.println("Error creating new XMLReader.");
		}
		
		handler = new XMLContentHandler();
		reader.setContentHandler(handler);
		
		statManager = new StatManager();
	}
	
	/** reads in a block of statistics starting in the start parameters and going until it reaches the end parameters.
	
	     @param startDay The day of the month to start XML parsing
	     @param startMonth The month of the year to start XML parsing
	     @param startYear The year to start XML parsing
	     
	     @param endDay The day of the month to end XML parsing
	     @param endMonth The month of the year to end XML parsing
	     @param endYear The year to end XML parsing
	 
	*/
	public void readStats(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear)
	{		
	
		// The for loop searches through all of the proper folders and then parses each day
		for(int year = startYear; year <= endYear; year ++)
		{
			if(year == endYear)
			{
				for(int month = startMonth; month <= endMonth; month ++)
				{
					if(month == endMonth)
					{
						for(int day = startDay; day <= endDay; day ++)
						{
							parseDay(day, month, year);
						}
					}
					else
					{
						for(int day = 1; day <= 31; day ++)
						{
							parseDay(day, month, year);
						}
					}
				}
			}
			else
			{
				for(int month = 1; month <= 12; month ++)
				{
					for(int day = 1; day <= 31; day ++)
					{
						parseDay(day, month, year);
					}
				}
			}
		}
				
		//parser.parse(cl.getResource("Stats/TilesetMain.bmp"), new XMLContentHandler());
	}
	
	/** Helper method for readStats(). Searches for all games in the folder and parses each found .xml file. This should only be called by the readStats() method.
	*/
	private void parseDay(int day, int month, int year)
	{
		String classpath = System.getProperties().getProperty("java.class.path", null);
		String path = classpath + "/Stats/Games/Year_" + year + "/Month_" + month + "/Day_" + day + "/";
		
		File folder = new File(path);
		
		System.out.println("Searching in folder: " + path);
		
		if(folder == null)
		{
			System.out.println("Path was null.");
			return;
		}
		
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles == null || listOfFiles.length == 0)
		{
			System.out.println("There were no files in the path.");
			return;
		}
		
		handler.setDate(day, month, year);
		
		for(int counter = 0; counter < listOfFiles.length; counter ++)
		{
			if(listOfFiles[counter].isFile())
			{
				if(listOfFiles[counter].getName().endsWith(".xml") || listOfFiles[counter].getName().endsWith(".XML"))
				{
					System.out.println("Parsing file: " + listOfFiles[counter].getPath());
					
					long startTime = System.nanoTime();
					try
					{
						reader.parse(listOfFiles[counter].getPath());
					}
					catch(Exception ex)
					{
						System.out.println("Error parsing XML file: " + listOfFiles[counter].getPath());
					}
					
					long elapsedTimeNS = System.nanoTime() - startTime;
					
					// Convert from nanoseconds to seconds
					double elapsedTime = (float)elapsedTimeNS / 1000000000.0;
					
					System.out.println("Done (" + String.format("%.4f", elapsedTime) + " seconds)");
				}
			}
		}
	}
	
	/** reads in the hard-coded files for cp3 
	*/	
	public void readDemoStats()
	{
		ClassLoader cl = getClass().getClassLoader();
		
		Main.getStatKeeper().newStats();
		
		System.out.println("Parsing file: " + "Stats/DemoFiles/lan_col_gameEvents.xml");
					
		long startTime = System.nanoTime();
		
		try
		{
			reader.parse(cl.getResource("Stats/DemoFiles/06_01_2012_lan_col_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_02_2012_lan_col_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_03_2012_lan_col_gameEvents.xml").toString());
			
			reader.parse(cl.getResource("Stats/DemoFiles/06_01_2012_nya_det_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_02_2012_nya_det_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_03_2012_nya_det_gameEvents.xml").toString());
			
			reader.parse(cl.getResource("Stats/DemoFiles/06_01_2012_bos_tor_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_02_2012_bos_tor_gameEvents.xml").toString());
			reader.parse(cl.getResource("Stats/DemoFiles/06_03_2012_bos_tor_gameEvents.xml").toString());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
					
		long elapsedTimeNS = System.nanoTime() - startTime;
					
		// Convert from nanoseconds to seconds
		double elapsedTime = (float)elapsedTimeNS / 1000000000.0;
					
		System.out.println("Done (" + String.format("%.4f", elapsedTime) + " seconds)");
	}
	
	public StatManager getStatManager()
	{
		return statManager;
	}

}
