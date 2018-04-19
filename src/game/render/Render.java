package game.render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Handler loading single images into game.
 * This will later be merged with BufferedImageLoader
 * 
 * @author William
 * date 2/27/2018
 * class Render
 */
public class Render {
	
	private static BufferedImage playerStop;
	private static BufferedImage playerUp;
	private static BufferedImage playerDown;
	private static BufferedImage playerLeft;
	private static BufferedImage playerRight;
	
	private static BufferedImage playerRightStanding;
	private static BufferedImage playerLeftStanding;
	private static BufferedImage playerDownStanding;
	private static BufferedImage playerUpStanding;
	
	private static BufferedImage playerRightWalk1;
	private static BufferedImage playerRightWalk2;
	
	private static BufferedImage playerLeftWalk1;
	private static BufferedImage playerLeftWalk2;
	
	private static BufferedImage playerForwardWalk1;
	private static BufferedImage playerForwardWalk2;
	
	private static BufferedImage playerDownWalk1;
	private static BufferedImage playerDownWalk2;
	
	private static BufferedImage enemyImage;
	private static BufferedImage ghostImage;
	private static BufferedImage bossImage;

	
	private static BufferedImage fireball;
	private static BufferedImage instructions;
	private static BufferedImage pauseScreen;
	private static BufferedImage gameQuit;
	private static BufferedImage gameRestart;
	private static BufferedImage pauseQuit;
	private static BufferedImage pauseRestart;
	private static BufferedImage startQuit;
	private static BufferedImage gameStart;
	private static BufferedImage pauseItem;

	
	private static BufferedImage healthPotion;
	private static BufferedImage manaPotion;	
	private static BufferedImage invinciblePotion;
	private static BufferedImage border;
	private static BufferedImage healthBar;
	private static BufferedImage manaBar;
	private static BufferedImage barOutline;
	private static BufferedImage winRestart;
	private static BufferedImage winQuit;

	
	/**
	 * @return the barOutline
	 */
	public static BufferedImage getBarOutline() {
		return barOutline;
	}
	
	/**
	 * @param barOutline the barOutline to set
	 */
	public static void setBarOutline(BufferedImage barOutline) {
		Render.barOutline = barOutline;
	}
	
	/**
	 * @return the manaBar
	 */
	public static BufferedImage getManaBar() {
		return manaBar;
	}
	
	/**
	 * @param manaBar the manaBar to set
	 */
	public static void setManaBar(BufferedImage manaBar) {
		Render.manaBar = manaBar;
	}
	
	/**
	 * @return the healthBar
	 */
	public static BufferedImage getHealthBar() {
		return healthBar;
	}
	
	/**
	 * @param healthBar the healthBar to set
	 */
	public static void setHealthBar(BufferedImage healthBar) {
		Render.healthBar = healthBar;
	}
	
	/**
	 * @return the border
	 */
	public static BufferedImage getBorder() {
		return border;
	}
	
	/**
	 * @param border the border to set
	 */
	public static void setBorder(BufferedImage border) {
		Render.border = border;
	}
	
	/**
	 * @return the healthPotion
	 */
	public static BufferedImage getHealthPotion() {
		return healthPotion;
	}
	
	/**
	 * @param healthPotion the healthPotion to set
	 */
	public static void setHealthPotion(BufferedImage healthPotion) {
		Render.healthPotion = healthPotion;
	}
	
	/**
	 * @return the invinciblePotion
	 */
	public static BufferedImage getInvinciblePotion() {
		return invinciblePotion;
	}
	
	/**
	 * @param invinciblePotion the invinciblePotion to set
	 */
	public static void setInvinciblePotion(BufferedImage healthPotion) {
		Render.invinciblePotion = healthPotion;
	}
	
	/**
	 * @return the manaPotion
	 */
	public static BufferedImage getManaPotion() {
		return manaPotion;
	}
	
	/**
	 * @param manaPotion the manaPotion to set
	 */
	public static void setManaPotion(BufferedImage healthPotion) {
		Render.manaPotion = healthPotion;
	}
	
	/**
	 * @return the playerStop
	 */
	public static BufferedImage getPlayerStop() {
		return playerStop;
	}

	/**
	 * @param playerStop the playerStop to set
	 */
	public static void setPlayerStop(BufferedImage playerStop) {
		Render.playerStop = playerStop;
	}

	/**
	 * @return the playerUp
	 */
	public static BufferedImage getPlayerUp() {
		return playerUp;
	}

	/**
	 * @param playerUp the playerUp to set
	 */
	public static void setPlayerUp(BufferedImage playerUp) {
		Render.playerUp = playerUp;
	}

	/**
	 * @return the playerDown
	 */
	public static BufferedImage getPlayerDown() {
		return playerDown;
	}

