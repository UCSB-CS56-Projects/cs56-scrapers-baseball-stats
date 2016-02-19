package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** SearchPlayer is a class that will implement JFrame and Jtextfield to search for a player in the players list.  It will save the players index value.*/

public class SearchPlayer extends JFrame {
    
    private int playerIndex;
    private String name;

    private JTextField searchBox;
    private Player  curPlayer;
	    
    private String  curPlayerFirst;
    private String  curPlayerLast;
    private String  curPlayerFullName;

    public SearchPlayer(StatKeeper stats){
	
	super("Player Search");
	this.setSize(300, 65);

	JTextField searchBox = new JTextField(25);
	
	searchBox.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		   
		    setName(searchBox.getText() );
		    
		    setPlayerIndex( searchForPlayer( getName(), stats) );
		    
		    System.out.println( getPlayerIndex() + "");
		}
	    });
	

	this.add(searchBox);
	this.setLocation(220, 455);
	this.setVisible(true);
	
    }

    public int searchForPlayer(String playerName, StatKeeper statistics){
	
	Player playerToFind = new Player(0, playerName);
	
	System.out.println(playerName);
	playerName = playerName;
	for(int i = 0; i< statistics.getPlayerCount(); i++){

	    curPlayer = statistics.getPlayer(i); 
	    
	    curPlayerFirst = curPlayer.getFirstName();
	    curPlayerLast = curPlayer.getLastName();
	    curPlayerFullName = statistics.getPlayerName(i);
	    
	    System.out.println(curPlayerFullName + i);
		    
	    //if((playerToFind.getFirstName()).equalsIgnoreCase(curPlayerFirst)||playerToFind.getLastName().equalsIgnoreCase(curPlayerLast)){
	    //return i;
	    // }else{
	   
	    //	System.out.println("|"+playerName + "|" + curPlayerFullName + "|");
	    //}
	}
	return -1;
    }

    public void setName(String name){
	this.name = name;
    }

    public String getName(){
	return name;
    }

    private void setPlayerIndex(int playerIndex){
	this.playerIndex = playerIndex;
    }

    private int getPlayerIndex(){
	return playerIndex;
    }

    
    // public findName(){
    //}
}
