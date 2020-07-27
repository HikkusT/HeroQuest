package br.unicamp.mc322.pf.heroquest.spell;

import java.util.Set;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Fireball extends Spell {
	private static final int MAINTARGETDAMAGE = 6;
	private static final int ADJACENTTARGETDAMAGE = 3;
	
	public Fireball() {
	}
	
	public String getName() {
		return "Fireball";
	}
	
	public String getDescription() {
		return "Deals 6 damage to the target and 3 damage to enemies in adjacent positions";
	}

	@Override
	public void cast(Vector2 targetPosition, Entity spellCaster) {
		Entity target = spellCaster.getNavigator().getEntity(targetPosition);
			target.defendSpell(MAINTARGETDAMAGE);
		
		Set<Entity> adjacentTargets = spellCaster.getNavigator().getEntitiesOnRange(targetPosition, 1);
		for (Entity target1 : adjacentTargets) {
			target1.defendSpell(ADJACENTTARGETDAMAGE);
		}
		
	}

}
