package game.objects.structure;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.objects.GameObject;
import game.objects.ID;
import game.render.SpriteSheet;

public class InvisibleBlock extends GameObject{
	//Hold object sprite image
		private BufferedImage blockImage;
		
		/**
		 * Block Constructor
		 * @param x axis location of enemy
		 * @param y axis location of enemy
		 * @param id of object
		 * @param ss sprite image of object
		 */
		public InvisibleBlock(int x, int y, ID id, SpriteSheet ss) {
			super(x,y,id, ss);
			blockImage = ss.grabImage(2,1,32,32);
		}
		/**
		 * Update the object on tick
		 */
		@Override
		public void tick() {
			
		}
		
		/**
		 * render object image
		 */
		@Override
		public void render(Graphics g) {
			/*g.drawImage(blockImage, getX(), getY(),Change x size,Change x size, null);*/
			g.drawImage(blockImage, getX(), getY(),32,32, null);
		}
		
		/**
		 * Add object hitbox
		 */
		@Override
		public Rectangle getBounds() {
			return new Rectangle(getX(),getY(),32,32);
		}
}
