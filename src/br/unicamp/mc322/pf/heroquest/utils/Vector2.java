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
	
	public Vector2 translated(Direction direction) {
		return sum(this, direction.toVector2());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Vector2))
			return false;

		Vector2 vector = (Vector2) obj;
		return x == vector.x && y == vector.y;
	}

	@Override
	public int hashCode() {
		return 486187739 * y + x;
	}

	public static Vector2 sum(Vector2 leftVector, Vector2 rightVector) {
		return new Vector2(leftVector.getX() + rightVector.getX(), leftVector.getY() + rightVector.getY());
	}

	public static int distance(Vector2 leftVector, Vector2 rightVector) {
		int distanceX = Math.abs(leftVector.getX() - rightVector.getX());
		int distanceY = Math.abs(leftVector.getY() - rightVector.getY());
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
		return (int)Math.ceil(distance);
	}

	@Override
	public String toString() {
		return "X: " + x + " Y: " + y;
	}
}
