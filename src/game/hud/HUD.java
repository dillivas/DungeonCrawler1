package game.hud;

import java.awt.Color;
import java.awt.Graphics;

import game.engine.Game;
import game.render.Render;

/**
 * The class keeps track of player HUD 
 * 
 * @author William
 * date 1/28/2018
 * class hub
 */
public class HUD {

	//Move Health to player and displaye health and mana in game function. Should stop null pointer
	//private GameObject gameObject;
	private static int health = 100;
	private static int mana = 100;
	/**
	 * @return the health
	 */
	public static int getHealth() {
		return health;
	}
	/**
	 * @return the mana
	 */
	public static int getMana() {
		return mana;
	}

	/**
	 * @param health the health to set
	 */
	public static void setHealth(int health) {
		HUD.health = health;
	}
	/**
	 * @param mana the mana to set
	 */
	public static void setMana(int mana) {
		HUD.mana = mana;
	}
	/**
	 * Update player health bar on tick
	 */
	public void tick() {
		System.out.println();
		health = Game.clamp(health,0,100);
		mana = Game.clamp(mana, 0, 100);
		//System.out.println(HEALTH);
	}

	/**
	 * Render the healthBar image
	 * @param g object graphic
	 */
	public void healthBar(Graphics g){		
		g.drawImage(Render.getHealthBar(),15,20,health*3,16,null);

		/*
		g.setColor(Color.gray);
		g.fillRect(15 , 15, 200, 32);
		g.setColor(Color.red);
		g.fillRect(15 , 15, health * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15 , 15, 200, 32);*/
	}
	
	/**
	 * Render the object image
	 * @param g object graphic
	 */
	public void manaBar(Graphics g){
		g.drawImage(Render.getManaBar(),15,53,mana*3,17,null);
	}
	
	/**
	 * Render the object image
	 * @param g object graphic
	 */
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0 , 0, Game.WIDTH, 96);
		g.drawImage(Render.getBarOutline(), 10, 15, 311,60,null);

		healthBar(g);
		manaBar(g);
	}
}