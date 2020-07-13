package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.map.generation.MapGenerator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Map {
	private Tile[][] map;
	private Vector2 dimension;
	
	public Map(MapGenerator generator) {
		map = generator.generate();
		dimension = generator.retrieveDimension();
	}
	
	@Override
	public String toString() {
		String mapRepresentation = "";
		for (int j = dimension.getY() - 1; j >= 0; j --) {
			for (int i = 0; i < dimension.getX(); i ++) {				
				mapRepresentation += map[i][j];
			}
			mapRepresentation += "\n";
		}
		
		return mapRepresentation;
	}
}
