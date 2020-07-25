package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Door extends Interactable {
	private boolean isOpened;
	
	public Door(Vector2 position) {
		super(position, false, false);
		isOpened = false;
	}
	
	public void interact() {
		isOpened = !isOpened;
	}
	
	@Override
	public boolean getTranslucency() {
		return isOpened;
	}
	
	@Override
	public boolean getTransposability() {
		return isOpened;
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return "Door.png";
	}
}
