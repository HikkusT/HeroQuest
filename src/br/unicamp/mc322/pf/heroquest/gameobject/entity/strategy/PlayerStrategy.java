package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import java.util.ArrayList;
import java.util.Set;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.InteractionType;
import br.unicamp.mc322.pf.heroquest.input.Command;
import br.unicamp.mc322.pf.heroquest.input.Input;
import br.unicamp.mc322.pf.heroquest.render.Renderer;
import br.unicamp.mc322.pf.heroquest.utils.Direction;

public class PlayerStrategy implements TurnStrategy {
	Renderer renderer;
	Hero player;
	Input input;
	
	public PlayerStrategy(Hero player) {
		this.player = player;
		this.input = HeroQuest.getInstance().getInput();
		this.renderer = HeroQuest.getInstance().getRenderer();
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
			case OPEN_DOOR:
				player.getNavigator().sendInteractionToNeighbors(player, InteractionType.INTERACT_DOOR);
				break;
			case SEARCH_TREASURES:
				renderer.renderEvent("Searching for treasures...");
				player.getNavigator().broadcastInteraction(player, InteractionType.FIND_TREASURE);
				break;
			case SEARCH_TRAPS:
				renderer.renderEvent("Searching for traps...");
				player.getNavigator().broadcastInteraction(player, InteractionType.FIND_TRAP);
				break;
			case DISARM_TRAP:
				renderer.renderEvent("Disarming traps...");
				player.getNavigator().broadcastInteraction(player, InteractionType.DISARM_TRAP);
				break;
			case ATTACK:
				renderer.renderEvent("Attacking");
				int range = player.getBiggerWeaponRange();
				ArrayList<Entity> entities = new ArrayList<Entity> (player.getNavigator().getEntitiesOnRange(player, range));
				player.attack(entities.get(0));
				break;
			default:
				break;
			}
		}
	}
}
