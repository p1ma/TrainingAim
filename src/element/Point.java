package element;

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
	}
}
