package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/** MainWindow is the primary window for the program. It containes a JFrame and manages the MainPanel
    @author Sam Baldwin
*/
public class MainWindow
{
	JFrame frame;
	public int width;
	public int height;

	public MainWindow(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		frame = new JFrame("MLB Stat Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel mp = new MainPanel(width, height);

		frame.setSize(width, height);		
		frame.getContentPane().add(BorderLayout.CENTER, mp);		
		frame.setLocation(50, 50);
		frame.setVisible(true);
		
		// Account for size of Border
		Insets insets = frame.getInsets();
		frame.setSize((width + insets.left + insets.right), (height + insets.top + insets.bottom));
	}
}
