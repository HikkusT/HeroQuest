package br.unicamp.mc322.pf.heroquest.map.generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.monster.Skeleton;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.Door;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.map.TileType;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class ClassicalMapGenerator implements MapGenerator {
	private final int MAP_WIDTH = 36;
	private final int MAP_HEIGHT = 27;
	private Tile[][] map;
	private java.util.Map<Integer, List<Vector2>> rooms;
	private Random random;
	private HeroType hero;
	
	public ClassicalMapGenerator(HeroType hero) {
		this.hero = hero;
		random = new Random();
		rooms = new HashMap<Integer, List<Vector2>>();
	}
	
	public Tile[][] generate(Navigator navigator) {
		instantiateMap();
		placeRectangle(new Vector2(14, 10), new Vector2(21, 16));	// Place central room
		placeCross(new Vector2(2, 2), new Vector2(12, 12),
				   new Vector2(2, 2), new Vector2(16, 8));			// Place bottom left corner
		placeCross(new Vector2(2, 14), new Vector2(12, 24),
				   new Vector2(2, 18), new Vector2(16, 24));		// Place top left corner
		placeCross(new Vector2(19, 18), new Vector2(33, 24),
				   new Vector2(23, 14), new Vector2(33, 24));		// Place top right corner
		placeCross(new Vector2(19, 2), new Vector2(33, 8),
				   new Vector2(23, 2), new Vector2(33, 12));		// Place bottom right corner
		
		spawnMonsters(navigator);
		spawnPlayer(navigator);
		connectMap();
		
		return map;
	}
	
	public Vector2 retrieveDimension() {
		return new Vector2(MAP_WIDTH, MAP_HEIGHT);
	}
	
	private void instantiateMap() {
		map = new Tile[MAP_WIDTH][MAP_HEIGHT];
		for (int i = 0; i < MAP_WIDTH; i ++) {
			for (int j = 0; j < MAP_HEIGHT; j ++) {
				if (i == 0 || i == MAP_WIDTH - 1 || j == 0 || j == MAP_HEIGHT - 1)
					map[i][j] = new Tile(TileType.WALL);
				else
					map[i][j] = new Tile();
			}
		}
	}
	
	private void placeRectangle(Vector2 bl, Vector2 tr) {
		for (int i = 0; i < MAP_WIDTH; i ++) {
			for (int j = 0; j < MAP_HEIGHT; j ++) {
				if (i >= bl.getX() && i <= tr.getX() && j >= bl.getY() && j <= tr.getY()) {
					if (isOnRectangleBorder(new Vector2(i, j), bl, tr))
						map[i][j] = new Tile(TileType.WALL);
					else
						map[i][j] = new Tile();
				}
			}
		}
	}
	
	// A cross is defined by two overlapping rectangles
	private void placeCross(Vector2 bl1, Vector2 tr1, Vector2 bl2, Vector2 tr2) {
		placeRectangle(bl1, tr1);
		placeRectangle(bl2, tr2);
		
		for (int i = 0; i < MAP_WIDTH; i ++) {
			for (int j = 0; j < MAP_HEIGHT; j ++) {
				if (i >= Math.max(bl1.getX(), bl2.getX()) &&
					i <= Math.min(tr1.getX(), tr2.getX()) &&
					j >= Math.max(bl1.getY(), bl2.getY()) &&
					j <= Math.min(tr1.getY(), tr2.getY())) {
					if (!(isOnRectangleBorder(new Vector2(i, j), bl1, tr1) &&
						isOnRectangleBorder(new Vector2(i, j), bl2, tr2))) {
						map[i][j] = new Tile();
					}
				}
			}
		}
		
		subdivideCross(bl1, tr1, bl2, tr2, 0);
	}
	
	private void subdivideCross(Vector2 bl1, Vector2 tr1, Vector2 bl2, Vector2 tr2, int direction) {
		int tries = 12;
		for (int currentTry = 0; currentTry < tries; currentTry ++)
		{
			if (direction == 0) {
				int minbl = Math.min(bl1.getX(), bl2.getX());
				int maxbl = Math.max(bl1.getX(), bl2.getX());
				int mintr = Math.min(tr1.getX(), tr2.getX());
				int maxtr = Math.max(tr1.getX(), tr2.getX());
				int slice = random.nextInt(maxtr - minbl + 1) + minbl;
				
				if (Math.abs(minbl - slice) <= 3 ||
					(Math.abs(maxbl - slice) <= 3 && slice != maxbl) ||
					(Math.abs(mintr - slice) <= 3 && slice != mintr) ||
					Math.abs(maxtr - slice) <= 3) {
					continue;
				}
				
				for (int i = 0; i < MAP_HEIGHT; i ++) {
					Vector2 point = new Vector2(slice, i);
					if (isInsideRectangle(point, bl1, tr1) || isInsideRectangle(point, bl2, tr2))
						map[slice][i] = new Tile(TileType.WALL);
				}
				
				int nextDirection = (direction + 1) % 2;
				if (slice <= maxbl) {
					subdivideCross(bl1, new Vector2(slice, tr1.getY()), bl1, new Vector2(slice, tr1.getY()), nextDirection);
					subdivideCross(new Vector2(slice, bl1.getY()), tr1, bl2, tr2, nextDirection);
				} else if (slice <= mintr) {
					subdivideCross(bl1, new Vector2(slice, tr1.getY()), bl2, new Vector2(slice, tr2.getY()), nextDirection);
					subdivideCross(new Vector2(slice, bl1.getY()), tr1, new Vector2(slice, bl2.getY()), tr2, nextDirection);
				} else {
					subdivideCross(bl1, new Vector2(slice, tr1.getY()), bl2, tr2, nextDirection);
					subdivideCross(new Vector2(slice, bl1.getY()), tr2, new Vector2(slice, bl1.getY()), tr2, nextDirection);
				}
			} else {
				int minbl = Math.min(bl1.getY(), bl2.getY());
				int maxbl = Math.max(bl1.getY(), bl2.getY());
				int mintr = Math.min(tr1.getY(), tr2.getY());
				int maxtr = Math.max(tr1.getY(), tr2.getY());
				int slice = random.nextInt(maxtr - minbl + 1) + minbl;
				
				if (Math.abs(minbl - slice) <= 3 ||
					(Math.abs(maxbl - slice) <= 3 && slice != maxbl) ||
					(Math.abs(mintr - slice) <= 3 && slice != mintr) ||
					Math.abs(maxtr - slice) <= 3) {
					continue;
				}
				
				for (int j = 0; j < MAP_WIDTH; j ++) {
					Vector2 point = new Vector2(j, slice);
					if (isInsideRectangle(point, bl1, tr1) || isInsideRectangle(point, bl2, tr2))
						map[j][slice] = new Tile(TileType.WALL);
				}
				
				int nextDirection = (direction + 1) % 2;
				if (slice <= maxbl) {
					subdivideCross(bl1, tr1, new Vector2(bl2.getX(), slice), tr2, nextDirection);
					subdivideCross(bl2, new Vector2(tr2.getX(), slice), bl2, new Vector2(tr2.getX(), slice), nextDirection);
				} else if (slice <= mintr) {
					subdivideCross(bl1, new Vector2(tr1.getX(), slice), bl2, new Vector2(tr2.getX(), slice), nextDirection);
					subdivideCross(new Vector2(bl1.getX(), slice), tr1, new Vector2(bl2.getX(), slice), tr2, nextDirection);
				} else {
					subdivideCross(bl1, tr1, bl2, new Vector2(tr2.getX(), slice), nextDirection);
					subdivideCross(new Vector2(bl2.getX(), slice), tr2, new Vector2(bl2.getX(), slice), tr2, nextDirection);
				}
			}
			break;
		}
	}
	
	private void spawnMonsters(Navigator navigator) {
		markRooms();
		// TODO: Actually make it random
		for (int roomIndex = 1; roomIndex < rooms.size(); roomIndex ++) {
			List<Vector2> room = rooms.get(roomIndex);
			Vector2 spawnPosition = room.get(random.nextInt(room.size()));
			map[spawnPosition.getX()][spawnPosition.getY()].receiveEntity(new Skeleton(spawnPosition, navigator));
		}
	}
	
	private void spawnPlayer(Navigator navigator) {
		map[17][1].receiveEntity(hero.createHero(new Vector2(17, 1), navigator));
	}
	
	private void connectMap() {
		do {
			markRooms();
			createDoor();
		} while(rooms.size() > 1);
	}
	
	private void markRooms() {
		rooms.clear();
		
		int numRooms = 0;
		for (int i = 1; i < MAP_WIDTH - 1; i ++) {
			for (int j = 1; j < MAP_HEIGHT - 1; j ++) {
				if (map[i][j].getTileType() == TileType.WALL) {
					continue;
				}
				
				boolean unvisited = true;
				Vector2 currentNode = new Vector2(i, j);
				for (int room = 0; room < numRooms; room ++) {
					if (rooms.get(room).contains(currentNode)) {
						unvisited = false;
						break;
					}
				}
				
				if (unvisited) {
					floodFill(numRooms++, currentNode);
				}
			}
		}
	}
	
	private void floodFill(int index, Vector2 startingNode) {
		rooms.put(index, new ArrayList<Vector2>());
		Queue<Vector2> toVisit = new LinkedList<Vector2>();
		toVisit.add(startingNode);
		while(!toVisit.isEmpty()) {
			Vector2 node = toVisit.remove();
			if (!rooms.get(index).contains(node)) {
				rooms.get(index).add(node);
				Vector2 north = Vector2.sum(node, new Vector2(0, 1));
				if (map[north.getX()][north.getY()].getTileType() != TileType.WALL)
					toVisit.add(north);
				Vector2 east = Vector2.sum(node, new Vector2(1, 0));
				if (map[east.getX()][east.getY()].getTileType() != TileType.WALL)
					toVisit.add(east);
				Vector2 south = Vector2.sum(node, new Vector2(0, -1));
				if (map[south.getX()][south.getY()].getTileType() != TileType.WALL)
					toVisit.add(south);
				Vector2 west = Vector2.sum(node, new Vector2(-1, 0));
				if (map[west.getX()][west.getY()].getTileType() != TileType.WALL)
					toVisit.add(west);
			}
		}
	}
	
	private void createDoor() {
		List<Vector2> possibleDoorPositions = new ArrayList<Vector2>();
		
		for (int i = 1; i < MAP_WIDTH - 1; i ++) {
			for (int j = 1; j < MAP_HEIGHT - 1; j ++) {
				Vector2 current = new Vector2(i, j);
				Vector2 north = Vector2.sum(current, new Vector2(0, 1));
				Vector2 east = Vector2.sum(current, new Vector2(1, 0));
				Vector2 south = Vector2.sum(current, new Vector2(0, -1));
				Vector2 west = Vector2.sum(current, new Vector2(-1, 0));
				
				if (map[current.getX()][current.getY()].getTileType() != TileType.WALL) {
					continue;
				}
				
				if (map[north.getX()][north.getY()].getTileType() == TileType.WALL &&
					map[south.getX()][south.getY()].getTileType() == TileType.WALL &&
					map[east.getX()][east.getY()].getTileType() != TileType.WALL &&
					map[west.getX()][west.getY()].getTileType() != TileType.WALL) {
					if (getRoomFromPosition(east) != getRoomFromPosition(west)) {
						possibleDoorPositions.add(current);
					}
				}
				
				if (map[north.getX()][north.getY()].getTileType() != TileType.WALL &&
					map[south.getX()][south.getY()].getTileType() != TileType.WALL &&
					map[east.getX()][east.getY()].getTileType() == TileType.WALL &&
					map[west.getX()][west.getY()].getTileType() == TileType.WALL) {
					if (getRoomFromPosition(north) != getRoomFromPosition(south)) {
						possibleDoorPositions.add(current);
					}
				}
			}
		}
		
		if (possibleDoorPositions.isEmpty()) {
			return;
		}
		
		Vector2 doorPosition = possibleDoorPositions.get(random.nextInt(possibleDoorPositions.size()));
		map[doorPosition.getX()][doorPosition.getY()] = new Tile(new Door(doorPosition));
	}
	
	private int getRoomFromPosition(Vector2 pos) {
		for (int room = 0; room < rooms.size(); room ++) {
			if (rooms.get(room).contains(pos)) {
				return room;
			}
		}
		
		return -1;
	}
	
	private boolean isInsideRectangle(Vector2 point, Vector2 bl, Vector2 tr) {
		return (point.getX() >= bl.getX() && point.getX() <= tr.getX() &&
				point.getY() >= bl.getY() && point.getY() <= tr.getY());
	}
	
	private boolean isOnRectangleBorder(Vector2 point, Vector2 bl, Vector2 tr) {
		if (isInsideRectangle(point, bl, tr)) {
			if (point.getX() == bl.getX() || point.getX() == tr.getX() ||
				point.getY() == bl.getY() || point.getY() == tr.getY()) {
				return true;
			}
		}
		
		return false;
	}
}
