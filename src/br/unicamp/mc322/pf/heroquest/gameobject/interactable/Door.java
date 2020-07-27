package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Door extends Interactable {
	private boolean isOpened;
	
	
	public Door(Vector2 position) {
		super(position);
		isOpened = false;
	}
	
	public void interact(InteractionType interaction, Hero user) {
		if (interaction == InteractionType.INTERACT_DOOR) {
			isOpened = true;
		}	
	}
	
	@Override
	public boolean getTransposability() {
		return isOpened;
	}
	
	@Override
	public boolean getTranslucency() {
		return isOpened;
	}
	
	@Override
	public boolean isVisible() {
		return !isOpened;
	}
	
	@Override
	public String getSprite() {
		return "Door.png";
	}
	
	@Override
	public String toString() {
		return "O";
	}
}
