package br.unicamp.mc322.pf.heroquest.input;

import java.util.Scanner;

public class TerminalInput implements Input {
	Scanner keyboard;
	
	public TerminalInput() {
		keyboard = new Scanner(System.in);
	}
	
	@Override
	public Command waitForNextCommand() {
		boolean isValidInput = true;
		do {
			String currentInput = keyboard.nextLine();
			switch (currentInput.toUpperCase()) {
			case "W":
				return Command.MOVE_UP;
			case "D":
				return Command.MOVE_RIGHT;
			case "S":
				return Command.MOVE_DOWN;
			case "A":
				return Command.MOVE_LEFT;
			default:
				isValidInput = false;
			}
		} while (isValidInput);
		
		throw new RuntimeException("No command was resolved");
	}
}
