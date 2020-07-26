package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class Weapon extends Equipment {
	protected int attackPoints;
	private int range;
	
	Weapon(int attackPoints, int range){
		super();
		this.attackPoints = attackPoints;
		this.range = range;		
	}
	
	public int attack(Entity user) {
		return attackPoints;
	}

	public int getRange() {
		return range;
	}

	public abstract HandednessType getHandedness();

}
