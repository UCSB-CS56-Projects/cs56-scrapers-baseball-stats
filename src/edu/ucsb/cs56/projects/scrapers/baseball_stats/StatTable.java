package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;

/** StatTable contains the values of the stats in a table format.

    @author Kenneth Toombs, Carson Holoien
*/

public class StatTable extends AbstractTableModel{
   
    Object[][] data;
    String[] columnNames = {"Full Name","ID","AB","AVG","OBP","SLG","OPS","HR","3B","2B","1B","SO","BB"};
    
    StatTable(StatKeeper stats){
	
	data = new Object[stats.getPlayerCount()][13];
	
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
	
    }

    public int getRowCount(){
	return data.length;
    }

    public int getColumnCount(){
	return 13;
    }

    public String getColumnName(int column){
	return columnNames[column];
    }

    public Object getValueAt(int row, int column){
	return data[row][column];
    }
				
}
