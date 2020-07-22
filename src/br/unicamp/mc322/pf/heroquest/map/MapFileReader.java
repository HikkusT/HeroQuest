package br.unicamp.mc322.pf.heroquest.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO Change it in the future to return a map structure instead an array
public final class MapFileReader {

	public static char[][] readFile(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));

			// Read dimensions of map and create it
	    String line = buffRead.readLine();
	    int lines = Integer.parseInt(line);
	    line = buffRead.readLine();
	    int columns = Integer.parseInt(line);
	    char[][] map = new char[lines][columns];

	    // Read each line of map in file and process it
	    line = buffRead.readLine();
	    int index = 0;
	    while(line != null) {
	    	processLine(line, map, index);
	        line = buffRead.readLine();
	        index++;
	    }

	    buffRead.close();
	    return map;
	}

	// Read all elements in given line and include them in map
	private static void processLine(String line, char[][] map, int indexLine) {
		for(int indexColumn = 0; indexColumn < line.length(); indexColumn++) {
			char element = line.charAt(indexColumn);
			includeElement(map, element, indexLine, indexColumn);
		}
	}

	// Analyze what type of element must be created from symbol and include it in position
	// TODO It must be defined all symbols for map elements and create a case for each of them
	private static void includeElement(char[][] map, char symbol, int indexLine, int indexColumn) {
		switch(symbol) {
			case '-':
				map[indexLine][indexColumn] = '-';
				break;
			default:
				map[indexLine][indexColumn] = 'o';
				break;
		}
	}
}
