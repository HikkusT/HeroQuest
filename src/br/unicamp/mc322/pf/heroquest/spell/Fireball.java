package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Fireball extends Spell {
	
	public Fireball() {
	}
	
	public String getName() {
		return "Fireball";
	}
	
	public String getDescription() {
		return "Deals 6 damage to the target and 3 damage to enemies in adjacent positions";
	}

	@Override
	public void cast(Vector2 targetPosition) {
		// TODO Auto-generated method stub
		
	}

}
