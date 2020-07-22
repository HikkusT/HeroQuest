package br.unicamp.mc322.pf.heroquest.map.illuminator;

import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class MapIlluminator {

	public abstract void illuminateMap(Map map, Vector2 hero);

	void resetMapillumination(Map map) {
		int widht = map.getDimension().getX();
		int height = map.getDimension().getY();
		
		for (int i = 0; i < widht; i++) {
			for (int j = 0; j < height; j++) {
				map.setVisibility(new Vector2(i, j), false);
			}
		}
	}
}
