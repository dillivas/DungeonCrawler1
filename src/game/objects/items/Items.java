package game.objects.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import game.objects.GameObject;
import game.objects.ID;
import game.render.SpriteSheet;

/**
 * date: 4/3/2018      						*
 * class: Items             				*
 *            								*
 * The class control's the Item type    	*
 * 											*
 * @author Sierra							*
 */
public class Items extends GameObject{

	//Variable holds image of item object to render
	private static BufferedImage healthPotion;
	private static BufferedImage manaPotion;
	private static BufferedImage invincibilityPotion;
	private BufferedImage chest;
	private Random rand;
	private int q = 0;
	private String potionType;

	/**
	 * Lava constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */
	public Items(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		setIndex();
		
		loadImage(ss);
		chest = ss.grabImage(5,1,32,32); 
	}

	public String getItemType() {
		return potionType;
	}
	public int setIndex() {
		//q = Math.random();
		rand = new Random();
		q = rand.nextInt(3)+7;

		switch(q) {
		case 7:
			this.potionType = "healthPotion";
			break;
		case 8:
			this.potionType = "manaPotion";
			break;
		case 9:
			this.potionType = "invincibility";
			break;
		}
		return q;
	}
	public int getIndex() {
		return q;
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
		g.drawImage(chest, getX(), getY(),32,32,null);
	}

	/**
	 * get object hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(),getY(),32,32);
	}

	/**
	 * loads the item's images
	 * @param SpriteSheet ss
	 */
	public static void loadImage(SpriteSheet ss) {
		healthPotion = ss.grabImage(7,1,32,32);
		manaPotion = ss.grabImage(8,1,32,32); 
		invincibilityPotion = ss.grabImage(9,1,32,32);
	}

	/**
	 * gets the item image related to variable
	 * @param String s
	 */
	public static BufferedImage getImage(String s) {
		if (s .equals("healthPotion")) {
			return healthPotion;
		}
		if (s .equals("manaPotion")) {
			return manaPotion;
		}
		if (s.equals("invincibility")) {
			return invincibilityPotion;
		}
		else {
			return null;
		}
	}
	/**
	 * gets the item image related to variable
	 * @param String s
	 */
	public static String getString(String s) {
		if (s .equals("healthPotion")) {
			return "Health potion: returns the player to full health";
		}
		if (s .equals("manaPotion")) {
			return "Mana potion: returns the player to full mana";
		}
		if (s.equals("invincibility")) {
			return "Shield: provides the user invincibility for a few hits";
		}
		if (s.equals("key")) {
			return "Key: opens a door";
		}
		else {
			return null;
		}
	}
}
