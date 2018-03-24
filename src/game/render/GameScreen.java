package game.render;

import java.awt.Color;
import java.awt.Graphics;

import game.controls.KeyInput;
import game.engine.Game;
import game.hud.HUD;
import game.objects.player.Player;

/**
 * This Function Controls the pause and start screen of the game.
 * @author Sierra
 */
public class GameScreen{

	/**
	 * Variables to hold the last key pressed and the game handler.
	 */
	//private Handler handler;
	private char lastKey = 'd';
	private static int count = 0;
	private int total = 0;
	private int lock = 0;
	private int start = 0;
	public static final int IMAGE_WIDTH = 56, IMAGE_HEIGHT = 61, IMAGE_X = 30, IMAGE_Y = 356, 
			BORDER_WIDTH = IMAGE_WIDTH +99, BORDER_HEIGHT = IMAGE_HEIGHT+107, BORDER_X = IMAGE_X-50, BORDER_Y = IMAGE_Y-30;

	/**
	 * get lastKey
	 * @return lastKey pressed
	 */
	public int getCount() {
		return count;
	}

	public static void setC(int c) {
		count = c;
	}
	public int getTotal() {
		return total;
	}

	/**
	 * set lastKey
	 * @param count store
	 */
	//public void setCount(int count) {
	//		this.count = count;
	//}

	/**
	 * get lastKey
	 * @return lastKey pressed
	 */
	public char getLastKey() {
		return lastKey;
	}

	/**
	 * set lastKey
	 * @param lastKey pressed
	 */
	public void setLastKey(char lastKey) {
		this.lastKey = lastKey;
	}

	public void startScreen(Graphics g) {
		/**
		 * Controls the start screen
		 */
		if (Game.getStart()  == false) {
			//Image of start selected
			//g.drawImage(Render.getGameStart(),0,0,Game.WIDTH,Game.HEIGHT, null);

			if(KeyInput.getDown()== true) {
				KeyInput.setDown(false);
				if (start < 1)
				start++;
			}
			if(KeyInput.getUp()== true) {
				KeyInput.setUp(false);
				if (start > 0)
				start--;
			}
			switch(start) {
			case 0:
				if (lock == 0) {
					g.drawImage(Render.getGameStart(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
				}
				if (lock == 1) {
					g.drawImage(Render.getInstructions(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
				}
				if (lock == 2) {
					Game.setStart(true);
				}
				if(KeyInput.getSpace() == true) { // if(KeyInput.getSpace() == true && count < 2) {
					g.drawImage(Render.getInstructions(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
					KeyInput.setSpace(false);
					lock++;
				}
				break;
			case 1:
				g.drawImage(Render.getStartQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
				if(KeyInput.getSpace() == true) {   // if(KeyInput.getSpace() == true && count < 2) {
					System.exit(1);
				}
				break;

			}
		}
		System.out.println(start);
	}

	public void pauseScreen(Graphics g) {
		g.drawImage(Render.getPauseQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
		for (int k = 0; k <= Player.getPouch().size()-1; k++) {

			if (Player.getPouch().size() == 0) {
				System.out.print("Empty list");
			}
			else {
				g.drawImage(Render.getHealthPotion(),IMAGE_X + (61*k),IMAGE_Y,IMAGE_WIDTH,IMAGE_HEIGHT, null);
				//	System.out.println(Player.getPouch().get(k));
			}
		}

		if(KeyInput.getDown() == true) {
			KeyInput.setDown(false);
			if (count < 2) {
				count++;
				total = 0;
			}
		}

		if (KeyInput.getUp() == true){
			KeyInput.setUp(false);
			if (count > 0) {
				count--;
				total = 0;
			}
		}
		if (KeyInput.getRight() == true){
			KeyInput.setRight(false);
			if (total < 7) {
				total++;
			}
		}
		if (KeyInput.getLeft() == true){
			KeyInput.setLeft(false);
			if (total >= 1) {
				total--;
			}
		}
		System.out.println("count: " + count);
		switch(count) {
		case 0:
			g.drawImage(Render.getPauseQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
			if(KeyInput.getSpace() == true) {   // if(KeyInput.getSpace() == true && count < 2) {
				System.exit(1);
				KeyInput.setPause(false);
			}
			break;
		case 1:
			g.drawImage(Render.getPauseRestart(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
			if(KeyInput.getSpace() == true) {   // if(KeyInput.getSpace() == true && count < 2) {
				Game.setRestart(true);
			}
			break;
		case 2:
			g.drawImage(Render.getPauseItem(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
			g.drawImage(Render.getBorder(),BORDER_X + (61*total),BORDER_Y,BORDER_WIDTH,BORDER_HEIGHT, null);
			break;

		}
		for (int k = 0; k <= Player.getPouch().size()-1; k++) {

			if (Player.getPouch().size() == 0) {
				System.out.print("Empty list");
			}
			else {
				g.drawImage(Render.getHealthPotion(),IMAGE_X + (61*k),IMAGE_Y,IMAGE_WIDTH,IMAGE_HEIGHT, null);
				System.out.println(Player.getPouch().get(k));
			}
		}

	}

	/**
	 * Controls the pause and death screen rendering
	 * @param g graphics image to pass to function
	 */
	public void render(Graphics g) {
		/**
		 * Controls the pause screen controls
		 */
		if (KeyInput.getPause() == true) {
			pauseScreen(g);

		}

		/**
		 * Controls the death screen
		 */
		if(HUD.getHealth() == 0) {
			//Quite selected
			if(KeyInput.getUp() == true) {
				g.drawImage(Render.getGameQuit(),0,0,Game.WIDTH,Game.HEIGHT, null);

				if(KeyInput.getSpace() == true) {
					System.exit(1);
				}
				//g.fillRect(x, y, 32, 32);
			}
			//Restart selected
			if (KeyInput.getDown() == true){
				g.drawImage(Render.getGameRestart(),0,0,Game.WIDTH,Game.HEIGHT, null);
				//newGame
				if(KeyInput.getSpace() == true) {
					Game.setRestart(true);
				}
			}
		}
	}
}