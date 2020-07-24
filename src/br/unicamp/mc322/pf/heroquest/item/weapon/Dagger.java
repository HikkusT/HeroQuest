package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Consumable;

public class Dagger extends OneHandedWeapon implements Consumable {

	public Dagger() {
		super("Dagger", 1, 1);
	}
	@Override
	public int attack() {
		//this.consume();
		return this.attackPoints;
	}

	@Override
	public void consume(Entity user) {
		
	}
}
