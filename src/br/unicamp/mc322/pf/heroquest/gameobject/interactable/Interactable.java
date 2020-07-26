package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Interactable extends GameObject {
	

	public Interactable(Vector2 position) {
		super(position);
	}
	
	public abstract void interact(InteractionType interaction, Hero user);
	
	@Override
	public boolean getTransposability() {
		return true;
	}
	
	@Override
	public boolean getTranslucency() {
		return true;
	}
}
