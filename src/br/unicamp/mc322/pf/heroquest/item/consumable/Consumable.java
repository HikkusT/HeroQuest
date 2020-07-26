package br.unicamp.mc322.pf.heroquest.item.consumable;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public interface Consumable {
	//Consumables are items that are consumed when used.
	public abstract void consume(Entity user);
}
