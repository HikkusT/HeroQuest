package br.unicamp.mc322.pf.heroquest.spell;

import java.util.Set;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;
public class MagicMissile extends Spell {
	private static final int NUMBEROFMAGICARROWS = 3;
	private static final int MAGICARROWDAMAGE = 2;
	public MagicMissile() {
	}
	
	public String getName() {
		return "Magic Missile";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}

	@Override
	public void cast(Vector2 targetPosition, Entity spellCaster) {
		Set<Entity> mainTarget = spellCaster.getNavigator().getEntitiesOnRange(targetPosition, 0);
		for (Entity target : mainTarget) {
			for (int i = 0; i < NUMBEROFMAGICARROWS; i++) {
				target.defendSpell(MAGICARROWDAMAGE);	
			}		
		}	
	}
}