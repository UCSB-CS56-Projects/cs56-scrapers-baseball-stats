package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;
import javax.swing.JTextArea;


/** StatWindow holds the table containing all of the player stats found in StatKeeper.  Adding search functionality.
    @author Sam Baldwin
    @author KennethToombs, Carson Holoien

*/
public class StatWindow extends JFrame
{
    private int width;
    private int height;
    StatTable statTable;
    SearchPlayer search;
    ArrayList<Player> allStars = new ArrayList<Player>();
	
    public StatWindow(StatKeeper stats)
    {
	    
	   
	super("Stat Viewer");
		
	this.setSize(1050, 500);
		
	this.setLayout(new BorderLayout());		   

   
	statTable = new StatTable(stats);

	//Construct Table
	JTable table = new JTable(statTable);
	table.setAutoCreateRowSorter(true);

		
	TableColumn col = table.getColumnModel().getColumn(0);
	col.setPreferredWidth(180);

	table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 2) {
			JTable target = (JTable)e.getSource();
			int row = target.getSelectedRow();
			int column = target.getSelectedColumn();
			
		        JFrame playerFrame = new JFrame("Player Frame");
			JTextArea playerSpecs = new JTextArea((stats.getPlayer(row).toString()));
			playerFrame.add(playerSpecs);
			playerFrame.setSize(300, 200);
			playerFrame.setLocation(560,560);
			playerFrame.setVisible(true);
		    }
		}
	    });
       
	JScrollPane scrollPane = new JScrollPane(table);
	
	add(scrollPane, BorderLayout.CENTER);
	System.out.println("Before");


	
	//Atempt at Action listener in StatWindow.
	JPanel left = new JPanel();
	left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
	JPanel bottom = new JPanel();	
	JTextField textField = new JTextField(25);
	JTextField buildTeam = new JTextField("Enter ID #: ");
	JTextArea instructions = new JTextArea("How to create your\nown fantasy team:\nTo create a fantasy team,\nenter a player's ID number\nand hit enter. The ID number will\nbe cleared automatically after\nhitting enter, so do this 9 times\nto create a complete roster.");
	
	textField.setEditable(true);
	textField.requestFocus();
	search = new SearchPlayer();
	SearchPlayer buildTeamSearch = new SearchPlayer();
	
	String output = "";
	
	
	textField.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    search.clearSearch();
		    search.searchForPlayer(textField.getText(),stats);
		    
		    if(!search.playerFound){
		       	search.fuzzySearch(textField.getText(),stats);
		    }
		   
		    
		    System.out.println(search.getSearchResults());
		        JFrame searchResultFrame = new JFrame("Search Result Frame");
			JTextArea playerSpecs = new JTextArea();
			playerSpecs.append(search.toString());
			searchResultFrame.add(playerSpecs);
			searchResultFrame.setSize(200, 600);
			searchResultFrame.setVisible(true);
		      
		}
	    });


	buildTeam.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    int thisPlayer = Integer.parseInt(buildTeam.getText());
		    
		    for(int i = 0; i < stats.getPlayerCount(); i++){
			if(thisPlayer == stats.getPlayer(i).getID())
			    allStars.add(stats.getPlayer(i));
		    }
		    
		   
		    if(allStars.size() == 9){
			String results = "";
			JFrame fantasyTeam = new JFrame("Your Fantasy Team");
			JTextArea team = new JTextArea();
			JScrollPane scroll = new JScrollPane(team);
			 for(int i = 0; i < allStars.size(); i++){
			     results = results + allStars.get(i).getFullName()+  " AVG: " + String.format("%.3f", StatCalculator.calculateAVG(allStars.get(i))) + 
				 " OBP: " + String.format("%.3f", StatCalculator.calculateOBP(allStars.get(i)))+ " SLG: " + String.format("%.3f", StatCalculator.calculateSLG(allStars.get(i)))+"\n";}
			fantasyTeam.add(scroll);
			team.append(results);
			fantasyTeam.add(team);
			fantasyTeam.setSize(350, 400);
			fantasyTeam.setVisible(true);
		    }
						
		    buildTeam.setText(""); 
		}
	    });
	
	bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
	JLabel label1 = new JLabel("Search for a Player: ");
	JLabel label2 = new JLabel("Build Fantasy Team: ");
	bottom.add(label2);
	bottom.add(buildTeam);
		
	bottom.add(label1);
	//textField.setVisible(true);
	bottom.add(textField);

	left.add(instructions);
	//End of Atempt.

	
	//searchBox = new SearchPlayer(stats);
	System.out.println("After");

	add(bottom,BorderLayout.PAGE_END);
	add(left,BorderLayout.WEST);
		
		
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	this.setLocation(560, 50);
	this.setVisible(true);
    }

    /* public void createTable(Search searchBox){
       if(searchBox.getSearchResults().size()){
       statTable = new StatTable(searchBox.toStatKeeper());
       }
       }*/
}
