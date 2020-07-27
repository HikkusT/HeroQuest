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
			case "E":
				return Command.OPEN_DOOR;
			case "I":
				return Command.USE_ITEM;
			case "Q":
				return Command.ATTACK;
			case "1":
				return Command.SEARCH_TREASURES;
			case "2":
				return Command.SEARCH_TRAPS;
			case "3":
				return Command.DISARM_TRAP;
			case "4":
				return Command.END_TURN;
			default:
				isValidInput = false;
			}
		} while (!isValidInput);
		
		throw new RuntimeException("No command was resolved");
	}
	
	@Override
	public int waitForOption(int expectedNumberOptions) {
		String input = keyboard.nextLine();
		try {
			int option = Integer.parseInt(input);
			if (option < 1 || option > expectedNumberOptions) {
				System.out.println("Unexpected option. Defaulting to option 1");
				return 0;
			}
			return option - 1;
		} catch (NumberFormatException e) {
			System.out.println("Unexpected option. Defaulting to option 1");
			return 0;
		}
	}
}
