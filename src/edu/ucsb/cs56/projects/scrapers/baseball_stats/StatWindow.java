package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;


/** StatWindow holds the table containing all of the player stats found in StatKeeper.  Adding search functionality.
    @author Sam Baldwin
    @author KennethToombs, Carson Holoien

*/
public class StatWindow extends JFrame
{
	private int width;
	private int height;
	
	public StatWindow(StatKeeper stats)
	{
		super("Stat Viewer");
		
		this.setSize(800, 500);
		
		this.setLayout(new BorderLayout());		
		
		// Create Table
		
		String[] columnNames = {"Full Name",
					"ID",
					"AB",
					"AVG",
					"OBP",
					"SLG",
					"OPS",
					"HR",
					"3B",
					"2B",
					"1B",
					"SO",
					"BB"};
					
		Object[][] data = new Object[stats.getPlayerCount()][13];

		//if(!searchBox.found()){
	       
		    for(int c1 = 0; c1 < stats.getPlayerCount(); c1 ++)
		    {
			data[c1][0] = stats.getPlayer(c1).getFullName();
			data[c1][1] = stats.getPlayer(c1).getID();
			data[c1][2] = StatCalculator.calculateAB(stats.getPlayer(c1));
			data[c1][3] = String.format("%.3f", StatCalculator.calculateAVG(stats.getPlayer(c1)));
			data[c1][4] = String.format("%.3f", StatCalculator.calculateOBP(stats.getPlayer(c1)));
			data[c1][5] = String.format("%.3f", StatCalculator.calculateSLG(stats.getPlayer(c1)));
			data[c1][6] = String.format("%.3f", StatCalculator.calculateOPS(stats.getPlayer(c1)));
			data[c1][7] = StatCalculator.calculateHR(stats.getPlayer(c1));
			data[c1][8] = StatCalculator.calculate3B(stats.getPlayer(c1));
			data[c1][9] = StatCalculator.calculate2B(stats.getPlayer(c1));
			data[c1][10] = StatCalculator.calculate1B(stats.getPlayer(c1));
			data[c1][11] = StatCalculator.calculateSO(stats.getPlayer(c1));
			data[c1][12] = StatCalculator.calculateBB(stats.getPlayer(c1));
		    }
		    /*	}
		else{
			data[0][0] = stats.getPlayer(c1).getFullName();
			data[0][1] = stats.getPlayer(c1).getID();
			data[0][2] = StatCalculator.calculateAB(stats.getPlayer(c1));
			data[0][3] = String.format("%.3f", StatCalculator.calculateAVG(stats.getPlayer(c1)));
			data[0][4] = String.format("%.3f", StatCalculator.calculateOBP(stats.getPlayer(c1)));
			data[0][5] = String.format("%.3f", StatCalculator.calculateSLG(stats.getPlayer(c1)));
			data[0][6] = String.format("%.3f", StatCalculator.calculateOPS(stats.getPlayer(c1)));
			data[0][7] = StatCalculator.calculateHR(stats.getPlayer(c1));
			data[0][8] = StatCalculator.calculate3B(stats.getPlayer(c1));
			data[0][9] = StatCalculator.calculate2B(stats.getPlayer(c1));
			data[0][10] = StatCalculator.calculate1B(stats.getPlayer(c1));
			data[0][11] = StatCalculator.calculateSO(stats.getPlayer(c1));
			data[0][12] = StatCalculator.calculateBB(stats.getPlayer(c1));
			}*/
		
		    

    
					
		JTable table = new JTable(data, columnNames);
		table.setAutoCreateRowSorter(true);

		TableColumn col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(180);
		
		JScrollPane scrollPane = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		
		this.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setLocation(560, 50);
		this.setVisible(true);
	}
}
