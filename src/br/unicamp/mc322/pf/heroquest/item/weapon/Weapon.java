package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class Weapon extends Equipment {
	protected int attackPoints;
	private int range;
	private HandednessType handedness;
	
	Weapon(String ItemName, int attackPoints, int range, HandednessType handedness){
		super(ItemName);
		this.attackPoints = attackPoints;
		this.range = range;		
	}
	
	public int attack(Entity user) {
		return attackPoints;
	}

	public int getRange() {
		return range;
	}

	public HandednessType getHandedness() {
		return handedness;
	}

}
