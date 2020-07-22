package br.unicamp.mc322.pf.heroquest.mapobjects;

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
