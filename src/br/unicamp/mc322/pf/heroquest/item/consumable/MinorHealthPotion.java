package br.unicamp.mc322.pf.heroquest.item.consumable;



public class MinorHealthPotion extends HealthPotion {

	private final static int HEALINGAMOUNT = 1;
	private final static String NAME = "Minor Health Potion";
	
	public MinorHealthPotion() {
		super(NAME, HEALINGAMOUNT);
	}


}
