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
		
		public BufferedImage getRoom(int col, int row) {
			return blockImage[col-1][row-1];
		}

		public int getPlayerLocY() {
			return playerLocY;
		}

		public void setPlayerLocY(int playerLocY) {
			this.playerLocY = playerLocY;
		}

		public int getPlayerLocX() {
			return playerLocX;
		}

		public void setPlayerLocX(int playerLocX) {
			this.playerLocX = playerLocX;
		}

		public int getPlayerInRoomX() {
			return playerInRoomX;
		}

		public void setPlayerInRoomX(int playerInRoomX) {
			this.playerInRoomX = playerInRoomX;
		}

		public int getPlayerInRoomY() {
			return playerInRoomY;
		}

		public void setPlayerInRoomY(int playerInRoomY) {
			this.playerInRoomY = playerInRoomY;
		}

		public boolean getLeftRoom() {
			return leftRoom;
		}

		public void setLeftRoom(boolean leftRoom) {
			this.leftRoom = leftRoom;
		}

		public int getNextPlayerRoom() {
			return nextPlayerRoom;
		}

		public void setNextPlayerRoom(int nextPlayerRoom) {
			this.nextPlayerRoom = nextPlayerRoom;
		}
}