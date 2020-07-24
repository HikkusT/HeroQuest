package br.unicamp.mc322.pf.heroquest.item.spell;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;

public class Fireball extends Spell {
	
	public Fireball() {
	}
	
	public void cast() {
		Entity entity = Input.chooseEnemy();
		entity.attack(2);
		entity.attack(2);
		entity.attack(2);
	}
	
	public String getName() {
		return "Fireball";
	}
	
	public String getDescription() {
		return "Deals 6 damage to the target and 3 damage to enemies in adjacent positions";
	}
}
