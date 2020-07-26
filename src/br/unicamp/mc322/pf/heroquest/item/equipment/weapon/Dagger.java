package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public class Dagger extends TwoHandedWeapon{
	private final static String NAME = "Dagger";
	private final static int ATTACKPOINTS = 1;
	private final static int RANGE = 3;
	private int charges = 3;

	public Dagger() {
		super(NAME, ATTACKPOINTS, RANGE);
	}
	
	
	@Override
	public int attack(Entity user) {
		charges -= 1;
		if (charges == 0) {
		}
		return this.attackPoints;
	}
}
