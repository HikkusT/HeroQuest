package br.unicamp.mc322.pf.heroquest.dice;

public final class DiceManager {
	private static Dice dice = new Dice();
	
	public static int rollNumberDices(int n) {
		int result = 0;
		for(int i = 0; i < n; i++)
			result += dice.rollRedDice();
		return result;
	}
	
	public static int move() {
		int dice1 = dice.rollRedDice();
		int dice2 = dice.rollRedDice();
		return dice1 + dice2;
	}
	
	public static int getSkullRolls(int numDices) {
		return rollCombatDices(numDices, DiceSide.SKULL);
	}
	
	public static int getHeroShieldRolls(int numDices) {
		return rollCombatDices(numDices, DiceSide.HEROSHIELD);
	}
	
	public static int getMonsterShieldRolls(int numDices) {
		return rollCombatDices(numDices, DiceSide.MONSTERSHIELD);
	}
	
	private static int rollCombatDices(int numDices, DiceSide side) {
		int rolls = 0;
		DiceSide result;
		
		for(int i = 0; i < numDices; i++) {
			result = dice.rollCombatDice();
			if(result == side)
				rolls++;
		}	
		return rolls;
	}
}
