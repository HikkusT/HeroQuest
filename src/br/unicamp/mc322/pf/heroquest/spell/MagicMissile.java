package br.unicamp.mc322.pf.heroquest.spell;

import javax.swing.text.Position;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;

public class MagicMissile extends Spell {
	
	public MagicMissile() {
	}
	
	public String getName() {
		return "Magic Missile";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}

	@Override
	public void cast(Position targetPosition) {
		// TODO Auto-generated method stub
		
	}
}