package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Teleport extends Spell {
	
	public Teleport() {
	} 

	public String getName() {
		return "Teleport";
	}
	
	public String getDescription() {
		return "The hero or monster moves to another visible position.";
	}

	@Override
	public void cast(Vector2 targetPosition) {
		// TODO Auto-generated method stub
		
	}
}
