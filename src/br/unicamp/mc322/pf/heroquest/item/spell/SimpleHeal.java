package br.unicamp.mc322.pf.heroquest.item.spell;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;
import br.unicamp.mc322.pf.heroquest.dice.*;
import br.unicamp.mc322.pf.heroquest.render.*;

public class SimpleHeal extends Spell {
	
	public SimpleHeal() {
	}
	
	public void cast() {
		int result = DiceManager.rollNumberDices(1);
		Hero.cure(result);
	}
	
	public String getName() {
		return "Simple Heal";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}
}
