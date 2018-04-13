package game.render;

import java.awt.Graphics;
import game.controls.KeyInput;
import game.engine.Game;
import game.hud.HUD;
import game.objects.items.ItemSpecs;
import game.objects.items.Items;
import game.objects.player.Player;

/**
 * date: 4/3/2018       					*
 * class: GameScreen    					*
 *            								*
 * The class control's the game screens  	*
 * 											*
 * @author Sierra						*
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
	 * get count
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * set count
	 * @param c store
	 */
	public static void setC(int c) {
		count = c;
	}
	
	/**
	 * get total
	 * @return total
	 */
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
	
	/**
	 * controls the start screen
	 * @param Graphics g
	 */
	public void startScreen(Graphics g) {
		/**
		 * Controls the start screen
		 */
		if (Game.getStart()  == false) {
			//Image of start selected if there is no toggle
			if (lock == 1) {
				KeyInput.setDown(false);
				KeyInput.setUp(false);
			}
			// Keeps track of downward scroll
			if(KeyInput.getDown()== true) {
				KeyInput.setDown(false);
				if (start < 1)
					start++;
			}
			// Keeps track of upward scroll
			if(KeyInput.getUp()== true) {
				KeyInput.setUp(false);
				if (start > 0)
					start--;
			}
			// based on number of upward/ downard scrolls determines image rendered
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
				// takes care of game start and instructions
				if(KeyInput.getSpace() == true) { // if(KeyInput.getSpace() == true && count < 2) {
					g.drawImage(Render.getInstructions(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
					KeyInput.setSpace(false);
					lock++;
				}
				break;
				// takes care of quit action
			case 1:
				g.drawImage(Render.getStartQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
				if(KeyInput.getSpace() == true) {   // if(KeyInput.getSpace() == true && count < 2) {
					System.exit(1);
				}
				break;

			}
		}
	}

	/**
	 * controls the pause screen
	 * @param Graphics g
	 */
	public void pauseScreen(Graphics g) {
		g.drawImage(Render.getPauseQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
		for (int k = 0; k <= Player.getPouch().size()-1; k++) {

			if (Player.getPouch().size() == 0) {
				System.out.print("");
			}
			else {
				//g.drawImage(Render.getHealthPotion(),IMAGE_X + (61*k),IMAGE_Y,IMAGE_WIDTH,IMAGE_HEIGHT, null);
				//	System.out.println(Player.getPouch().get(k));
			}
		}
		// allows for user to scroll up and down
		if(KeyInput.getDown() == true) {
			KeyInput.setDown(false);
			if (Player.getPouch().size()==0){
				if (count < 1) {
					count++;
					total = 0;
				}
			}
			else {
				if (count < 2) {
					count++;
					total = 0;
				}
			}
		}

		if (KeyInput.getUp() == true){
			KeyInput.setUp(false);
			if (count > 0) {
				count--;
				total = 0;
			}
		}
		//allows user to scroll left and right
		if (KeyInput.getRight() == true){
			KeyInput.setRight(false);
			if (total < Player.getPouch().size()-1) {
				total++;
			}
		}
		if (KeyInput.getLeft() == true){
			KeyInput.setLeft(false);
			if (total >= 1) {
				total--;
			}
		}
		switch(count) {
		// based on count determines which screen is pulled
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
			g.drawString(Items.getString(Player.getPouch().get(total)),25, BORDER_Y +110);
			if(KeyInput.getSpace() == true) { 
				ItemSpecs.getSpecs(Player.getPouch().get(total));
				if(Player.getPouch().size() == total+1) {
					Player.getPouch().remove(total);
					total--;
					KeyInput.setSpace(false);
				}
				else {
					Player.getPouch().remove(total);
					KeyInput.setSpace(false);
				}
				if(Player.getPouch().size() == 0) {
					count--;
					KeyInput.setSpace(false);
				}
			}

			break;

		}
		//draws images in item box
		for (int k = 0; k <= Player.getPouch().size()-1; k++) {

			if (Player.getPouch().size() == 0) {
				System.out.print("Empty list");
			} 
			else {
				g.drawImage(Items.getImage(Player.getPouch().get(k)),IMAGE_X + (61*k),IMAGE_Y,IMAGE_WIDTH,IMAGE_HEIGHT, null);
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
			g.drawImage(Render.getGameQuit(),0,0,Game.WIDTH,Game.HEIGHT, null);
			if(KeyInput.getUp() == false && (KeyInput.getDown() == false)) {
				if(KeyInput.getSpace() == true) {
					System.exit(1);
				}
			}
			if(KeyInput.getUp() == true) {
				g.drawImage(Render.getGameQuit(),0,0,Game.WIDTH,Game.HEIGHT, null);

				if(KeyInput.getSpace() == true) {
					System.exit(1);
				}
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