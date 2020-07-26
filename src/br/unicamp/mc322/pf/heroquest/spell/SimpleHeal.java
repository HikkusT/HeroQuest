package br.unicamp.mc322.pf.heroquest.spell;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;

import javax.swing.text.Position;

import br.unicamp.mc322.pf.heroquest.dice.*;
import br.unicamp.mc322.pf.heroquest.render.*;

public class SimpleHeal extends Spell {
	
	public SimpleHeal() {
	}
	
	public void cast(Position targetPosition) {
		int result = DiceManager.rollNumberDices(1);
		
	}
	
	public String getName() {
		return "Simple Heal";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}
}
