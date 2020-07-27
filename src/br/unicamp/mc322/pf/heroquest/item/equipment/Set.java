package br.unicamp.mc322.pf.heroquest.item.equipment;

public class Set {

	private ArmorSlot armorSlot;
	private WeaponSlot leftHandWeaponSlot;
	private WeaponSlot rightHandWeaponSlot;
	private WeaponSlot twoHandWeaponSlot;
	
	public Set() {
		armorSlot = new ArmorSlot();
		leftHandWeaponSlot = new WeaponSlot();
		rightHandWeaponSlot = new WeaponSlot();
		twoHandWeaponSlot =  new WeaponSlot();
	}
	
	public ArmorSlot getArmorSlot() {
		return armorSlot;
	}
	
	public WeaponSlot getLeftHandWeaponSlot() {
		return leftHandWeaponSlot;
	}
	
	public WeaponSlot getRightHandWeaponSlot() {
		return rightHandWeaponSlot;
	}
	
	public WeaponSlot getTwoHandWeaponSlot() {
		return twoHandWeaponSlot;
	}
	
	@Override
	public String toString() {
		String set = "ArmorSlot: " + this.armorSlot.getEquipment() + " LeftHandSlot: "+ this.leftHandWeaponSlot.getEquipment() + " RightHandSlot: "
	+  this.rightHandWeaponSlot.getEquipment() + " TwoHandedSlot: " + this.twoHandWeaponSlot.getEquipment();
		return set;
	}

}
