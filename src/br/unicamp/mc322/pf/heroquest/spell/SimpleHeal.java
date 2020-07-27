package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class SimpleHeal extends Spell {
	
	public SimpleHeal() {
	}
	
	public String getName() {
		return "Simple Heal";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}

	@Override
	public void cast(Vector2 targetPosition, Entity spellCaster) {
		Entity target = spellCaster.getNavigator().getEntity(targetPosition);
		target.cure(DiceManager.rollNumberDices(1));
	}
}
