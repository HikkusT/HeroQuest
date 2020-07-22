package br.unicamp.mc322.pf.heroquest.gameobject.interactable;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Treasure extends Interactable {
	private Item[] content;
	private Trap trap;
	private boolean isOpened;
	
	public Treasure(Vector2 position, boolean isTranslucent, Item[] items) {
		super(position, isTranslucent);
		isOpened = false;
		content = items;
	}
	
	public Treasure(Vector2 position, boolean isTranslucent, Trap trap) {
		super(position, isTranslucent);
		isOpened = false;
		this.trap = trap;
	}
	
	public void interact() {
		isOpened = true;
	}
}
