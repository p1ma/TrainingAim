package window;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import listener.MyListener;
import model.Game;

import element.Circle;
import element.Point;
import element.Touch;

/**
 * 
 * @author p1ma
 *
 */
public class Window extends JPanel{

	private Touch toTouch; 
	private MyListener listener; // mouseListener on Touch object
	private Random random;
	private long begin,end;
	private long start;
	private int xPop, yPop;
	private int limitX, limitY;
	private boolean touched;
	private int score;
	
	public Window(Color background){
		super();
		this.setBackground(background);
		random = new Random();
		begin = System.currentTimeMillis();
		end = System.currentTimeMillis() + Game.timeSpawn;
		
		start = System.currentTimeMillis();
		
		xPop = 1;
		yPop = 1;
		limitX = 1;
		limitY = 1;
		score = 0;
		touched = false;
		
		this.toTouch = null;
		this.listener = new MyListener(this);
		this.addMouseListener(this.listener); // listener added
	}	
	
	public void clean(){
		toTouch = null;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		if(!(this.toTouch == null)){
		this.toTouch.clean(g); // remove old Touch element
		this.toTouch.draw(g); // draw the new one
		}
	}
	
	

	public void play(int limitX, int limitY, int duration){
		this.limitX = limitX;
		this.limitY = limitY;
		System.out.println("Playin' ...");
		while(begin <= start + duration){
			this.begin = System.currentTimeMillis();
			//if Touch object is not touched no need to re-draw it, wait duration
				if(this.begin >= this.end){
					pop();
				}
		}	
		this.removeMouseListener(listener);
		System.out.println("GAME OVER BRUH\nSCORE : " + score);
	}
	
	public boolean overlap(int xMouse, int yMouse){
		if(!(this.toTouch == null)){
		return this.toTouch.overlap(xMouse, yMouse);
		}else{
			return false;
		}
	}
	
	public void isTouched(){
		//System.out.println("Confirmation, object touched");
		this.touched = true;
		// modify score
		this.begin = System.currentTimeMillis();
		this.score += this.toTouch.getValue();
		pop();
	}
	
	public void generate(){
		xPop = random.nextInt(this.limitX - 2*this.toTouch.width) + 1;
		yPop = random.nextInt(this.limitY - 2*this.toTouch.width) + 1;
	}
	
	public void respawn(){
		this.touched = false;
		this.toTouch.set(xPop, yPop);
		System.out.println("POP = " + "( " + xPop + ", " + yPop + " )\nSCORE : " + score);
		this.end = System.currentTimeMillis() + Game.timeSpawn;
		repaint();
	}
	
	public void isPoint(){
		this.toTouch = new Point(xPop, yPop);
		repaint();
	}
	
	public void isCircle(){
		this.toTouch = new Circle(xPop, yPop);
		repaint();
	}
	
	public void pop(){
		generate();
		respawn();
	}
	
	public void setColor(Color color){
		this.toTouch.setColor(color);
	}
}
