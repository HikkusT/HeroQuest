package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Interactable extends GameObject {
	

	public Interactable(Vector2 position, boolean isTranslucent) {
		super(position, isTranslucent);
	}
}
