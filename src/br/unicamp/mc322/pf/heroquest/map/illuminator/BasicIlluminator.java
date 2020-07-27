package br.unicamp.mc322.pf.heroquest.map.illuminator;


import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;


import java.util.ArrayList;

public class BasicIlluminator extends MapIlluminator {

	public BasicIlluminator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void illuminateMap(Tile[][] map, Vector2 dimension, Vector2 hero) {
		this.resetMapillumination(map, dimension);
		ArrayList<Vector2> edgePoints = new ArrayList<Vector2>(); 
		int widht = dimension.getX();
		int height = dimension.getY();
		
		for (int i = 0; i < widht; i ++) {
			edgePoints.add(new Vector2(i, 0));
			edgePoints.add(new Vector2(i, height));
		}
		
		for (int i = 0; i < height; i ++) {
			edgePoints.add(new Vector2(0, i));
			edgePoints.add(new Vector2(widht, i));
		}
		
		for(Vector2 point : edgePoints) {
			ArrayList<Vector2> lineOfSight = getLineOfSight(hero, point);
			
			for(Vector2 pointInSight : lineOfSight) {
				map[pointInSight.getX()][pointInSight.getY()].illuminate();
				if (!map[pointInSight.getX()][pointInSight.getY()].isTranslucent()){
					break;
				}		
			}
		}
		//Post Processing illumination of walls adjacent to illuminated floor.
		for (int i = 0; i < widht; i++) {
			for (int j = 0; j < height; j++) {
				int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
				if (map[i][j].isIlluminated() && map[i][j].isTranslucent()) {
					for(int[] direction : directions) {
						int x = direction[0];
						int y = direction[1];
						
						if (!map[i + x][j + y].isTranslucent()) {
							map[i + x][j + y].illuminate();
						}
					}
				}
			}
		}
	}
	
	static ArrayList<Vector2> getLineOfSight(Vector2 v1, Vector2 v2) { 
		int x, y;
		int x1 = v1.getX();
		int y1 = v1.getY();
		int x2 = v2.getX();
		int y2 = v2.getY();
		ArrayList<Vector2> lineOfSight = new ArrayList<Vector2>();
    	int deltaX = x2 - x1;
    	int deltaY = y2 - y1;
    	
    	if (deltaX == 0 && deltaY >= 0) {
    		
			for (x = x1, y = y1; y <= y2; y ++) {
				lineOfSight.add(new Vector2(x, y));
				
				return lineOfSight;
			
			}
    	}
    	else if (deltaX == 0 && deltaY <= 0) {
    		
			for (x = x1, y = y1; y >= y2; y --) {
				lineOfSight.add(new Vector2(x, y));
				return lineOfSight;
			
			}
    	}
    	
		float p = deltaY / (float)deltaX;
		float q = y1 - p * x1;
		
		
	
		
		if (Math.abs(p) <= 1 && deltaX > 0) {
			
			for (x = x1, y = y1; x <= x2; x ++) {
				y = Math.round((p * x) + q);
				lineOfSight.add(new Vector2(x, y));
				
			}
		}
		
		else if (Math.abs(p) <= 1 && deltaX < 0) {
		
			for (x = x1, y = y1; x >= x2; x --) {
				y = Math.round((p * x) + q);
				lineOfSight.add(new Vector2(x, y));
				
			}
		}
		
		else if ((Math.abs(p) > 1 && deltaY > 0)) {
			
			for (x = x1, y = y1; y <= y2; y ++) {
				x = Math.round((y - q) / p);
				lineOfSight.add(new Vector2(x, y));
				
			}
		}
		
		else if ((Math.abs(p) > 1 && deltaY < 0)){
			
			for (x = x1, y = y1; y >= y2; y --) {
				x = Math.round((y - q) / p);
				lineOfSight.add(new Vector2(x, y));
			
			}
		}
		
		return lineOfSight;

		

    }

}