	/**
	 * @param playerDown the playerDown to set
	 */
	public static void setPlayerDown(BufferedImage playerDown) {
		Render.playerDown = playerDown;
	}

	/**
	 * @return the playerLeft
	 */
	public static BufferedImage getPlayerLeft() {
		return playerLeft;
	}

	/**
	 * @param playerLeft the playerLeft to set
	 */
	public static void setPlayerLeft(BufferedImage playerLeft) {
		Render.playerLeft = playerLeft;
	}

	/**
	 * @return the playerRight
	 */
	public static BufferedImage getPlayerRight() {
		return playerRight;
	}

	/**
	 * @param playerRight the playerRight to set
	 */
	public static void setPlayerRight(BufferedImage playerRight) {
		Render.playerRight = playerRight;
	}

	/**
	 * @return the playerRightStanding
	 */
	public static BufferedImage getPlayerRightStanding() {
		return playerRightStanding;
	}

	/**
	 * @param playerRightStanding the playerRightStanding to set
	 */
	public static void setPlayerRightStanding(BufferedImage playerRightStanding) {
		Render.playerRightStanding = playerRightStanding;
	}

	/**
	 * @return the playerLeftStanding
	 */
	public static BufferedImage getPlayerLeftStanding() {
		return playerLeftStanding;
	}

	/**
	 * @param playerLeftStanding the playerLeftStanding to set
	 */
	public static void setPlayerLeftStanding(BufferedImage playerLeftStanding) {
		Render.playerLeftStanding = playerLeftStanding;
	}

	/**
	 * @return the playerDownStanding
	 */
	public static BufferedImage getPlayerDownStanding() {
		return playerDownStanding;
	}

	/**
	 * @param playerDownStanding the playerDownStanding to set
	 */
	public static void setPlayerDownStanding(BufferedImage playerDownStanding) {
		Render.playerDownStanding = playerDownStanding;
	}

	/**
	 * @return the playerUpStanding
	 */
	public static BufferedImage getPlayerUpStanding() {
		return playerUpStanding;
	}

	/**
	 * @param playerUpStanding the playerUpStanding to set
	 */
	public static void setPlayerUpStanding(BufferedImage playerUpStanding) {
		Render.playerUpStanding = playerUpStanding;
	}

	/**
	 * @return the playerRightWalk1
	 */
	public static BufferedImage getPlayerRightWalk1() {
		return playerRightWalk1;
	}

	/**
	 * @param playerRightWalk1 the playerRightWalk1 to set
	 */
	public static void setPlayerRightWalk1(BufferedImage playerRightWalk1) {
		Render.playerRightWalk1 = playerRightWalk1;
	}

	/**
	 * @return the playerRightWalk2
	 */
	public static BufferedImage getPlayerRightWalk2() {
		return playerRightWalk2;
	}

	/**
	 * @param playerRightWalk2 the playerRightWalk2 to set
	 */
	public static void setPlayerRightWalk2(BufferedImage playerRightWalk2) {
		Render.playerRightWalk2 = playerRightWalk2;
	}

	/**
	 * @return the playerLeftWalk1
	 */
	public static BufferedImage getPlayerLeftWalk1() {
		return playerLeftWalk1;
	}

	/**
	 * @param playerLeftWalk1 the playerLeftWalk1 to set
	 */
	public static void setPlayerLeftWalk1(BufferedImage playerLeftWalk1) {
		Render.playerLeftWalk1 = playerLeftWalk1;
	}

	/**
	 * @return the playerLeftWalk2
	 */
	public static BufferedImage getPlayerLeftWalk2() {
		return playerLeftWalk2;
	}

	/**
	 * @param playerLeftWalk2 the playerLeftWalk2 to set
	 */
	public static void setPlayerLeftWalk2(BufferedImage playerLeftWalk2) {
		Render.playerLeftWalk2 = playerLeftWalk2;
	}

	/**
	 * @return the playerForwardWalk1
	 */
	public static BufferedImage getPlayerForwardWalk1() {
		return playerForwardWalk1;
	}

	/**
	 * @param playerForwardWalk1 the playerForwardWalk1 to set
	 */
	public static void setPlayerForwardWalk1(BufferedImage playerForwardWalk1) {
		Render.playerForwardWalk1 = playerForwardWalk1;
	}

	/**
	 * @return the playerForwardWalk2
	 */
	public static BufferedImage getPlayerForwardWalk2() {
		return playerForwardWalk2;
	}

	/**
	 * @param playerForwardWalk2 the playerForwardWalk2 to set
	 */
	public static void setPlayerForwardWalk2(BufferedImage playerForwardWalk2) {
		Render.playerForwardWalk2 = playerForwardWalk2;
	}

