package edu.ucsb.cs56.S12.sbaldwin.baseball;

import org.xml.sax.*;
import java.util.StringTokenizer;

/** XMLContentHandler holds all of the call-back functions for the XML parser. When it receives elements, it searches for attributes such as events balls, strikes, rbis, etc. It then sends this data to the StatKeeper class.
 @author Sam Baldwin
*/
public class XMLContentHandler implements ContentHandler
{
	boolean inInning;
	private int year;
	private int month;
	private int day;
	
	private StatManager statManager;
	
	public XMLContentHandler()
	{
		inInning = false;
		year = -1;
		month = -1;
		day = -1;
	}
	
	public void setDate(int day, int month, int year)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	/** Helper method for parsing the player name from the description of a play. In the description of an event, the player's name is always listed first. Because of this, parseName searches for all of the words at the beginning of the String that begin with a capital letter and concatenates them together into the full name. This is Used by startElement() to discover the name of the player.
	*/
	private String parseName(String s)
	{
		String fullName = "";

		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens())
		{
			String tok = st.nextToken();
			if(Character.isUpperCase(tok.charAt(0)))
			{
				fullName += tok + " ";
			}
			else
			{
				break;
			}
 		}
 		
 		fullName.trim();
		
		return fullName;
	}
	
	// ContentHandler interface Methods
	
	public void startDocument() 
	{
		inInning = false;
		
		this.statManager = Main.statReader.getStatManager();
		this.statManager.startNewGame(day, month, year);
	}
	
	public void endDocument()
	{
		this.statManager.endGame();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes atts)
	{
		// Check to see if within an inning. If not, then don't do anything.
		if(qName.equals("inning"))
		{
			inInning = true;
			return;
		}
		else if(inInning == false)
		{
			return;
		}
		
		if(qName.equals("atbat"))
		{
			int id = Integer.parseInt(atts.getValue(atts.getIndex("batter")));
			String fullName = this.parseName(atts.getValue(atts.getIndex("des")));	
			String event = atts.getValue(atts.getIndex("event"));	
			Statistic s = new Statistic(event, 1);
			
			// First increment Plate Appearance
			statManager.incrementPlayerStat(id, new Statistic("PA", 1));
			
			// Then the event
			statManager.incrementPlayerStat(id, s);
			
			// Then set the name
			statManager.setPlayerName(id, fullName);
		}
	}
		
	public void endElement(String uri, String localName, String qName) 
	{
		if(qName.equals("inning"))
		{
			inInning = false;
			return;
		}
	}
	
	public void characters(char[] ch, int start, int length)
	{
	
	}
	
	public void endPrefixMapping(String prefix) 
	{
	
	}
	
	public void ignorableWhitespace(char[] ch, int start, int length) 
	{
	
	}
	
	public void processingInstruction(String target, String data)
	{
	
	}
	
	public void setDocumentLocator(Locator locator) 
	{
	
	}
	
	public void skippedEntity(String name)
	{
	
	}
	
	public void startPrefixMapping(String prefix, String uri)
	{
	
	}
	
}
