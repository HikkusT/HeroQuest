package br.unicamp.mc322.pf.heroquest.utils;

public enum Direction {
	NORTH(new Vector2(0, 1)),
	EAST(new Vector2(1, 0)),
	SOUTH(new Vector2(0, -1)),
	WEST(new Vector2(-1, 0));
	
	private Vector2 direction;
	
	private Direction(Vector2 direction) {
		this.direction = direction;
	}
	
	public Vector2 toVector2() {
		return direction;
	}
}
