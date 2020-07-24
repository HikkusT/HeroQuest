package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Equipable;

public abstract class Weapon extends Item implements Equipable {
	protected int attackPoints;
	private int range;
	private HandednessType handedness;
	
	Weapon(String ItemName, int attackPoints, int range, HandednessType handedness){
		super(ItemName);
		this.attackPoints = attackPoints;
		this.range = range;		
	}
	
	public int attack() {
		return attackPoints;
	}
	

	public int getRange() {
		return range;
	}

	public HandednessType getHandedness() {
		return handedness;
	}


	@Override
	public abstract void equip(Entity entity);
	
	@Override
	public abstract void unequip(Entity entity);
	
}
