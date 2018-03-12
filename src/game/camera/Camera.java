package game.camera;

import game.engine.Game;
import game.objects.GameObject;
import game.objects.player.Player;

public class Camera {

	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject object) {
		
		x += ((object.getX() - x) - Game.WIDTH/2) * 0.05f;
		y += ((object.getY() - y) - Game.HEIGHT/2) * 0.05f;
		
		
		//All of these numbers are based of map size
		if(x <= 0) x = 0;
		if(x >= (Game.WIDTH)) x = (Game.WIDTH);
		if(y <= 0) y = 0;
		if(y >= (Game.HEIGHT + 288)) y = (Game.HEIGHT + 288);
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
}
