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
public class GameScreen1{

	/**
	 * Variables to hold the last key pressed and the game handler.
	 */
	//private Handler handler;
	/*private char lastKey = 'd';
	private int count = 0;
	private int total = 0;
	//private int lock = 0;
	public static final int IMAGE_WIDTH = 56, IMAGE_HEIGHT = 61, IMAGE_X = 30, IMAGE_Y = 356, 
			BORDER_WIDTH = IMAGE_WIDTH +99, BORDER_HEIGHT = IMAGE_HEIGHT+107, BORDER_X = IMAGE_X+11, BORDER_Y = IMAGE_Y-30;

	/**
	 * get lastKey
	 * @return lastKey pressed
	 */
	/*public int getCount() {
		return count;
	}
	public int getTotal() {
		return total;
	}

	/**
	 * set lastKey
	 * @param count store
	 */
	/*public void setCount(int count) {
		this.count = count;
	}

	/**
	 * get lastKey
	 * @return lastKey pressed
	 */
	/*public char getLastKey() {
		return lastKey;
	}

	/**
	 * set lastKey
	 * @param lastKey pressed
	 */
	/*public void setLastKey(char lastKey) {
		this.lastKey = lastKey;
	}

	/**
	 * Controls the start screen
	 * @param g graphics image to pass to function
	 */
	
	
	/*public void startScreen(Graphics g) {
		/**
		 * Controls the start screen
		 */
		/*if (Game.getStart()  == false) {
			//Image of start selected
			g.drawImage(Render.getGameStart(),0,0,Game.WIDTH,Game.HEIGHT, null);
			if(KeyInput.getSpace() == true) {
				Game.setStart(true);
			}

			if(KeyInput.getUp() == true){
				g.drawImage(Render.getGameStart(),0,0,Game.WIDTH,Game.HEIGHT, null);

				if(KeyInput.getSpace() == true) {
					Game.setStart(true);
				}
			}
			//Image of quite selected
			if (KeyInput.getDown() == true){
				g.drawImage(Render.getStartQuit(),0,0,Game.WIDTH,Game.HEIGHT, null);
				if(KeyInput.getSpace() == true) {
					System.exit(1);		
				}
			}
		}
	}

	/**
	 * Controls the pause and death screen rendering
	 * @param g graphics image to pass to function
	 */
	/*public void render(Graphics g) {
		/**
		 * Controls the pause screen controls
		 */
		/*if (KeyInput.getPause() == true) {
			g.drawImage(Render.getPauseQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
			if(KeyInput.getSpace() == true && count < 2) {   // if(KeyInput.getSpace() == true && count < 2) {
				System.exit(1);
			}

			if(KeyInput.getUp() == true) {
				count++;
				g.drawImage(Render.getPauseQuit(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);

				if(KeyInput.getSpace() == true) {
					System.exit(1);
				}
			}

			if (KeyInput.getDown() == true){
				count++;
				g.drawImage(Render.getPauseRestart(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
				if(KeyInput.getSpace() == true) {
					Game.setRestart(true);
				}
			}
			if (KeyInput.getRight() == true){
				if (total < 6) {
					total++;
				}
				g.drawImage(Render.getBorder(),BORDER_X + (61*total),BORDER_Y,BORDER_WIDTH,BORDER_HEIGHT, null);
				//g.drawImage(Render.getPauseRestart(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
			}
			if (KeyInput.getLeft() == true){
				if (total >=0) {
					total--;
				}
				System.out.println("Im pressing the left key");
				g.drawImage(Render.getBorder(),BORDER_X + (61*total),BORDER_Y,BORDER_WIDTH,BORDER_HEIGHT, null);
				//g.drawImage(Render.getPauseRestart(),0,0,Game.WIDTH-5,Game.HEIGHT-30, null);
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
			//g.drawImage(Render.getHealthPotion(),0,0,32,32, null);
		}

		/**
		 * Controls the death screen
		 */
		/*if(HUD.getHealth() == 0) {
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
	}*/
}