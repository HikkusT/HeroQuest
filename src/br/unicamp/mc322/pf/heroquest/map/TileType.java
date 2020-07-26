package br.unicamp.mc322.pf.heroquest.map;

public enum TileType {
	FLOOR(true, true, ".", "Floor.png"),
	WALL(false, false, "#", "Wall.png");
	
	private final boolean isTransposable;
	private final boolean isTranslucent;
	private final String stringRepresentation;
	private final String sprite;
	
	private TileType(boolean isTransposable, boolean isTranslucent, String stringRepresentation, String sprite) {
		this.isTransposable = isTransposable;
		this.isTranslucent = isTranslucent;
		this.stringRepresentation = stringRepresentation;
		this.sprite = sprite;
	}
	
	public boolean isTransposable() {
		return isTransposable;
	}
	
	public boolean isTranslucent() {
		return isTranslucent;
	}
	
	public String getSprite() {
		return sprite;
	}
	
	@Override
	public String toString() {
		return stringRepresentation;
	}
}
