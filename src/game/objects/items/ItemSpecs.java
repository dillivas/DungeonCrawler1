package game.objects.items;

import game.hud.HUD;
import game.objects.ID;
import game.render.SpriteSheet;

/**
 * date: 4/3/2018       					*
 * class: ItemSpecs     					*
 *            								*
 * The class contains what the items does  	*
 * 											*
 * @author Sierra 							*
 */
public class ItemSpecs extends Items {
	/**
	 * Variable for whether the player is invincible
	 */
	private static boolean invincible = false;

	/**
	 * ItemSpecs Constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 */
	public ItemSpecs(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
	}
	
	/**
	 * pairs the item with the correct image
	 * @param String s
	 */
	public static void getSpecs(String s) {
		if (s.equals("healthPotion")) {
			healthPotion();
		}
		if (s.equals("manaPotion")) {
			manaPotion();
		}
		if (s.equals("invincibility")) {
			invincibility();
		}
	}
	/**
	 * sets the health
	 */
	public static void healthPotion() {
		HUD.setHealth(100);
	}
	/**
	 * sets the mana
	 */
	public static void manaPotion() {
		HUD.setMana(100);
	}
	/**
	 * sets the shield
	 */
	public static void invincibility() {
		setInvincible(true);
	}
	/**
	 * sets the invincible boolean
	 * @param boolean b
	 */
	private static void setInvincible(boolean b) {
		invincible = b;
	}
	/**
	 * sets the health
	 */
	public static boolean getInvincible() {
		return invincible;
	}
}
