package br.unicamp.mc322.pf.heroquest.input;

public enum Command {
	MOVE_UP,
	MOVE_RIGHT,
	MOVE_DOWN,
	MOVE_LEFT,
	OPEN_DOOR,
	SEARCH_TREASURES,
	SEARCH_TRAPS,
	DISARM_TRAP,
	ATTACK,
	CAST;
	
	public boolean isMovementCommand() {
		if (this == MOVE_UP || this == MOVE_RIGHT || this == MOVE_DOWN || this == MOVE_LEFT)
			return true;
		else
			return false;
	}
	
	public boolean isActionCommand() {
		if (this == SEARCH_TREASURES || this == SEARCH_TRAPS || this == DISARM_TRAP || this == ATTACK || this == CAST)
			return true;
		else
			return false;
	}
	
	public boolean isCombatCommand() {
		if (this == ATTACK || this == CAST)
			return true;
		else
			return false;
	}
}
