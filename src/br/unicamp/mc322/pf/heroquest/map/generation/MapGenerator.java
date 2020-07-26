package br.unicamp.mc322.pf.heroquest.map.generation;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.HeroType;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public interface MapGenerator {
	public Tile[][] generate(Navigator navigator);
	
	public Vector2 retrieveDimension();
}
