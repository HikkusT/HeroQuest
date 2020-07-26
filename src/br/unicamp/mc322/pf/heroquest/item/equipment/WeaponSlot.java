package br.unicamp.mc322.pf.heroquest.item.equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Fists;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Weapon;

public class WeaponSlot extends EquipmentSlot {

	public WeaponSlot() {
		this.equipment = new Fists();
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
	public Equipment removeEquipment() {
		Equipment removedEquipment = equipment;
		equipment = new Fists();
		
		return removedEquipment;
	}
	
	@Override
	public Weapon getEquipment() {
		return (Weapon) equipment;
	}

}
