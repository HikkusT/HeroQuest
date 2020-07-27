package br.unicamp.mc322.pf.heroquest.spell;

import java.util.Set;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
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
		return "Shots 3 magic arrows.";
	}

	@Override
	public void cast(Vector2 targetPosition, Entity spellCaster) {
		HeroQuest.getInstance().getRenderer().renderEvent(spellCaster.getName() + " used Magic Missile and caused " + MAGICARROWDAMAGE + " of damage.");
		Entity target = spellCaster.getNavigator().getEntity(targetPosition);
		target.defendSpell(MAGICARROWDAMAGE);		
	}
}