package game.objects.structure;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.objects.GameObject;
import game.objects.ID;
import game.render.SpriteSheet;

/**
 * The class controls a wall or block object
 * to act as a obstacle to the player.	
 * 
 * @author William
 * date 2/27/2018
 * class block
 */
public class Door extends GameObject{
	
	//Hold object sprite image
	private BufferedImage blockImage;
	
	/**
	 * Block Constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */
	public Door(int x, int y, ID id, SpriteSheet ss) {
		super(x,y,id, ss);
		blockImage = ss.grabImage(3,1,32,32);
	}
	/**
	 * Update the object on tick
	 */
	@Override
	public void tick() {
		
	}
	
	/**
	 * render object image
	 */
	@Override
	public void render(Graphics g) {
		//g.drawImage(blockImage, getX(), getY(),Change x size,Change x size, null);
		g.drawImage(blockImage, getX(), getY(),32,32, null);
	}
	
	/**
	 * Add object hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(),getY(),20,20);
	}
}
