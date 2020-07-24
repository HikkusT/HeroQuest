package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class OneHandedWeapon extends Weapon {

	public OneHandedWeapon(String ItemName, int attackPoints, int range) {
		super(ItemName, attackPoints, range, HandednessType.ONEHANDED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip(Entity entity) {
		entity.equiWeapon(this);
		
	}

	@Override
	public void unequip(Entity entity) {
		
	}
}
