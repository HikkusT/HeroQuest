package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public class IdleStrategy implements TurnStrategy {
	public void execute() {
		System.out.println("Esse carinha nao esta fazendo absolutamente nada");
	}
}
