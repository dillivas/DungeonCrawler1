package game.objects.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.hud.HUD;
import game.objects.ID;
import game.render.SpriteSheet;

public class ItemSpecs extends Items {
	//private static BufferedImage healthPotion;
	//private static BufferedImage manaPotion;
	//private static BufferedImage invincibilityPotion;

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
		HUD.setHealth(100);
	}
	public static void invincibility() {
		HUD.setHealth(100);
	}
}
