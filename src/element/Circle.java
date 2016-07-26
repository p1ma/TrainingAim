package element;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author p1ma
 *
 */
public class Circle extends Touch{

	public Circle(int x, int y) {
		super(x, y);
		box = new Ellipse2D.Float((float)x,(float)y,(float)this.width, (float)this.width);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		box = null;
		box = new Ellipse2D.Float((float)x,(float)y,(float)this.width, (float)this.width);
		graphics.fillOval(x, y, Touch.width, Touch.width); // to change
	}

	@Override
	public void clean(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.clearRect(xOld, yOld, 2*Touch.width, 2*Touch.width); // need to be verified
	}

	@Override
	public boolean overlap(int xMouse, int yMouse) {
		// TODO Auto-generated method stub
		return (box.contains((double)xMouse, (double) yMouse));
	}

}
