package br.unicamp.mc322.pf.heroquest;

import java.util.Scanner;

import br.unicamp.mc322.pf.heroquest.render.*;

public class Runner {
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
			renderer = new AWTRenderer(1000, 1000);
			break;
		default:
			System.out.println("Unexpected answer. Booting game in terminal.");
			renderer = new TerminalRenderer();
		}
		keyboard.close();
		
		renderer.renderEvent("Welcome to HeroQuest!");
		renderer.renderEvent("foo!");
		renderer.renderEvent("bar!");
		
		// Start GameLoop here
		while (true) {
			
		}
	}
}
