package game.objects.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import game.objects.GameObject;
import game.objects.ID;
import game.render.Render;
import game.render.SpriteSheet;

/**
 * Class controls Lava object
 * @author William
 * date 2/27/2018
 * class Lava
 */
public class Items extends GameObject{
	
	//Variable holds image of item object to render
	private BufferedImage healthPotion;
	private BufferedImage manaPotion;
	private BufferedImage randomItem;
	private Random rand;
	private static int q = 0;


	ArrayList<String> box = new ArrayList<String>();

	/**
	 * Lava constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */

	public int setIndex() {
		//q = Math.random();
		rand = new Random();
		q = rand.nextInt(3)+7;
		System.out.println(q);
		return q;
	}
	public static int getIndex() {
		return q;
	}
	public Items(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		//random spawn of value based upon first value starting at 7-9 curently
		//healthPotion = ss.grabImage(7,1,32,32);
		//manaPotion = ss.grabImage(8,1,32,32);
		randomItem = ss.grabImage(setIndex(),1,32,32); 
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
		g.drawImage(randomItem, getX(), getY(),32,32,null);
	}

	/**
	 * get object hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(),getY(),16,16);
	}
	
	public void itemBox() {
		ArrayList<String> box = new ArrayList<String>();
			
		}
		//box.add(healthP);
		
	}
	//create an array for all items
	// create an array for character items