	/**
	 * @return the playerDownWalk1
	 */
	public static BufferedImage getPlayerDownWalk1() {
		return playerDownWalk1;
	}

	/**
	 * @param playerDownWalk1 the playerDownWalk1 to set
	 */
	public static void setPlayerDownWalk1(BufferedImage playerDownWalk1) {
		Render.playerDownWalk1 = playerDownWalk1;
	}

	/**
	 * @return the playerDownWalk2
	 */
	public static BufferedImage getPlayerDownWalk2() {
		return playerDownWalk2;
	}

	/**
	 * @param playerDownWalk2 the playerDownWalk2 to set
	 */
	public static void setPlayerDownWalk2(BufferedImage playerDownWalk2) {
		Render.playerDownWalk2 = playerDownWalk2;
	}

	/**
	 * @return the enemyImage
	 */
	public static BufferedImage getEnemyImage() {
		return enemyImage;
	}

	/**
	 * @param enemyImage the enemyImage to set
	 */
	public static void setEnemyImage(BufferedImage enemyImage) {
		Render.enemyImage = enemyImage;
	}

	/**
	 * @return the ghostImage
	 */
	public static BufferedImage getGhostImage() {
		return ghostImage;
	}

	/**
	 * @param ghostImage the ghostImage to set
	 */
	public static void setGhostImage(BufferedImage ghostImage) {
		Render.ghostImage = ghostImage;
	}
	/**
	 * @return the bossImage
	 */
	public static BufferedImage getBossImage() {
		return bossImage;
	}

	/**
	 * @param bossImage the bossImage to set
	 */
	public static void setBossImage(BufferedImage bossImage) {
		Render.bossImage = bossImage;
	}


	/**
	 * @return the fireball
	 */
	public static BufferedImage getFireball() {
		return fireball;
	}

	/**
	 * @param fireball the fireball to set
	 */
	public static void setFireball(BufferedImage fireball) {
		Render.fireball = fireball;
	}
	
	
	/**
	 * @return the instructions
	 */
	public static BufferedImage getInstructions() {
		return instructions;
	}

	/**
	 * @param pauseScreen the pauseScreen to set
	 */
	public static void setInstructions(BufferedImage instructions) {
		Render.instructions = instructions;
	}

	/**
	 * @return the pauseScreen
	 */
	public static BufferedImage getPauseScreen() {
		return pauseScreen;
	}

	/**
	 * @param pauseScreen the pauseScreen to set
	 */
	public static void setPauseScreen(BufferedImage pauseScreen) {
		Render.pauseScreen = pauseScreen;
	}

	
	/**
	 * @return the pauseItem
	 */
	public static BufferedImage getPauseItem() {
		return pauseItem;
	}

	/**
	 * @param pauseItem the pauseItem to set
	 */
	public static void setPauseItem(BufferedImage pauseItem) {
		Render.pauseItem = pauseItem;
	}
	
	/**
	 * @return the gameQuit
	 */
	public static BufferedImage getGameQuit() {
		return gameQuit;
	}

	/**
	 * @param gameQuit the gameQuit to set
	 */
	public static void setGameQuit(BufferedImage gameQuit) {
		Render.gameQuit = gameQuit;
	}
	
	/**
	 * @return the win Quit
	 */
	public static BufferedImage getWinQuit() {
		return winQuit;
	}

	/**
	 * @param winQuit the winQuit to set
	 */
	public static void setWinQuit(BufferedImage winQuit) {
		Render.winQuit = winQuit;
	}
	
	/**
	 * @return the winRestart
	 */
	public static BufferedImage getWinRestart() {
		return winRestart;
	}

	/**
	 * @param gameQuit the gameQuit to set
	 */
	public static void setWinRestart(BufferedImage winRestart) {
		Render.winRestart = winRestart;
	}

	/**
	 * @return the gameRestart
	 */
	public static BufferedImage getGameRestart() {
		return gameRestart;
	}

	/**
	 * @param gameRestart the gameRestart to set
	 */
	public static void setGameRestart(BufferedImage gameRestart) {
		Render.gameRestart = gameRestart;
	}

	/**
	 * @return the pauseQuit
	 */
	public static BufferedImage getPauseQuit() {
		return pauseQuit;
	}

	/**
	 * @param pauseQuit the pauseQuit to set
	 */
	public static void setPauseQuit(BufferedImage pauseQuit) {
		Render.pauseQuit = pauseQuit;
	}

	/**
	 * @return the pauseRestart
	 */
	public static BufferedImage getPauseRestart() {
		return pauseRestart;
	}

