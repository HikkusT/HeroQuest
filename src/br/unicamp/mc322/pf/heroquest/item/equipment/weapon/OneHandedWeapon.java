package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;
import br.unicamp.mc322.pf.heroquest.item.equipment.WeaponSlot;

public abstract class OneHandedWeapon extends Weapon {

	public OneHandedWeapon(int attackPoints, int range) {
		super(attackPoints, range);
	}
	
	@Override
	public HandednessType getHandedness() {
		return HandednessType.ONEHANDED;
	}

	@Override
	public boolean equip(Set set){
		WeaponSlot leftWeaponSlot = set.getLeftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();
		WeaponSlot twoHandWeaponSlot = set.getTwoHandWeaponSlot();
		
		boolean leftWeaponSlotState = leftWeaponSlot.isEmpty();
		boolean rightWeaponSlotState = rightWeaponSlot.isEmpty();
		boolean twoHandWeaponSlotState = twoHandWeaponSlot.isEmpty();
		
		if (leftWeaponSlotState && twoHandWeaponSlotState) {
			leftWeaponSlot.setEquipment(this);
		}
		else if (rightWeaponSlotState && twoHandWeaponSlotState) {
			rightWeaponSlot.setEquipment(this);
		}
		
		return (leftWeaponSlotState || rightWeaponSlotState) && twoHandWeaponSlotState;
	}
	
	@Override
	public Equipment unequip(Set set){
		WeaponSlot leftWeaponSlot = set.getLeftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();
		WeaponSlot twoHandWeaponSlot = set.getTwoHandWeaponSlot();
		
		Equipment removedEquipment = null;
		
		if (!leftWeaponSlot.isEmpty()) {
			removedEquipment = leftWeaponSlot.removeEquipment();
		}
		else if (!rightWeaponSlot.isEmpty()) {
			removedEquipment = rightWeaponSlot.removeEquipment();
		}
		else if (! twoHandWeaponSlot.isEmpty()) {
			removedEquipment =  twoHandWeaponSlot.removeEquipment();
		}
		
		return removedEquipment;		
	}
}
