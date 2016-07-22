package element;

import java.awt.image.BufferedImage;

/**
 * 
 * @author p1ma
 *
 */
public abstract class Touch extends BufferedImage{
	
	public Touch(int x, int y){
		super(x,y,BufferedImage.TYPE_INT_ARGB);
	}

}
