package br.unicamp.mc322.pf.heroquest.item.potion;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class HealthPotion extends Potion{

	private int healingAmount;
	
	public HealthPotion(int healingAmount) {	
		this.healingAmount = healingAmount;	
	}
	
	@Override
	public void consume(Entity user) {
		user.cure(this.healingAmount);
	}
}
