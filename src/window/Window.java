package window;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import model.Game;

import element.Point;
import element.Touch;

/**
 * 
 * @author p1ma
 *
 */
public class Window extends JPanel{

	private Touch toTouch; 
	private Random random;
	private long begin,end;
	private long start;
	private int xPop, yPop;
	
	public Window(Color background){
		super();
		this.setBackground(background);
		random = new Random();
		begin = System.currentTimeMillis();
		end = System.currentTimeMillis() + Game.timeSpawn;
		
		start = System.currentTimeMillis();
		
		xPop = 1;
		yPop = 1;
		
		this.toTouch = new Point(xPop, yPop);
		repaint();
	}
	
	public void drawPoint(Graphics g, int x, int y){
		if(toTouch == null){
			this.toTouch = new Point(x,y);
			g.setColor(toTouch.getColor());
			g.fillRect(x, y, Touch.width, Touch.width); // to change
		}
	}	
	
	public void clean(){
		toTouch = null;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		this.toTouch.clean(g); // remove old Touch element
		this.toTouch.draw(g); // draw the new one
	}

	public void play(int limitX, int limitY, int duration){
		while(begin <= start + duration){
			this.begin = System.currentTimeMillis();
			if(this.begin >= this.end){
				xPop = random.nextInt(limitX) + 1;
				yPop = random.nextInt(limitY) + 1;
				this.toTouch.set(xPop, yPop);
				System.out.println("POP = " + "( " + xPop + ", " + yPop + " )");
				this.end = System.currentTimeMillis() + Game.timeSpawn;
				repaint();
			}
		}	
		System.out.println("GAME OVER BRUH");
	}
}
