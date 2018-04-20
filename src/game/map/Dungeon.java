package game.map;

import java.awt.image.BufferedImage;

import game.render.SpriteSheet;

public class Dungeon {

	//This class controls the dungeon loading 
	
	public static final int MAP_COL = 6, MAP_ROW = 6;
	
		//Hold object sprite image
		private BufferedImage blockImage[][];
		private int playerInRoomX;
		private int playerInRoomY;
		private int playerLocY;
		private int playerLocX;
		private boolean leftRoom;
		private int nextPlayerRoom;
		
		//Hold the dungeon map
		public Dungeon(SpriteSheet ms){
			blockImage = new BufferedImage[MAP_ROW][MAP_COL];
			setLeftRoom(false);
			setNextPlayerRoom(0);
			
			//Set Player Room location
			setPlayerInRoomX(3);
			setPlayerInRoomY(5);
			
			//Set Player Spawn Point in first room
			setPlayerLocY(5*32);
			setPlayerLocX(8*32);
			
			//Load the map
			for(int col = 1; col <= MAP_COL; col++) {
				for(int row = 1; row <= MAP_ROW; row++) {
					blockImage[col-1][row-1] = ms.grabRoom(col, row, 17, 11);
				}
			}
		}
		
		/**
		 * Return the dungeon room image stored in the matrix.
		 * 
		 * @param col of room to return
		 * @param row of room to return
		 * @return The requested image of the dungeon room.
		 */
		public BufferedImage getRoom(int col, int row) {
			return blockImage[col-1][row-1];
		}

		/**
		 * Return the players Y location in the dungeon room.
		 * @return the players location in Y axis
		 */
		public int getPlayerLocY() {
			return playerLocY;
		}

		/**
		 * Set the players Y location in the dungeon room.
		 * @param playerLocY to set the player Y location
		 */
		public void setPlayerLocY(int playerLocY) {
			this.playerLocY = playerLocY;
		}

		/**
		 * Return the players X location in the dungeon room.
		 * @return the players location in X axis
		 */
		public int getPlayerLocX() {
			return playerLocX;
		}

		/**
		 * Set the players X location in the dungeon room.
		 * @param playerLocX to set the player X location
		 */
		public void setPlayerLocX(int playerLocX) {
			this.playerLocX = playerLocX;
		}

		/**
		 * Get the room in the dungeon matrix (X) that the player is in.
		 * @return X value of dungeon room
		 */
		public int getPlayerInRoomX() {
			return playerInRoomX;
		}

		/**
		 * Set the room in the dungeon matrix (X) that the player is in.
		 * @param playerInRoomX value of dungeon room to set.
		 */
		public void setPlayerInRoomX(int playerInRoomX) {
			this.playerInRoomX = playerInRoomX;
		}

		
		/**
		 * Get the room in the dungeon matrix (Y) that the player is in.
		 * @return Y value of dungeon room
		 */
		public int getPlayerInRoomY() {
			return playerInRoomY;
		}

		/**
		 * Set the room in the dungeon matrix (Y) that the player is in.
		 * @param playerInRoomY value of dungeon room to set.
		 */
		public void setPlayerInRoomY(int playerInRoomY) {
			this.playerInRoomY = playerInRoomY;
		}

		/**
		 * Return if the player has left the dungeon room.
		 * @return
		 */
		public boolean getLeftRoom() {
			return leftRoom;
		}

		/**
		 * Return if the player has left the dungeon room.
		 * @param leftRoom
		 */
		public void setLeftRoom(boolean leftRoom) {
			this.leftRoom = leftRoom;
		}

		/**
		 * Get next player room value
		 * @return room to load player into
		 */
		public int getNextPlayerRoom() {
			return nextPlayerRoom;
		}

		/**
		 * Set next player room value
		 * @param nextPlayerRoom room to load player into
		 */
		public void setNextPlayerRoom(int nextPlayerRoom) {
			this.nextPlayerRoom = nextPlayerRoom;
		}
}