package br.unicamp.mc322.pf.heroquest.item.weapon;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;
import br.unicamp.mc322.pf.heroquest.item.equipment.WeaponSlot;

public abstract class OneHandedWeapon extends Weapon {

	public OneHandedWeapon(String ItemName, int attackPoints, int range) {
		super(ItemName, attackPoints, range, HandednessType.ONEHANDED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equip(Set set){
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();
		
		if (leftWeaponSlot.isEmpty()) {
			leftWeaponSlot.setEquipment(this);
		}
		else if (rightWeaponSlot.isEmpty()) {
			rightWeaponSlot.setEquipment(this);
		}
		
		return leftWeaponSlot.isEmpty() || rightWeaponSlot.isEmpty();
	}
	
	@Override
	public Equipment unequip(Set set){
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();
		Equipment removedEquipment = null;
		
		if (!leftWeaponSlot.isEmpty()) {
			removedEquipment = leftWeaponSlot.removeEquipment();
		}
		else if (!rightWeaponSlot.isEmpty()) {
			removedEquipment = rightWeaponSlot.removeEquipment();
		}
		
		return removedEquipment;		
	}
}
