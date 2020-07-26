package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
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
	public void cast(Vector2 destination, Entity spellCaster) {
		try {
		spellCaster.getNavigator().move(spellCaster, destination);
		
		}
		catch (IllegalArgumentException e) {
			System.out.println("\n***Invalid movement, there is something in your path!***\n***Please, enter a valid command!***\n");
		}
	}
}
