package element;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.image.BufferedImage;

/**
 * 
 * @author p1ma
 *
 */
public abstract class Touch extends BufferedImage{
	
	protected Shape box; // object's bounding box
	protected Color color; // object's color
	protected int x,y;
	protected int xOld, yOld;
	public static int width = 10;
	protected Graphics graphics;
	protected int value; // score value, smaller width = greater value
	
	public Touch(int x, int y){
		super(x,y,BufferedImage.TYPE_INT_ARGB);
		this.x = x;
		this.y = y;
		this.xOld = this.x;
		this.yOld = this.y;
		this.box = null;
		this.color = new Color(255,255,255); // default = white 
		this.value = (10 * (10/width)) ; // considered 10 as default value
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public abstract void draw(Graphics graphics);
	
	public abstract void clean(Graphics graphics);
	
	public abstract boolean overlap(int xMouse, int yMouse);
	
	public void set(int xP, int yP){
		this.xOld = this.x;
		this.yOld = this.y;
		this.x = xP;
		this.y = yP;
	}
	
	public Graphics getGraphics(){
		return this.createGraphics();
	}
	
	public int getValue(){
		return this.value;
	}

}
