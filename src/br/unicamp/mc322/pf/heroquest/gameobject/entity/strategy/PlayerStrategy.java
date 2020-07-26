package br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy;

import java.util.ArrayList;
import java.util.Set;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
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
		renderer.renderEvent("Your Turn!");
		int movementPoints = DiceManager.move();
		renderer.renderEvent("You got " + movementPoints + " movement points in dices.");

		Command command = input.waitForNextCommand();		
		if(command.isMovementCommand()) {
			moveRound(command, movementPoints);
			actionRound(command);
		}
		else {
			actionRound(command);
			moveRound(command, movementPoints);
		}
	}
		
	private void moveRound(Command command, int movementPoints) {
		renderer.renderEvent("Your movement turn has started");
		for(int i = 0; i < movementPoints; i++) {
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
			default:
				break;
			}
			
			if((i + 1) == movementPoints)
				break;
			command = input.waitForNextCommand();
			if(command.isActionCommand() || command.isCombatCommand() || command == Command.END_TURN) 
				break;
		}
		renderer.renderEvent("Your movement turn has finished");
	}
	
	private void actionRound(Command command) {
		renderer.renderEvent("Your action turn has started");
		boolean finished = false;
		
		while(!finished) {
			switch (command) {
			case SEARCH_TREASURES:
				renderer.renderEvent("Searching for treasures...");
				player.getNavigator().broadcastInteraction(player, InteractionType.FIND_TREASURE);
				finished = true;
				break;
			case SEARCH_TRAPS:
				renderer.renderEvent("Searching for traps...");
				player.getNavigator().broadcastInteraction(player, InteractionType.FIND_TRAP);
				finished = true;
				break;
			case DISARM_TRAP:
				renderer.renderEvent("Disarming traps...");
				player.getNavigator().broadcastInteraction(player, InteractionType.DISARM_TRAP);
				finished = true;
				break;
			case ATTACK:
				renderer.renderEvent("Attacking");
				int range = player.getBiggerWeaponRange();
				ArrayList<Entity> entities = new ArrayList<Entity> (player.getNavigator().getEntitiesOnRange(player.getPosition(), range));
				player.attack(entities.get(0));
				finished = true;
				break;
			case END_TURN:
				finished = true;
				break;
			default:
				break;
			}
			
			if(finished)
				break;
			command = input.waitForNextCommand();
		}
		renderer.renderEvent("Your action turn has ended");
	}
}
