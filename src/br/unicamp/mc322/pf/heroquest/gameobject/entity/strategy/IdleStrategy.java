package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.monster.Monster;
import br.unicamp.mc322.pf.heroquest.utils.Direction;
import java.util.Random;

public class IdleStrategy implements TurnStrategy {
	private Random random;
	private Monster monster;

	public IdleStrategy(Monster monster) {
		this.monster = monster;
		random = new Random();
	}

	public void execute() {
		while(monster.getMovementPoints() > 0) {
			if(monster.isHeroInRange())
				monster.attackHero();
			moveMonster();
		}
	}

	public void moveMonster() {
		int direction = random.nextInt(4);
		switch(direction) {
			case 0:
				monster.move(Direction.NORTH);
			case 1:
				monster.move(Direction.SOUTH);
			case 2:
				monster.move(Direction.EAST);
			case 3:
				monster.move(Direction.WEST);
			default:
				break;
		}
		monster.decrementMovementPoints();
	}
}
