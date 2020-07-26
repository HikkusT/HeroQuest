package br.unicamp.mc322.pf.heroquest.item.consumable;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Item;

public abstract class HealthPotion extends Item implements Consumable{

	private int HealingAmount;
	
	public HealthPotion(String itemName, int healingAmount) {
		super(itemName);
		this.HealingAmount = healingAmount;	
	}
	
	@Override
	public void consume(Entity user) {
		user.cure(this.HealingAmount);
	}
}
