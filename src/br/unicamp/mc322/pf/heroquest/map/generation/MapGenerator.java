package br.unicamp.mc322.pf.heroquest.map.generation;

import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public interface MapGenerator {
	public Tile[][] generate();
	
	public Vector2 retrieveDimension();
}
