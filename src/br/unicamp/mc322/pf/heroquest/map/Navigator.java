package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Navigator {
	private Map map;

	public Navigator(Map map) {
		this.map = map;
	}

	public void move(Entity entity, Vector2 destination) {
		// Maybe it should check and return a boolean instead of just throwing
		Vector2 origin = entity.getPosition();
		map.placeEntity(entity, destination);
		map.removeEntity(origin);
	}

	public boolean getVisibility(Entity entity) {
		return map.getVisibility(entity.getPosition());
	}

	public boolean isBlocked(Entity entity) {
		// TODO: Implement. It may be used by the AI to check if it can move

		return false;
	}

	// TODO: Implement PathFinding. A* is cool, but go for BFS if time is short
}
