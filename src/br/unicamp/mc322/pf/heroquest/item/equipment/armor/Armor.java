package br.unicamp.mc322.pf.heroquest.item.equipment.armor;

import br.unicamp.mc322.pf.heroquest.item.equipment.ArmorSlot;
import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;

public abstract class Armor extends Equipment {

	private int defensePoints;
	public Armor(String itemName, int defensePoints) {
		super();
		this.defensePoints =  defensePoints;

	}
	
	@Override
	public boolean equip(Set set){
		
		ArmorSlot armorSlot = set.getArmorSlot();
		boolean armorSlotState = armorSlot.isEmpty();
		if (armorSlotState) {
			armorSlot.setEquipment(this);
		}
		
		return armorSlotState;
	}
	
	@Override
	public Equipment unequip(Set set){
		ArmorSlot armorSlot = set.getArmorSlot();
		Equipment removedEquipment = null;
		
		if (!armorSlot.isEmpty()) {
			removedEquipment = armorSlot.removeEquipment();
		}
		return removedEquipment;
		
	}

	public int getDefensePoints() {
		return defensePoints;
	}

}
