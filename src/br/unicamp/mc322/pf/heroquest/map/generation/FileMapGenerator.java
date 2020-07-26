package br.unicamp.mc322.pf.heroquest.map.generation;

import java.io.IOException;
import java.util.List;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.monster.*;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;
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
				processLine(mapFile.get(index), height + 1 - index, navigator);
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
	private void processLine(String line, int indexLine, Navigator navigator) {
		for(int indexColumn = 0; indexColumn < line.length(); indexColumn++) {
			char element = line.charAt(indexColumn);
			includeElement(element, indexLine, indexColumn, navigator);
		}
	}

	// Analyze what type of element must be created from symbol and include it in position
	private void includeElement(char symbol, int indexLine, int indexColumn, Navigator navigator) {
		switch(symbol) {
			case '#':
				map[indexColumn][indexLine] = new Tile(TileType.WALL);
				break;
			case 'S':
				map[indexColumn][indexLine] = new Tile();
				map[indexColumn][indexLine].receiveEntity(new Skeleton(new Vector2(indexColumn, indexLine), navigator));
				break;
			case 'W':
				map[indexColumn][indexLine] = new Tile();
				map[indexColumn][indexLine].receiveEntity(new SkeletonWizard(new Vector2(indexColumn, indexLine), navigator));
				break;
			case 'G':
				map[indexColumn][indexLine] = new Tile();
				map[indexColumn][indexLine].receiveEntity(new Goblin(new Vector2(indexColumn, indexLine), navigator));
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
