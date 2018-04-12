package game.objects.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

import game.engine.Game;
import game.engine.Handler;
import game.hud.HUD;
import game.map.Dungeon;
import game.objects.GameObject;
import game.objects.ID;
import game.objects.items.ItemSpecs;
import game.objects.items.Items;
import game.render.Render;
import game.render.SpriteSheet;

/**
 * The class control's the player object 
 * @author William
 * date 2/27/2018
 * class Player
 */
public class Player extends GameObject {

	public static final int TOP = 1, RIGHT = 2, BOTTOM = 3, LEFT = 4;
	public static final int TOPSCREEN = 96, LEFTSCREEN = 0, BOTTOMSCREEN = 478, RIGHTSCREEN = 550;
	
	//Store handler for later use
	private Handler handler;
	private static ArrayList<String> pouch;
	//Store last key entered by user
	//Used to show character direction to face
	private char lastKey = 'd';

	//Store pressLength
	private int pressLength = 4;
	private int counter = 100;

	// store player coordinates
	private static int yCoor;
	private static int xCoor;
	private Dungeon dungeon;
	private Game game;
	
	/**
	 * Player constructor
	 * @param x coordinate of player
	 * @param y coordinate of player
	 * @param id of player object
	 * @param ss spread sheet
	 * @param handler handler for object use
	 */
	public Player(int x, int y, ID id, SpriteSheet ss, Handler handler,Dungeon dungeon, Game game) {
		super(x, y, id, ss);
		this.handler = handler;
		pouch = new ArrayList<String>();
		this.game = game;
		this.dungeon = dungeon;
	}

	/**
	 * Player location
	 */
	public void tick() {
		setX(getX() + getSpeedX());
		setY(getY() + getSpeedY());
		xCoor = getX();
		yCoor = getY();

		//Call collision function
		collision();

		//Player Movement
		if(handler.getUp()) setSpeedY(-3);
		else if(!handler.getDown()) setSpeedY(0);

		if(handler.getDown()) setSpeedY(3);
		else if(!handler.getUp()) setSpeedY(0);

		if(handler.getRight()) setSpeedX(3);
		else if(!handler.getLeft()) setSpeedX(0);

		if(handler.getLeft()) setSpeedX(-3);
		else if(!handler.getRight()) setSpeedX(0);
	}
	
	/**
	 * This is the Players x coordinate.
	 * @return xCoor
	 */
	public static int getXcoor(){
		return xCoor;
	}
	/**
	 * This is the Players y coordinate.
	 * @return yCoor
	 */
	public static int getYcoor(){
		return yCoor;
	}

	/**
	 * This function controls the behavior of this object when it collides with another object.
	 * Collisions use the objects rectangle as a its hitbox.
	 */
	private void collision() {
		for(int i = 0;i < handler.getObject().size(); i++) {
			GameObject tempObject = handler.getObject().get(i);
			if(tempObject.getID() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					setX(getX() + getSpeedX() * -1);
					setY(getY() + getSpeedY() * -1);
				}
			}

			if(tempObject.getID() == ID.Enemy) {

				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Enemy)) {
					if(ItemSpecs.getInvincible() == true && counter > 0) {
						counter--;
					}
					else {
						HUD.setHealth(HUD.getHealth() - 1);
					}
				}
			}
			if(tempObject.getID() == ID.Lava) {

				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Lava)) {
					HUD.setHealth(HUD.getHealth() - 1);
				}
			}
			if(tempObject.getID() == ID.Items) {
				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Items)) {
					Items item = (Items) tempObject;	
					pouch.add(item.getItemType());
					handler.removeObject(tempObject);
					
				}
			}
		}
		if (getXcoor() < LEFTSCREEN + 10) {
			setX(RIGHTSCREEN - 10);
			//dungeon.setPlayerLocX(RIGHTSCREEN - 10);
			dungeon.setNextPlayerRoom(LEFT);
			dungeon.setLeftRoom(true);
			//game.loadNewRoom();
		}
		if (getXcoor() > RIGHTSCREEN - 10) {
			setX(LEFTSCREEN + 10);
			//dungeon.setPlayerLocX(LEFTSCREEN + 10);
			dungeon.setNextPlayerRoom(RIGHT);
			dungeon.setLeftRoom(true);
			//game.loadNewRoom();
		}
		if (getYcoor() > BOTTOMSCREEN - 10) {
			setY(TOPSCREEN + 10);
			//dungeon.setPlayerLocY(TOPSCREEN + 10);
			dungeon.setNextPlayerRoom(BOTTOM);
			dungeon.setLeftRoom(true);
			//game.loadNewRoom();
		}
		if (getYcoor() < TOPSCREEN + 10) {
			setY(BOTTOMSCREEN - 10);
			//dungeon.setPlayerLocY(BOTTOMSCREEN - 10);
			dungeon.setNextPlayerRoom(TOP);
			dungeon.setLeftRoom(true);
			//game.loadNewRoom();
		}
	}
	
	/**
	 * This is the Players item box.
	 * @return Rectangle returns pouch
	 */
	public static ArrayList<String> getPouch() {
		return pouch;
	}
	
	/**
	 * This is the Players hit box.
	 * @return Rectangle returns hit box
	 */
	public Rectangle getBounds() {
		return new Rectangle(getX(),getY(),30,30);// was 32, but he was too wide to fit some corners
	}

	/**
	 * Player Graphic
	 * @param g is player graphic
	 */
	public void render(Graphics g) {	
		if(handler.getStop() == true && lastKey=='w') {
			g.drawImage(Render.getPlayerUpStanding(),getX(),getY(),32,32, null);
		}
		if(handler.getStop() == true && lastKey=='s') {
			g.drawImage(Render.getPlayerDownStanding(),getX(),getY(),32,32, null);
		}
		if(handler.getStop() && lastKey=='a') {
			g.drawImage(Render.getPlayerLeftStanding(),getX(),getY(),32,32, null);
		}
		if(handler.getStop() && lastKey=='d') {
			g.drawImage(Render.getPlayerRightStanding(),getX(),getY(),32,32, null);
		}


		if(handler.getUp() == true) {
			lastKey='w';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.getPlayerForwardWalk1(),getX(),getY(),32,32, null);
			}
			else {
				g.drawImage(Render.getPlayerForwardWalk2(),getX(),getY(),32,32, null);
			}

		}
		if(handler.getDown() == true) {
			lastKey='s';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.getPlayerDownWalk1(),getX(),getY(),32,32, null);
			}
			else {
				g.drawImage(Render.getPlayerDownWalk2(),getX(),getY(),32,32, null);
			}
		}

		if(handler.getLeft() == true) {
			lastKey='a';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.getPlayerLeftWalk1(),getX(),getY(),32,32, null);
			}
			else {
				g.drawImage(Render.getPlayerLeftWalk2(),getX(),getY(),32,32, null);
			}
		}

		if(handler.getRight() == true) {
			lastKey='d';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.getPlayerRightWalk1(),getX(),getY(),32,32, null);
			}
			else {
				g.drawImage(Render.getPlayerRightWalk2(),getX(),getY(),32,32, null);
			}
		}	
	}
	
	public int getCounter() {
		return counter;
	}

}