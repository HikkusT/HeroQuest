package br.unicamp.mc322.pf.heroquest.spell;

import java.util.Set;

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
		Set<Entity> mainTarget = spellCaster.getNavigator().getEntitiesOnRange(targetPosition, 0);
		for (Entity target : mainTarget) {
			target.cure(DiceManager.rollNumberDices(1));
		}	
	}
}
