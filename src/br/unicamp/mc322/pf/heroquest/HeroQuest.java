package br.unicamp.mc322.pf.heroquest;

import java.util.Scanner;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.dice.*;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.ClassicalMapGenerator;

public class HeroQuest {
	Renderer renderer;
	
	public HeroQuest(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void start() {
		Map world = new Map(new ClassicalMapGenerator());
		renderer.setMap(world);
		renderer.renderWorld();
		renderer.renderEvent("aaaaaa");
		renderer.renderEvent("bbbbbbb");
		
		while (true) {
		}
	}
	
	public static void main(String[] args) {		
		// Print loaded map
		String path = "map_files/example.txt";
        try {
        	char[][] map = MapFileReader.readFile(path);
        	for(int i = 0; i < 10; i++) {
        		for(int j = 0; j < 10; j++)
        			System.out.print(map[i][j]);
        		System.out.println();
        	}
        } catch(Exception exception) {
        	System.out.println(exception);
        }
	}
}
