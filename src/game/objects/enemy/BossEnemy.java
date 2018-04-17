package game.objects.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import game.engine.Handler;
import game.objects.GameObject;
import game.objects.ID;
import game.objects.attack.Fireball;
import game.objects.bossAttack.BossFire;
import game.objects.player.Player;
import game.render.Render;
import game.render.SpriteSheet;

public class BossEnemy extends GameObject {

	private SpriteSheet ss;

	private Handler handler;
	private int steps = 0;
	private int hp = 1000;
	private int rate;
	private static boolean dead = false;

	public BossEnemy(int x, int y, ID id, SpriteSheet ss, Handler handler) {
		super(x, y, id, ss);
		this.handler=handler;

		setSpeedX(4);
		setSpeedY(4);
	}

	@Override
	public void tick() {

		if(steps%200 < 100){
			setY(getY() + 2);
		}

		else if(steps%100 < 200){
			setY(getY() - 2);
		}
		steps++;
		rate++;
		if(rate ==3) {
			handler.addObject(new BossFire(getX(),getY(),-5,0,ID.BossAttack,ss, handler));
			rate = 0;
		}



		//AI behavior found on:
			//https://www.youtube.com/watch?v=JBGCCAv76YI&t=1s
			// following code did not use link
			for(int i = 0; i < handler.getObject().size(); i++) {
				GameObject tempObject = handler.getObject().get(i);	

				//Collision effects on enemy
				//handler.addObject(new BossFire(getX(),getY(),0,-5,ID.Attack,ss, handler));


				if(tempObject.getID() == ID.Attack) {
					if(getBounds().intersects(tempObject.getBounds())) {
						hp -= 15;

						//Removes fireball
						handler.removeObject(tempObject);
					}
				}
				if(tempObject.getID() == ID.Lava) {
					if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Lava)) {
						hp -= 1;

					}
				}
			}
			if(hp <= 0) {
				handler.removeObject(this);
				setDead(true);
			}

	}

	/**
	 * render enemy image
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Render.getBossImage(),getX(),getY(),50,50, null);
	}

	/**
	 * Add enemy hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX() ,getY() ,50,50);
	}

	/**
	 * Add second hit box for enemy AI pathing
	 * @return rectangle for hitbox
	 */
	public Rectangle getBoundsWall() {
		return new Rectangle(getX() - 16,getY() - 16,64,64);
	}
	/**
	 * sets the key boolean
	 * @param boolean b
	 */
	public static void setDead(boolean b) {
		dead = b;
	}
	/**
	 * gets the key stat
	 */
	public static boolean getDead() {
		return dead;
	}
}



