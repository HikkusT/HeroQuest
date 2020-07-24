package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.EntityManager;
import br.unicamp.mc322.pf.heroquest.map.generation.MapGenerator;
import br.unicamp.mc322.pf.heroquest.map.illuminator.MapIlluminator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Map {
	private MapIlluminator illuminator;
	private EntityManager entityManager;
	private Tile[][] map;
	private Vector2 dimension;
	
	public Map(MapGenerator generator, MapIlluminator illuminator, EntityManager entityManager) {
		this.illuminator = illuminator;
		this.entityManager = entityManager;
		map = generator.generate();
		dimension = generator.retrieveDimension();
		entityManager.initFromMap(map, dimension);
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
		return this.map[point.getX()][point.getY()].isTranslucent();
	}
	public TileType getTileType(Vector2 point) {
		return this.map[point.getX()][point.getY()].getTileType();
	}
	
	public boolean getVisibility(Vector2 point) {
		return this.map[point.getX()][point.getY()].getVisibility();
	}
	
	public void setVisibility(Vector2 point, boolean isVisible) {
		this.map[point.getX()][point.getY()].setVisibility(isVisible);
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
