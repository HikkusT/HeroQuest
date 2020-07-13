package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.item.HandednessType;

public abstract class OneHandedWeapon extends Weapon {

	public OneHandedWeapon(String ItemName, int attackPoints, int range) {
		super(ItemName, attackPoints, range, HandednessType.ONEHANDED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void equip();

	@Override
	public abstract void unequip();
}
