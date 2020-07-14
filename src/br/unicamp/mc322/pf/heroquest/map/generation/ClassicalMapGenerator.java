package br.unicamp.mc322.pf.heroquest.map.generation;

import java.util.Random;

import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.map.TileType;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class ClassicalMapGenerator implements MapGenerator {
	private final int MAP_WIDTH = 36;
	private final int MAP_HEIGHT = 27;
	private Tile[][] map;
	Random random;
	
	public ClassicalMapGenerator() {
		random = new Random();
	}
	
	public Tile[][] generate() {
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
