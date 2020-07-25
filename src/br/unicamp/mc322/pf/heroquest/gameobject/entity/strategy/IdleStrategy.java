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
		boolean moved = false;
		int direction;
		while(!moved) {
			direction = random.nextInt(4);
			switch(direction) {
				case 0:
					if(monster.canMove(Direction.NORTH)) {
						monster.move(Direction.NORTH);
						moved = true;
					}
				case 1:
					if(monster.canMove(Direction.SOUTH)) {
						monster.move(Direction.SOUTH);
						moved = true;
					}
				case 2:
					if(monster.canMove(Direction.EAST)) {
						monster.move(Direction.EAST);
						moved = true;
					}
				case 3:
					if(monster.canMove(Direction.WEST)) {
						monster.move(Direction.WEST);
						moved = true;
					}
				default:
					break;
			}
		}
		monster.decrementMovementPoints();
	}
}
