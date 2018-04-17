package game.objects.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import game.objects.GameObject;
import game.objects.ID;
import game.render.SpriteSheet;

/**
 * date: 4/3/2018      						*
 * class: Items             				*
 *            								*
 * The class control's the Key  		  	*
 * 											*
 * @author Sierra							*
 */
public class Key extends GameObject{

	//Variable holds image of item object to render
	private static BufferedImage key;
	/**
	 * Lava constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */
	public Key(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		key = ss.grabImage(6,1,32,32);  
	}

	/**
	 * Update lava object.
	 * Nothing to update
	 */
	@Override
	public void tick() {
	}

	/**
	 * render object image
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(key, getX(), getY(),32,32,null);
	}
	/**
	 * gets the item image related to variable
	 * @param String s
	 */
	public static BufferedImage getImage(String s) {
		if (s.equals("key")) {
			return key;
		}
		return null;
	}

	/**
	 * get object hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(),getY(),32,32);
	}
}
