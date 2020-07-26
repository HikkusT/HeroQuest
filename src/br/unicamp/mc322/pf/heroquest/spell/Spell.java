package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Spell {
	
	public abstract String getName();
	
	public abstract void cast(Vector2 targetPosition, Entity spellCaster);

	
	public abstract String getDescription();
}
