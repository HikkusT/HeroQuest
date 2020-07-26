package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

public class Excalibur extends TwoHandedWeapon {
	private final static String NAME = "Excalibur";
	private final static int ATTACKPOINTS = 4;
	private final static int RANGE = 1;

	public Excalibur() {
		super(ATTACKPOINTS, RANGE);

	}
	
	@Override
	public String toString() {
		return NAME;
	}

}
