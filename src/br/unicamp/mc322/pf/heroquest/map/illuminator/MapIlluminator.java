package br.unicamp.mc322.pf.heroquest.map.illuminator;

import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class MapIlluminator {

	public abstract void illuminateMap(Tile[][] map, Vector2 dimension, Vector2 hero);

	void resetMapillumination(Tile[][] map, Vector2 dimension) {
		int widht = dimension.getX();
		int height = dimension.getY();
		
		for (int i = 0; i < widht; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j].blackOut();;
			}
		}
	}
}
