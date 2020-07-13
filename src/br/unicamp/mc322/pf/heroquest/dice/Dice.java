package br.unicamp.mc322.pf.heroquest.dice;

import java.util.Random;

public class Dice {
	Random dice;
	
	public Dice() {
		dice = new Random();
	}
	
	public int rollRedDice() {
		return dice.nextInt(6) + 1;
	}
	
	public DiceSide rollCombatDice() {
		int result = dice.nextInt(6) + 1;
		if(result <= 3)
			return DiceSide.SKULL;
		if(result <= 5)
			return DiceSide.HEROSHIELD;
		else
			return DiceSide.MONSTERSHIELD;
	}
}
