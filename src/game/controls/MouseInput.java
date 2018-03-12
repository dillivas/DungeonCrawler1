package game.controls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.engine.Handler;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		//int mx = (int) (e.getX() + camera.getX());
	}
}
