package br.unicamp.mc322.pf.heroquest.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static List<String> readFile(String path) throws IOException {
		List<String> content = new ArrayList<String>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine();
		while(line != null) {
			content.add(line);
	        line = buffRead.readLine();
	    }
		
		buffRead.close();
	    return content;
	}
}
