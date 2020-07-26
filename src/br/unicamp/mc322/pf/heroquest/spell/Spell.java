package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Spell {
	
	public abstract String getName();
	
	public abstract void cast(Vector2 targetPosition);
	//TODO: We need to get the entities from certain position for casting spells.
	
	public abstract String getDescription();
}
