package br.unicamp.mc322.pf.heroquest;

import java.util.Scanner;

import br.unicamp.mc322.pf.heroquest.input.Input;
import br.unicamp.mc322.pf.heroquest.input.SwingInput;
import br.unicamp.mc322.pf.heroquest.input.TerminalInput;
import br.unicamp.mc322.pf.heroquest.render.Renderer;
import br.unicamp.mc322.pf.heroquest.render.SwingRenderer;
import br.unicamp.mc322.pf.heroquest.render.TerminalRenderer;

public class Runner {
	public static void main(String[] args) {
		Renderer renderer;
		Input input;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 1 if you want to run the game in the terminal.");
		System.out.println("Enter 2 if you want to run the game in a GUI.");
		String option = keyboard.nextLine();
		switch (option) {
		case "1":
			input = new TerminalInput();
			renderer = new TerminalRenderer();
			break;
		case "2":
			SwingInput swingInput = new SwingInput();
			renderer = new SwingRenderer(swingInput);
			input = swingInput;
			break;
		default:
			System.out.println("Unexpected answer. Booting game in terminal.");
			input = new TerminalInput();
			renderer = new TerminalRenderer();
		}
		
		HeroQuest.getInstance().start(renderer, input);
		keyboard.close();
	}
}
