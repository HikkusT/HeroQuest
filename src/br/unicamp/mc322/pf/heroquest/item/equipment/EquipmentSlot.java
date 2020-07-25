package br.unicamp.mc322.pf.heroquest.item.equipment;

public abstract class EquipmentSlot {
	protected Equipment equipment;

	protected EquipmentSlot() {
		
	}
	
	public boolean isEmpty() {
		if (equipment == null || equipment.getItemName() == "Fists") {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public void setEquipment(Equipment equipment) {
		if (this.isEmpty()) {
			this.equipment = equipment;
		}
	}
	
	public Equipment removeEquipment() {
		Equipment removedEquipment = equipment;
		equipment = null;
		
		return removedEquipment;
	}
	
	public abstract Equipment getEquipment();
}
