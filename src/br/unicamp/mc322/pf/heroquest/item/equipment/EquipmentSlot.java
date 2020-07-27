package br.unicamp.mc322.pf.heroquest.item.equipment;


public abstract class EquipmentSlot {
	protected Equipment equipment;

	EquipmentSlot(){
		equipment = null;
	}
	public boolean isEmpty() {
		if (this.equipment == null || (this.equipment.toString() == "Fists")) {
			
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
