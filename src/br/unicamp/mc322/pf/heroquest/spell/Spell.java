package br.unicamp.mc322.pf.heroquest.spell;

import javax.swing.text.Position;

public abstract class Spell {
	
	public abstract String getName();
	
	public abstract void cast(Position targetPosition);
	
	public abstract String getDescription();
}
