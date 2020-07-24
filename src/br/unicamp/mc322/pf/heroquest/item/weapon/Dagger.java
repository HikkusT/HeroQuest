package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Consumable;

public class Dagger extends OneHandedWeapon{
	private int charges = 3;

	public Dagger() {
		super("Dagger", 1, 1);
	}
	@Override
	public int attack(Entity user) {
		charges -= 1;
		
		if (charges == 0) {
		}
		return this.attackPoints;
	}


}
