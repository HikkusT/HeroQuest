package br.unicamp.mc322.pf.heroquest.item.equipment.weapon;

public class StormBreaker extends OneHandedWeapon {
	private final static String NAME = "Storm Breaker";
	private final static int ATTACKPOINTS = 2;
	private final static int RANGE = 1;

	public StormBreaker() {
		super(ATTACKPOINTS, RANGE);
	}

	
	@Override
	public String toString() {
		return NAME;
	}

}
