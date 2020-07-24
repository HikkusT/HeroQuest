package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public class IdleStrategy extends TurnStrategy {
	
	public IdleStrategy(Entity actor) {
		super(actor);
	}
	
	public void execute() {
		System.out.println("Esse carinha nao esta fazendo absolutamente nada");
	}
}
