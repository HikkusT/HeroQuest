package br.unicamp.mc322.pf.heroquest.item.equipment;

import br.unicamp.mc322.pf.heroquest.item.Item;

public abstract class Equipment extends Item {

	public Equipment(String itemName) {
		super(itemName);
	}
	
	public abstract boolean equip(Set set);
	//Return true if the equipment can be equipped, else return false.
	
	public abstract Equipment unequip(Set set);
	//Return the removed equipment.

}
