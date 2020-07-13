package br.unicamp.mc322.pf.heroquest.utils;

public class Vector2 {
	private int x;
	private int y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Vector2 vector) {
		return x == vector.x && y == vector.y;
	}
	
	public static Vector2 sum(Vector2 leftVector, Vector2 rightVector) {
		return new Vector2(leftVector.getX() + rightVector.getX(), leftVector.getY() + rightVector.getY());
	}
}
