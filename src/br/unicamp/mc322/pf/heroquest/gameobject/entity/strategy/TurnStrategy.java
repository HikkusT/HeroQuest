package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public abstract class TurnStrategy {
	protected Entity actor;
	
	public TurnStrategy(Entity actor) {
		this.actor = actor;
	}
	
	public abstract void execute();
}
