package br.unicamp.mc322.pf.heroquest.spell;

import javax.swing.text.Position;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;

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
	public void cast(Position targetPosition) {
		// TODO Auto-generated method stub
		
	}
}
