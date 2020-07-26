package br.unicamp.mc322.pf.heroquest.input;

public enum Command {
	MOVE_UP,
	MOVE_RIGHT,
	MOVE_DOWN,
	MOVE_LEFT;
	
	public static boolean isMovementCommand(Command command) {
		if (command == MOVE_UP || command == MOVE_RIGHT || command == MOVE_DOWN || command == MOVE_LEFT)
			return true;
		else
			return false;
	}
}
