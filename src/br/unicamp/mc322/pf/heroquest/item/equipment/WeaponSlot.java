package br.unicamp.mc322.pf.heroquest.item.equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.OneHandedWeapon;

public class WeaponSlot extends EquipmentSlot {

	public WeaponSlot() {
		super();
	}
	
	@Override
	public boolean isEmpty() {
		if (this.equipment == null || (this.equipment.getItemName() == "Fists")) {
			return true;
		}
		else {
			return false;
		}	
	}

	@Override
	public OneHandedWeapon getEquipment() {
		return (OneHandedWeapon) equipment;
	}

}
