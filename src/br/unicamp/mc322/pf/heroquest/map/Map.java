package br.unicamp.mc322.pf.heroquest.map;


import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.map.generation.MapGenerator;
import br.unicamp.mc322.pf.heroquest.map.illuminator.MapIlluminator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Map {
	MapIlluminator illuminator;
	private Tile[][] map;
	private Vector2 dimension;
	
	public Map(MapGenerator generator, MapIlluminator illuminator) {
		this.illuminator = illuminator;
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
	
	public void CalculateIllumation() {
		illuminator.illuminateMap(this, new Vector2(22,9));
	}

	public boolean getTranslucency(Vector2 point) {
		return map[point.getX()][point.getY()].isTranslucent();
	}
	public TileType getTileType(Vector2 point) {
		return map[point.getX()][point.getY()].getTileType();
	}
	
	public boolean getVisibility(Vector2 point) {
		return map[point.getX()][point.getY()].getVisibility();
	}
	
	public void setVisibility(Vector2 point, boolean isVisible) {
		this.map[point.getX()][point.getY()].setVisibility(isVisible);
	}
	
	public void placeEntity(Entity entity, Vector2 position) {
		int x = position.getX();
		int y = position.getY();
		if (map[x][y].isTransposable()) {
			map[x][y].setEntity(entity);
		}
		else {
			// We need to implement some error classes.
			throw new IllegalArgumentException("A entidade não pode ir na direção indicada\n");
		}
	}
	
	public void removeEntity(Vector2 position) {
		int x = position.getX();
		int y = position.getY();
		map[x][y].removeEntity();
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
