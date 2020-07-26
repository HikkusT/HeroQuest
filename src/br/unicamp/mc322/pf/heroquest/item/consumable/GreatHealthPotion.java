package br.unicamp.mc322.pf.heroquest.item.consumable;



public class GreatHealthPotion extends HealthPotion {

	private final static int HEALINGAMOUNT = 2;
	private final static String NAME = "Great Health Potion";
	
	public GreatHealthPotion() {
		super(NAME, HEALINGAMOUNT);
	}

}
