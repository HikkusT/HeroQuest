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
		case KeyEvent.VK_E:
			cachedCommand = Command.OPEN_DOOR;
			break;
		case KeyEvent.VK_1:
			cachedCommand = Command.SEARCH_TREASURES;
			break;
		case KeyEvent.VK_2:
			cachedCommand = Command.SEARCH_TRAPS;
			break;
		case KeyEvent.VK_3:
			cachedCommand = Command.DISARM_TRAP;
			break;
		case KeyEvent.VK_4:
			cachedCommand = Command.AUX;
			break;	
		case KeyEvent.VK_SPACE:
			cachedCommand = Command.ATTACK;
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
