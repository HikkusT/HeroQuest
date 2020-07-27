package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import java.util.Random;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.monster.Monster;

public class SmartStrategy implements TurnStrategy {
	private Monster monster;

	public SmartStrategy(Monster monster) {
		this.monster = monster;
		new Random();
	}

	public void execute() {
		if(monster.isHeroInRange()) {
			monster.attackHero();
		}
		else {
			monster.moveToHero();
			if(monster.isHeroInRange()) {
				monster.attackHero();
			}
		}
	}
}
