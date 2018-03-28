package game.objects.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.hud.HUD;
import game.objects.ID;
import game.render.SpriteSheet;

public class ItemSpecs extends Items {
	private static int health;
	private static int counter = 100000;
	private static boolean invincible = false;


	public ItemSpecs(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		// TODO Auto-generated constructor stub

	}
	public static void getSpecs(String s) {
		if (s =="healthPotion") {
			healthPotion();
		}
		if (s =="manaPotion") {
			manaPotion();
		}
		if (s =="invincibility") {
			invincibility();
		}
	}
	public static void healthPotion() {
		HUD.setHealth(100);
	}
	public static void manaPotion() {
		HUD.setMana(100);
	}
	public static void invincibility() {
		setInvincible(true);
	}
	private static void setInvincible(boolean b) {
		invincible = b;
	}
	public static boolean getInvincible() {
		return invincible;
	}
}
