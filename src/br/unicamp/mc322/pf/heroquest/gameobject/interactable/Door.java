package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Door extends Interactable {
	private boolean isOpened;
	
	public Door(Vector2 position) {
		super(position, false);
		isOpened = false;
	}
	
	public void interact() {
		isOpened = !isOpened;
		isTranslucent = !isTranslucent;
	}
}
