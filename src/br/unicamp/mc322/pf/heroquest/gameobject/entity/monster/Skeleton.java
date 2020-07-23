package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Skeleton extends Monster {

	public Skeleton(Vector2 position, Map map) {
		super("Skeleton", position, 1, 0, 2, 2, 10, map); 
		
	}

}
