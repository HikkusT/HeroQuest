package br.unicamp.mc322.pf.heroquest.item.potion;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public interface Consumable {
	//Consumables are things that are consumed when used.
	public abstract void consume(Entity user);
}
