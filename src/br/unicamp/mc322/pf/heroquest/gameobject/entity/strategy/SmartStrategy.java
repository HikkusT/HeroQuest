package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import java.util.Random;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.monster.Monster;
import br.unicamp.mc322.pf.heroquest.utils.Direction;

public class SmartStrategy implements TurnStrategy {
	private Random random;
	private Monster monster;

	public SmartStrategy(Monster monster) {
		this.monster = monster;
		random = new Random();
	}

	public void execute() {
		monster.moveToHero();
	}
}
