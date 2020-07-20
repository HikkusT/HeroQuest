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
	
	public Vector2 getDimension() {
		return dimension;
	}
	
	public Tile[][] prepareToRender() {
		Tile[][] rotatedMap = new Tile[dimension.getY()][dimension.getX()];
		for (int i = 0; i < dimension.getY(); i ++)
			for (int j = 0; j < dimension.getX(); j ++)
				rotatedMap[i][j] = map[j][dimension.getY() - 1 - i];
		return rotatedMap;
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
