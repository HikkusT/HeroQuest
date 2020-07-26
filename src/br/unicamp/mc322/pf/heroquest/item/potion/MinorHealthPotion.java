package br.unicamp.mc322.pf.heroquest.item.potion;



public class MinorHealthPotion extends HealthPotion {
	private final static String NAME = "Minor Health Potion";
	private final static int HEALINGAMOUNT = 1;
	
	
	public MinorHealthPotion() {
		super(HEALINGAMOUNT);
	}
	
	public String toString() {
		return NAME;
	}

}
