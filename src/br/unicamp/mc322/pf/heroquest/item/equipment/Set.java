package br.unicamp.mc322.pf.heroquest.item.equipment;

public class Set {

	private ArmorSlot armorSlot;
	private WeaponSlot leftHandWeaponSlot;
	private WeaponSlot rightHandWeaponSlot;
	
	public Set() {
		armorSlot = new ArmorSlot();
		leftHandWeaponSlot = new WeaponSlot();
		rightHandWeaponSlot = new WeaponSlot();
	}
	
	public ArmorSlot getArmorSlot() {
		return armorSlot;
	}
	
	public WeaponSlot getleftHandWeaponSlot() {
		return leftHandWeaponSlot;
	}
	
	public WeaponSlot getRightHandWeaponSlot() {
		return rightHandWeaponSlot;
	}

}
