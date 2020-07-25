package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.input.Command;
import br.unicamp.mc322.pf.heroquest.input.Input;
import br.unicamp.mc322.pf.heroquest.utils.Direction;

public class PlayerStrategy implements TurnStrategy {
	Hero player;
	Input input;
	
	public PlayerStrategy(Hero player) {
		this.player = player;
		this.input = HeroQuest.getInstance().getInput();
	}

	@Override
	public void execute() {
		while (true) {
			Command command = input.waitForNextCommand();
			switch (command) {
			case MOVE_UP:
				player.move(Direction.NORTH);
				break;
			case MOVE_RIGHT:
				player.move(Direction.EAST);
				break;
			case MOVE_DOWN:
				player.move(Direction.SOUTH);
				break;
			case MOVE_LEFT:
				player.move(Direction.WEST);
				break;
			default:
				break;
			}
		}
	}
}
