package br.unicamp.mc322.pf.heroquest.item.spell;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.*;

public class MagicMissile extends Spell {
	
	public MagicMissile() {
	}
	
	public void cast() {
		Entity entity = Input.chooseEnemy();
		entity.attack(2);
		entity.attack(2);
		entity.attack(2);
	}
	
	public String getName() {
		return "Magic Missile";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}
}