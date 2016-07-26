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
		this.setPreferredSize(new Dimension(length,height));
		this.gameWindow = new Window(gameColor);
		this.add(gameWindow,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void play(int duration){
		this.gameWindow.isPoint(); // to make a Point appeared 
		this.gameWindow.play(length, height, duration);
	}
	
}
