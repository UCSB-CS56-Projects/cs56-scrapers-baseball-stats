package edu.ucsb.cs56.S12.sbaldwin.baseball;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.KeyEvent;

/** MainPanel is the main panel that goes into the Frame.
 @author Sam Baldwin
*/
public class MainPanel extends JPanel implements ActionListener
{
	private int width;
	private int height;
	
	private BufferedImage background;
	
	private JButton defaultButton;

	private StatWindow statwindow;

	public MainPanel(int width, int height)
	{
		super();
		
		this.setLayout(null);
		
		this.width = width;
		this.height = height;
		
		ClassLoader cl = getClass().getClassLoader();
		
		// Load in Image
		try
		{
			background = ImageIO.read(cl.getResource("images/Baseball.jpg"));
		} 
		catch(IOException ie){
			System.out.println("Error loading in Images");
		}
		
		defaultButton = new JButton("Load Demo Stats");
		defaultButton.setBounds(300, 120, 160, 20);
		defaultButton.addActionListener(this);
		this.add(defaultButton);
	}

	public void paintComponent(Graphics g)
	{		
		g.drawImage(background, 0, 0, this);
		
		//System.out.println("Finished");
	}

	////////////////////////////INPUT///////////////////////////////		

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == defaultButton)
		{
			Main.getStatReader().readDemoStats();
			statwindow = new StatWindow(Main.getStatKeeper());
		}
	}

}
