package game.engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import game.controls.KeyInput;
import game.hud.HUD;
import game.map.Dungeon;
import game.objects.GameObject;
import game.objects.ID;
import game.objects.enemy.BasicEnemy;
import game.objects.enemy.Ghost;
import game.objects.player.Player;
import game.objects.items.Items;
import game.objects.structure.Block;
import game.objects.structure.InvisibleBlock;
import game.objects.structure.Lava;
import game.render.BufferedImageLoader;
import game.render.GameScreen;
import game.render.Render;
import game.render.SpriteSheet;

/**
 * Function controls the game setup and running.
 * 
 * date 2/27/2018
 * class Game
 * @author William
 */
public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 665215786302647934L;

	//Window Size settings
	//public static final int WIDTH = 640, HEIGHT = 512;
	public static final int WIDTH = 550, HEIGHT = 478;
	public static final int TOP = 1, RIGHT = 2, BOTTOM = 3, LEFT = 4;

	/**
	 * Variables to hold all of the important game functions
	 * Such as the handler, thread, player hub, running status,
	 * and images and sprite sheets to load in at start of game.
	 */
	private boolean running = false;

	private static Game game;
	private Handler handler;
	private Thread thread;
	private HUD hud;
	private Player player;
	//private Camera camera;
	private GameScreen gameScreen;
	private SpriteSheet ss;
	private SpriteSheet is;
	private SpriteSheet ms;
	private BufferedImage spriteSheet = null;
	private BufferedImage itemSheet = null;
	private BufferedImage levelSheet = null;

	private Dungeon dungeon = null;
	private BufferedImage floor = null;
	private static boolean start = false;
	private static boolean restart = true;


	/**
	 * Game object constructed
	 */
	public Game() {
		
		//Setup Game Window
		new Window(WIDTH, HEIGHT, "Dungeon Crawler", this);
		
		//Setup Game
		setup();

		//Start Game
		start();
	}

	/**
	 * Start Game and thread setup
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void setup() {
		Render.load();
		handler = new Handler();
		//new Window(WIDTH, HEIGHT, "Dungeon Crawler", this);
		BufferedImageLoader loader = new BufferedImageLoader();
		levelSheet = loader.loadImage("/Dungeon1.png");
		spriteSheet = loader.loadImage("/BlocksNew.png");
		ss = new SpriteSheet(spriteSheet);
		ms = new SpriteSheet(levelSheet);
		dungeon = new Dungeon(ms);
		floor = ss.grabImage(1, 1, 32, 32);
		loadLevel(dungeon.getRoom(dungeon.getPlayerInRoomX(), dungeon.getPlayerInRoomY()));
		//hud = new HUD(player);
		
		player = new Player(dungeon.getPlayerLocX(), dungeon.getPlayerLocY() + 96, ID.Player,ss, handler, dungeon, this);
		hud = new HUD(player);
		handler.addObject(player);
		gameScreen = new GameScreen();
		this.addKeyListener(new KeyInput(handler, ss));
	}
	
	/**
	 * This class restarts the game
	 */
	public void restart() {
		HUD.setHealth(100);
		HUD.setMana(100);
		
		setup();
	}
	
	/**
	 * This function checks for the game to restart and restarts the game.	
	 */
	public static void checkForRestart(){
		//Always run loop checking for restart
		//System.out.println(restart);
		if (restart == true) {
			
			Game.start = false;
			restart = false;
			KeyInput.setPause(false);
			
			game.restart();
		}
	}
	/**
	 * Stop Game
	 */
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Game Loop.
	 * Also controls the frames.
	 */
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while(running){
			if(dungeon.getLeftRoom() == true) {
				loadNewRoom();
				dungeon.setLeftRoom(false);
			}
				
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1){
				delta--;
				updates++;
				//Used for pause and death screen
				if (!(HUD.getHealth() == 0) && (KeyInput.getPause() == false) && (Game.getStart() == true)) {
					tick();
				}
				checkForRestart();

			}
			if(running) {
				render();
			}
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: "+ frames + " Updates: " + updates);
				frames = 0;
				updates =0;

			}
		}
		//Stop the Game
		stop();
	}

	/**
	 * Run next update of game objects based on the game loop
	 */
	private void tick() {
		
		/*for(int i = 0;i < handler.getObject().size(); i++) {
			if(handler.getObject().get(i).getID() == ID.Player) {
				//camera.tick(handler.getObject().get(i));
			}
		}*/
		
		if(handler.getLastEnemyAlive() == true) {
			handler.setLastEnemyAlive(false);
			handler.addObject(new Items(handler.getLastEnemyX(), handler.getLastEnemyY(), ID.Items,ss));
		}
		handler.tick();
		hud.tick();
	}


	/**
	 * Controls what renders on the screen
	 */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		//Graphics2D g2d = (Graphics2D) g;
		
		//Code between these comment lines controls what we load into the window
		///////////////////////////////////////
		
		//g2d.translate(-camera.getX(), -camera.getY());	//begin of cam influence

		for(int xx = 0; xx < (30*72); xx += 32) {
			for(int yy = 0; yy < (30*72); yy += 32) {
				g.drawImage(floor, xx, yy, null);
			}
		}
		handler.render(g);
		
		//g2d.translate(camera.getX(), camera.getY());	//end of cam influence
		hud.render(g); 									//hud must be oustide of cam's influence
		
		gameScreen.startScreen(g);
		gameScreen.render(g);
		///////////////////////////////////////
		g.dispose();
		bs.show();
	}

	/**
	 * Method to make sure player stays within room
	 * @param var player movement
	 * @param min room size
	 * @param max room size
	 * @return player position
	 */
	public static int clamp(int var, int min, int max) {
		if(var >= max) {
			var = max;
			return var;
		}else if(var <= min) {
			var = min;
			return var;

		}else {
			return var;
		}
	}


	/**
	 * Load in the game level objects
	 * @param image used for mapping the game level
	 */
	private void loadLevel(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int xx = 0; xx < width; xx++) {
			for(int yy = 0; yy < height; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				//Code between lines controls what objects are rendered into the game.
				/////////////////////////////////////////////////////////
				//Load Level First then enemy and player

				
				if(red == 0 && green == 255 && blue == 0) {
					handler.addObject(new Items(xx*32, yy*32 + 96, ID.Items,ss));
				}
				if(red == 190 && green == 60 && blue == 190) {
					handler.addObject(new BasicEnemy(xx*32, yy*32 + 96, ID.Enemy,ss, handler));
				}
				if(red == 255 && green == 255 && blue == 255) {
					handler.addObject(new Ghost(xx*32, yy*32 + 96, ID.Enemy,ss, handler));
				}
				if(red == 255 && green == 0 && blue == 0) {
					handler.addObject(new Block(xx*32, yy*32 + 96, ID.Block,ss));
				}
				if(red == 255 && green == 100 && blue == 0) {
					handler.addObject(new Lava(xx*32, yy*32 + 96, ID.Lava,ss));
				}
			}
		}
		//handler.addObject(new Player(dungeon.getPlayerLocX(), dungeon.getPlayerLocY() + 96, ID.Player,ss, handler, dungeon, this));
	}
	
	public void loadNewRoom(){
		
		if(dungeon.getNextPlayerRoom() != 0) {
			//Dispose of old objects	
			Player tempPlayer = (Player) handler.get(player);
			handler.clear();
			
			if(dungeon.getNextPlayerRoom() == TOP)
				dungeon.setPlayerInRoomY(dungeon.getPlayerInRoomY() - 1);
			if(dungeon.getNextPlayerRoom() == BOTTOM)
				dungeon.setPlayerInRoomY(dungeon.getPlayerInRoomY() + 1);
			if(dungeon.getNextPlayerRoom() == LEFT)
				dungeon.setPlayerInRoomX(dungeon.getPlayerInRoomX() - 1);
			if(dungeon.getNextPlayerRoom() == RIGHT)
				dungeon.setPlayerInRoomX(dungeon.getPlayerInRoomX() + 1);
			
			dungeon.setNextPlayerRoom(0);
			//Load New Level
			loadLevel(dungeon.getRoom(dungeon.getPlayerInRoomX(), dungeon.getPlayerInRoomY()));
			
			player = tempPlayer;
			handler.addObject(player);
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	/**
	 * Getter method for start
	 * @return start state
	 */
	public static boolean getStart() {
		return start;
	}	
	/**
	 * get restart
	 * @return restart restart
	 */
	public static boolean getRestart() {
		return restart;
	}
	
	/**
	 * set start
	 * @param x restart
	 */
	public static void setStart(boolean x) {
		start  = x;
	}
	
	/**
	 * set testart
	 * @param x restart
	 */
	public static void setRestart(boolean x) {
		restart  = x;
	}
	
	/**
	 * Main method to launch game
	 * @param args default argument
	 */
	public static void main(String args[])
	{
		//Start new launch and game
		game = new Game();
	}
}