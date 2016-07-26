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
	public static long timeSpawn = 5000; // 5000 ms = 5s
	private int height, length;
	
	public Game(int length, int height){
		super("Training Aim");
		this.height = height;
		this.length = length;
		this.gameWindow = new Window(gameColor);
		this.add(gameWindow,BorderLayout.CENTER);
		this.size(length,height);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void play(int duration){
		this.gameWindow.isCircle(); // to make a Point appeared 
		this.gameWindow.setColor(Color.RED);
		this.gameWindow.play(length, height, duration);
	}
	
	public void size(int length, int height){
		//willing
		Dimension dim = new Dimension((int)(length * 1.01),(int)(height * 1.01)); // +1%
		this.setPreferredSize(dim);
		this.gameWindow.setPreferredSize(dim);
		
		//min
		this.setMinimumSize(dim);
		this.gameWindow.setMinimumSize(dim);
		
		//max
		this.setMaximumSize(dim);
		this.gameWindow.setMaximumSize(dim);
	}
	
	
	
	
}
