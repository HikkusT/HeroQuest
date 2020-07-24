package br.unicamp.mc322.pf.heroquest.item;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public interface Consumable {
	//Consumables are items that are consumed when used.
	void consume(Entity user);
}
