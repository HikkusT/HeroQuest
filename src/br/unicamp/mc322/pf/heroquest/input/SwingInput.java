package br.unicamp.mc322.pf.heroquest.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingInput implements Input, KeyListener {
	private volatile Command cachedCommand;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			cachedCommand = Command.MOVE_UP;
			break;
		case KeyEvent.VK_D:
			cachedCommand = Command.MOVE_RIGHT;
			break;
		case KeyEvent.VK_S:
			cachedCommand = Command.MOVE_DOWN;
			break;
		case KeyEvent.VK_A:
			cachedCommand = Command.MOVE_LEFT;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Not interested
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Not interested
	}

	@Override
	public Command waitForNextCommand() {
		cachedCommand = null;
		while (cachedCommand == null) { }
		return cachedCommand;
	}
	
}
