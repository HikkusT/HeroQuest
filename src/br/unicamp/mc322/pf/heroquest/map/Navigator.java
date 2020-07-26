package br.unicamp.mc322.pf.heroquest.map;


import br.unicamp.mc322.pf.heroquest.HeroQuest;
import java.util.Stack;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.InteractionType;
import br.unicamp.mc322.pf.heroquest.utils.Direction;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Navigator {
	private Map map;
	Hero hero;

	public Navigator(Map map) {
		this.map = map;
		hero = new Barbarian(new Vector2(0,0), this);
	}

	public Hero getHero() {
		return hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public boolean isPassable(Vector2 position) {
		return map.isEmpty(position);
	}

	public void move(Entity entity, Vector2 destination) {
		// Maybe it should check and return a boolean instead of just throwing
		Vector2 origin = entity.getPosition();
		map.placeEntity(entity, destination);
		map.removeEntity(origin);
		HeroQuest.getInstance().getRenderer().renderWorld();
	}

	public boolean getVisibility(Entity entity) {
		return map.getVisibility(entity.getPosition());
	}

	public boolean isBlocked(Entity entity) {
		// TODO: Implement. It may be used by the AI to check if it can move

		return false;
	}

	public void findSmallerPath(Entity entity, int movementPoints) {
		Vector2 from = entity.getPosition();
		Node node = map.calculatePath(from, hero.getPosition());
		Stack<Node> stack = new Stack<Node>();
		while(node.getPosition() != from) {
			stack.push(node);
			node = node.getFather();
		}
		for(int i = 0; i < movementPoints; i++) {
			node = stack.pop();
			if(node.getPosition() == hero.getPosition())
				break;
			move(entity, node.getPosition());
		}
	}

	public void broadcastInteraction(Hero source, InteractionType type) {
		HeroQuest.getInstance().getRenderer().renderWorld();
	}
	
	public void sendInteractionToNeighbors(Hero source, InteractionType type) {
		Vector2 origin = source.getPosition();
		map.getTile(origin.translated(Direction.NORTH)).interact(type, source);
		map.getTile(origin.translated(Direction.EAST)).interact(type, source);
		map.getTile(origin.translated(Direction.SOUTH)).interact(type, source);
		map.getTile(origin.translated(Direction.WEST)).interact(type, source);
		HeroQuest.getInstance().getRenderer().renderWorld();
	}
}
