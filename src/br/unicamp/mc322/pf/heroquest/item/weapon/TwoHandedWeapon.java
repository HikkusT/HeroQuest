package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class TwoHandedWeapon extends Weapon {

	public TwoHandedWeapon(String ItemName, int attackPoints, int range) {
		super(ItemName, attackPoints, range, HandednessType.TWOHANDED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip(Entity entity) {
		
	}

	@Override
	public void unequip(Entity entity) {
		
	}
}
