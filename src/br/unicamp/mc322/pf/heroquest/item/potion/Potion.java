package br.unicamp.mc322.pf.heroquest.item.potion;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Item;

public abstract class Potion extends Item implements Consumable {

	@Override
	public void use(Entity user) {
		user.handlePotion(this);
	}
}
