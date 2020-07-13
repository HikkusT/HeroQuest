package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.item.HandednessType;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.item.Equipable;

public abstract class Weapon extends Item implements Equipable {
	private int attackPoints;
	private int range;
	private HandednessType handedness;
	
	Weapon(String ItemName, int attackPoints, int range, HandednessType handedness){
		super(ItemName);
		this.attackPoints = attackPoints;
		this.range = range;		
	}
	
	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public HandednessType getHandedness() {
		return handedness;
	}


	@Override
	public abstract void equip();
	
	@Override
	public abstract void unequip();
}
