package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

public enum TrapType {
	HOLE;
	
	public int getDamage() {
		switch(this) {
		case HOLE:
			return 10;
		default:
			return 0;
		}
	}
}
