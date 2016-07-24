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
		this.graphics = this.createGraphics();
	}

	@Override
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		graphics.fillRect(x, y, Touch.width, Touch.width); // to change
	}

	@Override
	public void clean(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.clearRect(xOld, yOld, Touch.width, Touch.width); // removed
	}
}
