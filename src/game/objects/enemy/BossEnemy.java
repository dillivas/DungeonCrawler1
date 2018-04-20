package game.objects.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import game.engine.Handler;
import game.objects.GameObject;
import game.objects.ID;
import game.objects.bossAttack.BossFire;
import game.render.Render;
import game.render.SpriteSheet;

public class BossEnemy extends GameObject {

	//Boss Sprite Sheet
	private SpriteSheet ss;

	//Boss Variables
	private Handler handler;
	private int steps = 0;
	private int hp = 1000;
	private int rate;
	private static boolean dead = false;

	/**
	 * Boss Constructer
	 * 
	 * @param x boss location (X)
	 * @param y boss location (Y)
	 * @param id boss ID type
	 * @param ss Boss spread sheet image
	 * @param handler gives boss access to handler
	 */
	public BossEnemy(int x, int y, ID id, SpriteSheet ss, Handler handler) {
		super(x, y, id, ss);
		this.handler=handler;

		setSpeedX(4);
		setSpeedY(4);
	}

	/**
	 * Boss action during game tick
	 */
	@Override
	public void tick() {

		if(steps%230< 115){
			setY(getY() + 2);
		}

		else if(steps%230 < 230){
			setY(getY() - 2);
		}
		steps++;
		rate++;
		if(rate ==3) {
			if(steps%2==0) {
			handler.addObject(new BossFire(getX(),getY(),-5,2,ID.BossAttack,ss, handler));
			handler.addObject(new BossFire(getX(),getY(),-5,-1,ID.BossAttack,ss, handler));
			}
			else {
				handler.addObject(new BossFire(getX(),getY(),-5,0,ID.BossAttack,ss, handler));
				handler.addObject(new BossFire(getX(),getY(),-5,1,ID.BossAttack,ss, handler));

			}
			rate = 0;
		}


			for(int i = 0; i < handler.getObject().size(); i++) {
				GameObject tempObject = handler.getObject().get(i);	


				//Hit by player Attack
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
	 * @param g graphics
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Render.getBossImage(),getX(),getY(),50,50, null);
	}

	/**
	 * Add enemy hitbox
	 * @return Rectangle
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
	 * @param b boolean
	 */
	public static void setDead(boolean b) {
		dead = b;
	}
	/**
	 * gets the key stat
	 * @return dead
	 */
	public static boolean getDead() {
		return dead;
	}
}



