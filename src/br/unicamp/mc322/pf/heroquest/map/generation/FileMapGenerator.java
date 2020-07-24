package br.unicamp.mc322.pf.heroquest.map.generation;

import java.io.IOException;
import java.util.List;

import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.map.TileType;
import br.unicamp.mc322.pf.heroquest.utils.FileUtils;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;


public class FileMapGenerator implements MapGenerator {
	private Tile[][] map;
	private Vector2 dimension;
	
	public Tile[][] generate(Navigator navigator) {
		try {
			List<String> mapFile = FileUtils.readFile("map_files/example.txt");
			
			// Read dimensions of map and create it
			int width = Integer.parseInt(mapFile.get(0));
			int height = Integer.parseInt(mapFile.get(1));
			dimension = new Vector2(width, height);
			map = new Tile[width][height];
			
			// Read each line of map in file and process it
			for (int index = height + 1; index > 1; index --) {
				processLine(mapFile.get(index), height + 1 - index);
			}
		} catch (NumberFormatException e) {
			System.out.println("The file has unexpected characters");
			runFallbackGeneration(navigator);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The file dimension isnt as specified");
			runFallbackGeneration(navigator);
		} catch (IOException e) {
			System.out.println("Problems reading file");
			runFallbackGeneration(navigator);
		}
		
		return map;
	}
	
	public Vector2 retrieveDimension() {
		return dimension;
	}

	// Read all elements in given line and include them in map
	private void processLine(String line, int indexLine) {
		for(int indexColumn = 0; indexColumn < line.length(); indexColumn++) {
			char element = line.charAt(indexColumn);
			includeElement(element, indexLine, indexColumn);
		}
	}

	// Analyze what type of element must be created from symbol and include it in position
	private void includeElement(char symbol, int indexLine, int indexColumn) {
		switch(symbol) {
			case '#':
				map[indexColumn][indexLine] = new Tile(TileType.WALL);
				break;
			default:
				map[indexColumn][indexLine] = new Tile();
				break;
		}
	}
	
	private void runFallbackGeneration(Navigator navigator) {
		MapGenerator fallback = new MockMapGenerator();
		map = fallback.generate(navigator);
		dimension = fallback.retrieveDimension();
	}
}
