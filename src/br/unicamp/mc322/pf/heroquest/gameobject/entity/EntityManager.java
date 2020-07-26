package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import java.util.Deque;
import java.util.LinkedList;

import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class EntityManager {
	Deque<Entity> activeEntities;
	
	public EntityManager() {
		activeEntities = new LinkedList<Entity>();
	}
	
	public void initFromMap(Tile[][] map, Vector2 dimension) {
		activeEntities.clear();
		
		for (int i = 0; i < dimension.getX(); i ++) {
			for (int j = 0; j < dimension.getY(); j ++) {
				if (map[i][j].hasEntity()) {
					activeEntities.add(map[i][j].getEntity());
				}
			}
		}
	}
	
	public void nextTurn() {
		if (activeEntities.isEmpty()) {
			// TODO: Either improve this exception or just return
			throw new IllegalStateException("");
		}
		
		Entity nextEntity = activeEntities.pollFirst();
	
		nextEntity.setupTurn();
		nextEntity.performTurn();
		activeEntities.addLast(nextEntity);
	}
}
