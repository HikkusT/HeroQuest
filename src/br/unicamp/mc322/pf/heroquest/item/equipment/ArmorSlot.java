package br.unicamp.mc322.pf.heroquest.item.equipment;

import br.unicamp.mc322.pf.heroquest.item.armor.Armor;

public class ArmorSlot extends EquipmentSlot {

	public ArmorSlot() {
		super();
	}
	
	@Override
	public Armor getEquipment() {
		return (Armor) equipment;
	}

}
