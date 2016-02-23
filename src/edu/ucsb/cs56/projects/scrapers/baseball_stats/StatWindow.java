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
	
    public StatWindow(StatKeeper stats)
    {
	    
	   
	super("Stat Viewer");
		
	this.setSize(800, 500);
		
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
	JPanel searchBox = new JPanel();	
	JTextField textField = new JTextField(25);
	textField.setEditable(true);
	textField.requestFocus();
	search = new SearchPlayer(stats);
	
	String output = "";
	
	
	textField.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    search.clearSearch();
		    search.searchForPlayer(textField.getText(), stats);
		    
		    if(!search.playerFound){
		       	search.fuzzySearch(textField.getText(), stats);
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
	
	JLabel label1 = new JLabel("Search for a Player: ");
	searchBox.add(label1);
	//textField.setVisible(true);
	searchBox.add(textField);
	//End of Atempt.

	
	//searchBox = new SearchPlayer(stats);
	System.out.println("After");

	add(searchBox,BorderLayout.PAGE_END);
		
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
