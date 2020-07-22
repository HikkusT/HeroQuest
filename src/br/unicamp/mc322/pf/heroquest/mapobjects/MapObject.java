package br.unicamp.mc322.pf.heroquest.mapobjects;

public class MapObject {
	private int posX;
	private int posY;

	public MapObject(int posX, int posY) {
		posX = posX;
		posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
}
