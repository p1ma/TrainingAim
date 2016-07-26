package element;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author p1ma
 *
 */
public class Point extends Touch{

	public Point(int x, int y)
	{
		super(x,y);
		box = new Rectangle(x,y,Touch.width,Touch.width);
		this.graphics = this.createGraphics(); // to change
	}

	@Override
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		box = null;
		box = new Rectangle(x, y, Touch.width, Touch.width);
		graphics.fillRect(x, y, Touch.width, Touch.width); // to change
		//System.out.println("Box : "+box.toString());
	}

	@Override
	public void clean(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.clearRect(xOld, yOld, Touch.width, Touch.width); // removed
	}

	@Override
	public boolean overlap(int xMouse, int yMouse) {
		// TODO Auto-generated method stub
		return (box.contains((double)xMouse, (double) yMouse));
	}
}
