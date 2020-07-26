package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Door extends Interactable {
	private static final boolean ISTRANSLUCENT = false;
	private static final boolean ISTRANSPOSABLE = false;

	private boolean isOpened;
	
	
	public Door(Vector2 position) {
		super(position, ISTRANSLUCENT, ISTRANSPOSABLE);
		isOpened = false;
	}
	
	public void interact(InteractionType interaction, Hero user) {
		if (interaction == InteractionType.INTERACTDOOR) {
			isOpened = !isOpened;
		}	
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
