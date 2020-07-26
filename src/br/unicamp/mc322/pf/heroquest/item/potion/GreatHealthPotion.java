package br.unicamp.mc322.pf.heroquest.item.potion;



public class GreatHealthPotion extends HealthPotion {
	
	private final static String NAME = "Great Health Potion";
	private final static int HEALINGAMOUNT = 2;
	
	public GreatHealthPotion() {
		super(HEALINGAMOUNT);
	}

	@Override
	public String toString() {
		return NAME;
	}

}
