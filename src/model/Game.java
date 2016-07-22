package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import window.Window;

/**
 * 
 * @author p1ma
 *
 */
public class Game extends JFrame{

	private Window gameWindow;
	private static Color gameColor = new Color(0,0,0);
	
	public Game(int length, int height){
		super("Training Aim");
		this.setPreferredSize(new Dimension(length,height));
		this.gameWindow = new Window(gameColor);
		this.add(gameWindow,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
