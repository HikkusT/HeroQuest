package br.unicamp.mc322.pf.heroquest.spell;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;
public class MagicMissile extends Spell {
	
	public MagicMissile() {
	}
	
	public String getName() {
		return "Magic Missile";
	}
	
	public String getDescription() {
		return "Heals a value from 1 to 6 hit points (6-sided die).";
	}

	@Override
	public void cast(Vector2 targetPosition) {
		// TODO Auto-generated method stub
		
	}


}