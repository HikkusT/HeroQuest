package br.unicamp.mc322.pf.heroquest.map.generation;

import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.map.TileType;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class MockMapGenerator implements MapGenerator {
	private Vector2 dimension;
	
	public MockMapGenerator() {
		dimension = new Vector2(20, 20);
	}
	
	public Tile[][] generate(Navigator navigator) {
		Tile[][] map = new Tile[dimension.getX()][dimension.getY()];
		Vector2 center = new Vector2(dimension.getX() / 2, dimension.getY() / 2);
		
		for (int i = 0; i < dimension.getX(); i ++) {
			for (int j = 0; j < dimension.getY(); j ++) {
				if (Math.abs(i - center.getX()) == 3 ||  Math.abs(j - center.getY()) == 3)
					map[i][j] = new Tile(TileType.WALL);
				// else if (i == 0 || j == 0 || i == dimension.getX() - 1 || j == dimension.getY() - 1)
				//  	map[i][j] = new Tile(TileType.WALL);
				else
					map[i][j] = new Tile();
			}
		}
		
		return map;
	}

	public Vector2 retrieveDimension() {
		return dimension;
	}
}
