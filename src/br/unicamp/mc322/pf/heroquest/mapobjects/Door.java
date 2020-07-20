package br.unicamp.mc322.pf.heroquest.mapobjects;

public class Door extends MapObject {
	private boolean isOpened;
	
	public Door(int posX, int posY) {
		super(posX, posY);
		isOpened = false;
	}
	
	public void interact() {
		isOpened = !isOpened;
	}
}
