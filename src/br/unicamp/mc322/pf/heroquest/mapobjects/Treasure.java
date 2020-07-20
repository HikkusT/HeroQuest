package br.unicamp.mc322.pf.heroquest.mapobjects;

public class Treasure extends MapObject {
	private Item[] content;
	private Trap trap;
	private boolean isOpened;
	
	public Treasure(int posX, int posY, Item[] items) {
		super(posX, posY);
		isOpened = false;
		content = items;
	}
	
	public Treasure(int posX, int posY, Trap trap) {
		super(posX, posY);
		isOpened = false;
		trap = trap;
	}
	
	public void interact() {
		isOpened = true;
	}
}
