package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

public class Fists extends TwoHandedWeapon {

	private final static String NAME = "Fists";
	private final static int ATTACKPOINTS = 0;
	private final static int RANGE = 1;
	
	public Fists() {
		super(ATTACKPOINTS, RANGE);
	}
	
	
	@Override
	public String toString() {
		return NAME;
	}

}
