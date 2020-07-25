package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;
import br.unicamp.mc322.pf.heroquest.item.equipment.WeaponSlot;

public abstract class TwoHandedWeapon extends Weapon {

	public TwoHandedWeapon(String ItemName, int attackPoints, int range) {
		super(ItemName, attackPoints, range, HandednessType.TWOHANDED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equip(Set set){
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();
		
		if (leftWeaponSlot.isEmpty() && rightWeaponSlot.isEmpty()) {
			leftWeaponSlot.setEquipment(this);
		}
		
		return leftWeaponSlot.isEmpty() && rightWeaponSlot.isEmpty();	
	}
	
	@Override
	public Equipment unequip(Set set){
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		Equipment removedEquipment = null;
		
		if (!leftWeaponSlot.isEmpty()) {
			removedEquipment = leftWeaponSlot.removeEquipment();
		}
		
		return removedEquipment;	
	}
}
