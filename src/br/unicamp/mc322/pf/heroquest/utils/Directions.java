package br.unicamp.mc322.pf.heroquest.utils;

public enum Directions {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	public Vector2 toVector2() {
		switch (this) {
		case NORTH:
			return new Vector2(0, 1);
		case EAST:
			return new Vector2(1, 0);
		case SOUTH:
			return new Vector2(0, -1);
		case WEST:
			return new Vector2(-1, 0);
		default:
			throw new RuntimeException("Direction not defined");
		}
	}
}
