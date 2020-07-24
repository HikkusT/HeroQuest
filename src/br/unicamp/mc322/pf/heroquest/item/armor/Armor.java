package br.unicamp.mc322.pf.heroquest.item.armor;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Equipable;
import br.unicamp.mc322.pf.heroquest.item.Item;

public abstract class Armor extends Item implements Equipable {

	private int defensePoints;
	public Armor(String itemName, int defensePoints) {
		super(itemName);
		this.defensePoints =  defensePoints;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip(Entity entity) {
		
	}

	@Override
	public void unequip(Entity entity) {
		
	}
	
	public int getDefensePoints() {
		return defensePoints;
	}

}
