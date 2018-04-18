package game.objects.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import game.engine.Handler;
import game.objects.GameObject;
import game.objects.ID;
import game.objects.items.Items;
import game.objects.player.Player;
import game.render.Render;
import game.render.SpriteSheet;

/**
 * date: 1/28/2018       					*
 * class: BasicEnemy      					*
 *            								*
 * The class control's a BasicEnemy object 	*
 * 											*
 * @author William							*
 */
public class Ghost extends GameObject{

	/**
	 * Variable of the Basic Enemy for its handler,
	 * random set up for its movement, and its hp.
	 * 
	 */
	private Handler handler;
	private int hp = 75;

	/**
	 * BasicEnemy Constructor
	 * @param x axis location of enemy
	 * @param y axis location of enemy
	 * @param id of object
	 * @param ss sprite image of object
	 * @param handler connection for object use.
	 */
	public Ghost(int x, int y, ID id, SpriteSheet ss, Handler handler) {
		super(x, y, id, ss);
		this.handler=handler;
	}

	/**
	 * Update the object on tick
	 */
	@Override
	public void tick() {
		setX(getX() + getSpeedX());
		setY(getY() + getSpeedY());
		// determines the coordinates for the enemy to follow
		if (Player.getXcoor() > getX()) {
			setSpeedX(1);
		}
		if (Player.getXcoor() < getX()) {
			setSpeedX(-1);
		}
		if (Player.getYcoor() > getY()) {
			setSpeedY(1);
		}
		if (Player.getYcoor() < getY()) {
			setSpeedY(-1);
		}

		//AI behavior found on:
		//https://www.youtube.com/watch?v=JBGCCAv76YI&t=1s
		// following code did not use link
		for(int i = 0; i < handler.getObject().size(); i++) {
			GameObject tempObject = handler.getObject().get(i);	
			// prevents collision with the walls of the room
			/*if(tempObject.getID() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					if (getX() < Player.getXcoor()+32 && (getX() > Player.getXcoor()-32)) {
						setSpeedY(getSpeedY()*-1);
					}
		
					else {
						setSpeedX(getSpeedX()*-1);
					}
				}
			}*/
			//Collision effects on enemy
			if(tempObject.getID() == ID.Attack) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hp -= 25;
					//Removes fireball
					handler.removeObject(tempObject);
				}
			}
			/*if(tempObject.getID() == ID.Lava) {
				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Lava)) {
					hp -= 1;

				}
			}*/
		}
		if(hp <= 0) {
			handler.removeObject(this);
			int numEnemys = 0;
			
			for(int i = 0;i < handler.getObject().size(); i++) {
				GameObject tempObject = handler.getObject().get(i);
				if(tempObject.getID() == ID.Enemy)
					numEnemys++;
			}
			if(numEnemys == 0) {
				//Last Enemy Location
				handler.setLastEnemyAlive(true) ;
				handler.setLastEnemyX(getX());
				handler.setLastEnemyY(getY());
			}
		}
	}

	/**
	 * Add enemy hitbox
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX() ,getY() ,32,32);//20
	}

	/**
	 * Add second hit box for enemy AI pathing
	 * @return rectangle for hitbox
	 */
	public Rectangle getBoundsWall() {
		return new Rectangle(getX() - 16,getY() - 16,64,64);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Render.getGhostImage(),getX(),getY(),50,50, null);
	}

}
