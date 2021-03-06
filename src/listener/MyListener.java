package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import window.Window;

/**
 * 
 * @author p1ma
 *
 */
public class MyListener implements MouseListener{

	private Window object;
	
	public MyListener(Window touch){
		this.object = touch;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//HERE
		//System.out.println("XMouse : " + arg0.getX() + " , " + "YMouse : " + arg0.getY());
		boolean touched = this.object.overlap(arg0.getX(), arg0.getY());
		if(touched){
			//if touched -> new point
			System.out.println("Point touched !");
			this.object.isTouched();
		}
		else{
			// try again
			System.out.println("Point missed !");
		}
		//System.out.println("PRESSED");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