	/**
	 * @param pauseRestart the pauseRestart to set
	 */
	public static void setPauseRestart(BufferedImage pauseRestart) {
		Render.pauseRestart = pauseRestart;
	}

	/**
	 * @return the startQuit
	 */
	public static BufferedImage getStartQuit() {
		return startQuit;
	}

	/**
	 * @param startQuit the startQuit to set
	 */
	public static void setStartQuit(BufferedImage startQuit) {
		Render.startQuit = startQuit;
	}

	/**
	 * @return the gameStart
	 */
	public static BufferedImage getGameStart() {
		return gameStart;
	}

	/**
	 * @param gameStart the gameStart to set
	 */
	public static void setGameStart(BufferedImage gameStart) {
		Render.gameStart = gameStart;
	}

	/**
	 * Function to load the images into the game and 
	 * store them to variables to be rendered later
	 */
	public static void load()
	{
		// Try/catch for in case image can't be found
		try {
			System.out.println("image loaded");
			playerStop = ImageIO.read(new File("src/player_images/forward_stand.gif"));
			playerUp = ImageIO.read(new File("src/player_images/forward_walk1.gif"));
			playerDown = ImageIO.read(new File("src/player_images/down_stand.gif"));
			playerLeft = ImageIO.read(new File("src/player_images/left_stand.gif"));
			playerRight = ImageIO.read(new File("src/player_images/right_stand.gif"));
			
			playerRightWalk1 = ImageIO.read(new File("src/player_images/right_walk1.gif"));
			playerRightWalk2 = ImageIO.read(new File("src/player_images/right_walk2.gif"));
			
			playerLeftWalk1 = ImageIO.read(new File("src/player_images/left_walk1.gif"));
			playerLeftWalk2 = ImageIO.read(new File("src/player_images/left_walk2.gif"));
			
			playerForwardWalk1 = ImageIO.read(new File("src/player_images/forward_walk1.gif"));
			playerForwardWalk2 = ImageIO.read(new File("src/player_images/forward_walk2.gif"));
			
			playerDownWalk1 = ImageIO.read(new File("src/player_images/down_walk1.gif"));
			playerDownWalk2 = ImageIO.read(new File("src/player_images/down_walk2.gif"));
			
			playerRightStanding = ImageIO.read(new File("src/player_images/right_stand.gif"));
			playerLeftStanding = ImageIO.read(new File("src/player_images/left_stand.gif"));
			playerDownStanding = ImageIO.read(new File("src/player_images/down_stand.gif"));
			playerUpStanding = ImageIO.read(new File("src/player_images/forward_stand.gif"));
			
			instructions = ImageIO.read(new File("src/Images/cutscene.PNG"));//QuitPause

			pauseQuit = ImageIO.read(new File("src/Images/pQuit.PNG"));//QuitPause
			pauseRestart = ImageIO.read(new File("src/Images/pRestart.PNG"));//RestartPause
			gameRestart = ImageIO.read(new File("src/Images/RestartGame.PNG"));
			pauseItem = ImageIO.read(new File("src/Images/pItem.PNG"));//QuitPause

			gameQuit = ImageIO.read(new File("src/Images/QuitGame.PNG"));
			gameStart = ImageIO.read(new File("src/Images/GameStart.PNG"));
			startQuit = ImageIO.read(new File("src/Images/StartQuit.PNG"));
			winRestart = ImageIO.read(new File("src/Images/winRestart.PNG"));
			winQuit = ImageIO.read(new File("src/Images/winQuit.PNG"));

			enemyImage = ImageIO.read(new File("src/Images/blob.gif"));
			ghostImage = ImageIO.read(new File("src/Images/ghost.png"));
			bossImage = ImageIO.read(new File("src/Images/BossEnemy.png"));


			fireball = ImageIO.read(new File("src/Images/fireball.gif"));
			healthPotion = ImageIO.read(new File("src/itemImages/healthPotion.PNG"));
			manaPotion = ImageIO.read(new File("src/itemImages/manaPotion.png"));
			invinciblePotion = ImageIO.read(new File("src/itemImages/invincibilityPotion.png"));
			
			border = ImageIO.read(new File("src/Images/border.png"));
			healthBar = ImageIO.read(new File("src/Images/healthBar.png"));
			manaBar = ImageIO.read(new File("src/Images/manaBar.png"));
			barOutline = ImageIO.read(new File("src/Images/barOutlines.png"));






		} catch (IOException e) {
			//If not found print error message
			System.out.print("Failed to load image");
			e.printStackTrace();
		}
	}
	
	/**
	 * Load Image for to render later
	 * @param str string to use to find the image
	 * @return return the image found
	 */
	public BufferedImage loadImage(String str) {
		BufferedImage img = null;

		InputStream is = Render.class.getResourceAsStream(str);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}