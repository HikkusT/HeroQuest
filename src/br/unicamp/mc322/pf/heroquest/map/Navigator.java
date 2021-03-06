package br.unicamp.mc322.pf.heroquest.map;


import br.unicamp.mc322.pf.heroquest.HeroQuest;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.InteractionType;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Navigator {
	private Map map;
	private Hero hero;

	public Navigator(Map map) {
		this.map = map;
	}

	public void attributeHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Entity getEntity(Vector2 position) {
		return map.getTile(position).getEntity();
	}
	
	public boolean isVisible(Vector2 position) {
		return map.isVisible(position);
	}
	
	public boolean isPassable(Vector2 position) {
		return map.isEmpty(position);
	}

	public void move(Entity entity, Vector2 destination) {
		// Maybe it should check and return a boolean instead of just throwing
		Vector2 origin = entity.getPosition();
		map.placeEntity(entity, destination);
		map.removeEntity(origin);
		HeroQuest.getInstance().getRenderer().update();
	}

	public boolean isInFieldOfView(Vector2 position) {
		return map.getTile(position).isIlluminated();
	}

	public boolean isBlocked(Entity entity) {
		// TODO: Implement. It may be used by the AI to check if it can move

		return false;
	}

	public boolean hasPath(Entity entity) {
		Vector2 from = entity.getPosition();
		Node node = map.calculatePath(from, hero.getPosition());
		if(node == null)
			return false;
		return true;
	}
	
	public void findSmallerPath(Entity entity, int movementPoints) {
		Vector2 from = entity.getPosition();
		Node node = map.calculatePath(from, hero.getPosition());
		Stack<Node> stack = new Stack<Node>();

		while(!node.getPosition().equals(from)) {
			stack.push(node);
			node = node.getFather();
		}

		for(int i = 0; i < movementPoints; i++) {
			if(stack.empty())
				break;
			node = stack.pop();
			entity.move(node.getPosition());
			if(entity.getVisibility()) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) { }
			}
		}
	}

	public void broadcastInteraction(Hero source, InteractionType type) {
		HeroQuest.getInstance().getRenderer().update();
		for (Tile tile : map.getIlluminatedTiles()) {
			tile.interact(type, source);
		}
		HeroQuest.getInstance().getRenderer().update();
	}
	
	public void sendInteractionToNeighbors(Hero source, InteractionType type) {
		Vector2 origin = source.getPosition();
		for (Tile tile : map.getTilesOnRange(origin, 1)) {
			tile.interact(type, source);
		}
		HeroQuest.getInstance().getRenderer().update();
	}
	
	public Set<Entity> getEntitiesOnRange(Vector2 origin, int range) {
		HashSet<Entity> entities = new HashSet<Entity>();
		for (Tile tile : map.getTilesOnRange(origin, range)) {
			if (tile.hasEntity()) {
				Entity currentEntity = tile.getEntity();
				if (this.isInFieldOfView(currentEntity.getPosition())) {
					entities.add(currentEntity);
				}
				
			}
		}
		
		return entities;
	}
	
	public void despawnEntity(Entity entity) {
		map.despawnEntity(entity);
	}
}
