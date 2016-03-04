package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

/** SearchPlayer is a class that will implement JFrame and Jtextfield to search for a player in the players list.  It will save the players index value.*/

public class SearchPlayer// extends JPanel
				  
{
    // private JPanel panel;
    private String name;
    private ArrayList<Player> searchResults;
    boolean playerFound;
    JTextField textField;
    

    public SearchPlayer(StatKeeper stats){
	super();
	searchResults = new ArrayList<Player>();
	
	/*	
	JTextField textField = new JTextField(25);
	textField.setEditable(true);
	textField.requestFocus();
	
	textField.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    playerFound = false;
		    searchResults.clear();
		    
		    searchForPlayer(textField.getText(), stats);
		    
		    if(!playerFound){
		       	fuzzySearch(textField.getText(), stats);
		    }
	    
		}
	    });
	
	JLabel label1 = new JLabel("Search for a Player: ");
	this.add(label1);
	//textField.setVisible(true);
	this.add(textField);
	*/
    }

    public void searchForPlayer(String playerName, StatKeeper statistics){

	Player playerToFind = new Player(0, playerName);
	    
	String  curPlayerFirst;
	String  curPlayerLast;
	String  curPlayerFullName;

	String playerToFindFirst = playerToFind.getFirstName();
	String playerToFindLast = playerToFind.getLastName();
	String playerToFindFull = playerToFind.getFullName();
	
	System.out.println(playerName);
	playerName = playerName;
	for(int i = 0; i< statistics.getPlayerCount(); i++){

	    Player curPlayer = new Player(statistics.getPlayer(i).getID(), statistics.getPlayer(i).getFullName()); 
	    
	    curPlayerFirst = curPlayer.getFirstName();
	    curPlayerLast = curPlayer.getLastName();
	    curPlayerFullName = statistics.getPlayerName(i).trim();
	  
		    
	    if((playerName.equalsIgnoreCase(curPlayerFirst)
	       ||playerName.equalsIgnoreCase(curPlayerLast))
	       ||(playerName.equalsIgnoreCase(curPlayerFullName)))
		{
		    System.out.println("DirectSearch");
		    playerFound = true;
		    searchResults.add(statistics.getPlayer(i));
      		}
	}
    }

    public void fuzzySearch(String playerName, StatKeeper statistics){

        Player playerToFind = new Player(0, playerName);
	    
	String  curPlayerFirst;
	String  curPlayerLast;
	String  curPlayerFullName;

	String playerToFindFirst = playerToFind.getFirstName();
	String playerToFindLast = playerToFind.getLastName();
	String playerToFindFull = playerToFind.getFullName();
	
	for(int i = 0; i < statistics.getPlayerCount(); i++){
	    

	    Player curPlayer = new Player(statistics.getPlayer(i).getID(), statistics.getPlayer(i).getFullName()); 
	    
	    curPlayerFirst = curPlayer.getFirstName();
	    curPlayerLast = curPlayer.getLastName();
	    curPlayerFullName = statistics.getPlayerName(i).trim();
	    
	    //System.out.println(percentSimilar(curPlayerFirst,playerToFindFirst)+"");
	    if(percentSimilar(curPlayerFirst,playerToFindFirst) > 0.50){
		
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
	    //System.out.println(percentSimilar(curPlayerLast,playerToFindLast)+"");
	    if(percentSimilar(curPlayerLast,playerToFindLast) > 0.50){
		//	System.out.println("FuzzySearch: Last");
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
	    //System.out.println(percentSimilar(curPlayerFullName,playerToFindFull)+"");
	    if(percentSimilar(curPlayerFullName,playerToFindFull) > 0.50){
		//	System.out.println("FuzzySearch: Fullname");
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
	    if(percentSimilar(curPlayerFirst,playerName) > 0.50){
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
	    if(percentSimilar(curPlayerLast,playerName) > 0.50){
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
	    if(percentSimilar(curPlayerFullName,playerName) > 0.50){
		playerFound = true;
		searchResults.add(statistics.getPlayer(i));
		return;
	    }
		
	}
    }

    public double percentSimilar(String name1, String name2){
	int min = Math.min(name1.length(), name2.length());
	double matches = 0.0;
	for(int i = 0; i < min; i++){
	    if(Character.toLowerCase(name1.charAt(i)) == Character.toLowerCase(name2.charAt(i))){
		matches++;
	    }
	}

	if(min != 0)
	    return matches/min;
	else
	    return 0.0;
    }

    public ArrayList<Player> getSearchResults(){
	return searchResults;
    }

    public String toString(){
	String results = "";
	if(searchResults.size() > 0){
	    for(int i = 0; i < searchResults.size(); i++){
		results = results +
		    "Full Name: " + searchResults.get(i).getFullName() + "\n" +
		    "ID: " + searchResults.get(i).getID() + "\n" +
		    "AB: " + StatCalculator.calculateAB(searchResults.get(i))+ "\n"+
		    "AVG: " + String.format("%.3f", StatCalculator.calculateAVG(searchResults.get(i)))+ "\n" + 
		    "OBP: " + String.format("%.3f", StatCalculator.calculateOBP(searchResults.get(i)))+ "\n" +
		    "SLG: " + String.format("%.3f", StatCalculator.calculateSLG(searchResults.get(i)))+ "\n" +
		    "OPS: " + String.format("%.3f", StatCalculator.calculateOPS(searchResults.get(i))) + "\n" +
		    "HR: " + StatCalculator.calculateHR(searchResults.get(i))+ "\n" + 
		    "3B: " + StatCalculator.calculate3B(searchResults.get(i))+ "\n" +
		    "2B: " + StatCalculator.calculate2B(searchResults.get(i))+ "\n" +
		    "1B: " + StatCalculator.calculate1B(searchResults.get(i))+ "\n" +
		    "SO: " + StatCalculator.calculateSO(searchResults.get(i))+ "\n" +
		    "BB: " + StatCalculator.calculateBB(searchResults.get(i))+ "\n";
	    }
	    return results;
	}else
	    return "Player does not exist.";
    }

    public StatKeeper toStatKeeper(){
	StatKeeper stats = new StatKeeper(searchResults);
	return stats;
    }

    public void setName(String name){
	this.name = name;
    }

    public String getName(){
	return name;
    }

    public void clearSearch(){
	searchResults.clear();
    }

   
}
