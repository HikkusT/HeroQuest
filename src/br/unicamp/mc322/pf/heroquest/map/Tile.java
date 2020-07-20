package br.unicamp.mc322.pf.heroquest.map;

public class Tile {
	private TileType type;
	
	public Tile() {
		this(TileType.FLOOR);
	}
	
	public Tile(TileType type) {
		this.type = type;
	}
	
	public boolean isLit() {
		return true;
	}
	
	public void iluminate() {
		
	}
	
	public String getSprite() {
		if (!isLit())
			return "Unlit.png";
		
		switch (type) {
		case WALL:
			return "Wall.png";
		default:
			return "Floor.png";
		}
	}
	
	@Override
	public String toString() {
		if (!isLit())
			return " ";
		
		switch (type) {
		case WALL:
			return "#";
		default:
			return ".";
		}
	}
}
