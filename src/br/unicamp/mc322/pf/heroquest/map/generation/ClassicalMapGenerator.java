package br.unicamp.mc322.pf.heroquest.map.generation;

import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.map.TileType;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class ClassicalMapGenerator implements MapGenerator {
	private final int MAP_WIDTH = 36;
	private final int MAP_HEIGHT = 27;
	private Tile[][] map;
	
	public Tile[][] generate() {
		instantiateMap();
		placeRectangle(new Vector2(14, 10), new Vector2(21, 16));	// Place central room
		placeCross(new Vector2(2, 2), new Vector2(12 ,12),
				   new Vector2(2, 2), new Vector2(16, 8));
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
					if (i == bl.getX() || i == tr.getX() ||
						j == bl.getY() || j == tr.getY())
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
	}
}
