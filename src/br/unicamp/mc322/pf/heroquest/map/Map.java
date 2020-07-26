package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.EntityManager;

import java.util.HashSet;
import java.util.Set;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.map.generation.MapGenerator;
import br.unicamp.mc322.pf.heroquest.map.illuminator.MapIlluminator;
import br.unicamp.mc322.pf.heroquest.utils.Direction;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Map {
	private Navigator navigator;
	private MapIlluminator illuminator;
	private EntityManager entityManager;
	private Tile[][] map;
	private Vector2 dimension;
	
	public Map() {} // IGNORE THIS. THIS IS ONLY FOR TESTING!!!!!
	
	public Map(MapGenerator generator, MapIlluminator illuminator, EntityManager entityManager) {
		this.navigator = new Navigator(this);
		this.illuminator = illuminator;
		this.entityManager = entityManager;
		map = generator.generate(navigator);
		dimension = generator.retrieveDimension();
		entityManager.initFromMap(map, dimension);
	}
	
	public Vector2 getDimension() {
		return dimension;
	}
	
	public Tile getTile(Vector2 point) {
		return map[point.getX()][point.getY()];
	}
	
	public Set<Tile> getTilesOnRange(Vector2 origin, int range) {
		if (range < 1)
			throw new IllegalArgumentException("Range should be at least 1");
		
		HashSet<Tile> tiles = new HashSet<Tile>();
		if (range == 1) {
			tiles.add(getTile(origin.translated(Direction.NORTH)));
			tiles.add(getTile(origin.translated(Direction.EAST)));
			tiles.add(getTile(origin.translated(Direction.SOUTH)));
			tiles.add(getTile(origin.translated(Direction.WEST)));
			return tiles;
		}
		
		tiles.addAll(getTilesOnRange(origin.translated(Direction.NORTH), range - 1));
		tiles.addAll(getTilesOnRange(origin.translated(Direction.EAST), range - 1));
		tiles.addAll(getTilesOnRange(origin.translated(Direction.SOUTH), range - 1));
		tiles.addAll(getTilesOnRange(origin.translated(Direction.WEST), range - 1));
		return tiles;
	}
	
	public Set<Tile> getIlluminatedTiles() {
		HashSet<Tile> tiles = new HashSet<Tile>();
		for (int i = 0; i < dimension.getX(); i ++)
			for (int j = 0; j < dimension.getY(); j ++)
				if (map[i][j].isIlluminated())
					tiles.add(map[i][j]);
		
		return tiles;
	}
	
	public boolean isEmpty(Vector2 point) {
		return map[point.getX()][point.getY()].isTransposable();
	}
	
	public void CalculateIllumation() {
		illuminator.illuminateMap(map, dimension, new Vector2(22,9));
	}
	
	public void placeEntity(Entity entity, Vector2 position) {
		int x = position.getX();
		int y = position.getY();
		if (map[x][y].isTransposable()) {
			map[x][y].setEntity(entity);
		}
		else {
			// We need to implement some error classes.
			throw new IllegalArgumentException("A entidade n�o pode ir na dire��o indicada\n");
		}
	}
	
	public void removeEntity(Vector2 position) {
		int x = position.getX();
		int y = position.getY();
		map[x][y].removeEntity();
	}
	
	public Node calculatePath(Vector2 from, Vector2 to) {
		Graph graph = new Graph(dimension.getX(), dimension.getY(), navigator);
		Node node = graph.calculatePath(from, to);
		return node;
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
