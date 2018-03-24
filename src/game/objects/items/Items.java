package game.objects.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
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
	protected static BufferedImage healthPotion;
	protected static BufferedImage manaPotion;
	protected static BufferedImage invincibilityPotion;
	private BufferedImage randomItem;
	private Random rand;
	private static int q = 0;
	private String potionType;

	static HashMap<Rectangle, String> box = new HashMap<Rectangle, String>();

	/**
	 * Lava constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */

	public String getItemType() {
		return potionType;
	}
	public int setIndex() {
		//q = Math.random();
		rand = new Random();
		q = rand.nextInt(3)+6;

		switch(q) {
		case 6:
			this.potionType = "invincibility";
			break;
		case 7:
			this.potionType = "healthPotion";
			break;
		case 8:
			this.potionType = "manaPotion";
			break;
		}

		System.out.println(q);
		return q;
	}
	public static int getIndex() {
		return q;
	}
	public Items(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		setIndex();
		//random spawn of value based upon first value starting at 7-9 curently
		//itemBox();
		//System.out.println(box.keys());
		//System.out.println(box.get(getBounds()));
		loadImage(ss);
		randomItem = ss.grabImage(getIndex(),1,32,32); 
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
		return new Rectangle(getX(),getY(),32,32);
	}

	public static HashMap<Rectangle, String> getBox() {
		return box;
	}

	public void loadImage(SpriteSheet ss) {
		healthPotion = ss.grabImage(7,1,32,32);
		manaPotion = ss.grabImage(8,1,32,32);
		invincibilityPotion = ss.grabImage(6,1,32,32);
	}

	public static BufferedImage getImage(String s) {
		if (s == "healthPotion") {
			return healthPotion;
		}
		if (s == "manaPotion") {
			return manaPotion;
		}
		if (s == "invincibility") {
			return invincibilityPotion;
		}
		else {
			return null;
		}
	}

	public void itemBox() {
		//Hashtable<Rectangle, BufferedImage> box = new Hashtable<Rectangle, BufferedImage>();
		if (q == 6) {
			box.put(getBounds(), "invincibilityPotion");
			//System.out.println(getBounds());
		}
		if (q == 7) {
			box.put(getBounds(), "healthPotion");
			//System.out.println(getBounds());

		}
		if (q == 8) {
			box.put(getBounds(), "manaPotion");
			//System.out.println(getBounds());
		}

		//System.out.println(box.keys());
	}
	//box.add(healthP);s

}
//create an array for all items
// create an array for character items