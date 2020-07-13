package br.unicamp.mc322.pf.heroquest;

import java.util.Scanner;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.dice.*;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.ClassicalMapGenerator;

public class HeroQuest {
	public static void main(String[] args) {
		Renderer renderer;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 1 if you want to run the game in the terminal.");
		System.out.println("Enter 2 if you want to run the game in a GUI.");
		String input = keyboard.nextLine();
		switch (input) {
		case "1":
			renderer = new TerminalRenderer();
			break;
		case "2":
			renderer = new SwingRenderer(1000, 1000);
			break;
		default:
			System.out.println("Unexpected answer. Booting game in terminal.");
			renderer = new TerminalRenderer();
		}
		
		renderer.renderEvent("Welcome to HeroQuest!");
		renderer.renderEvent("foo!");
		renderer.renderEvent("bar!");
		Map world = new Map(new ClassicalMapGenerator());
		renderer.renderWorld(world);
		
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
        
		// Start GameLoop here
		while (true) {
			renderer.renderEvent("Enter anything to move");
			input = keyboard.nextLine();
			renderer.renderEvent("You can move " + DiceManager.move() + " positions!");
			
			renderer.renderEvent("Enter anything to attack");
			input = keyboard.nextLine();
			renderer.renderEvent("You can cause " + DiceManager.attack(3) + " damage!");
			
			input = keyboard.nextLine();
			renderer.renderEvent("Monster defended " + DiceManager.defendMonster(2) + " damage!");
			
			renderer.renderEvent("Enter anything to defend");
			input = keyboard.nextLine();
			renderer.renderEvent("Hero can defend " + DiceManager.defendHero(2) + " damage!");
		}
	}
}
