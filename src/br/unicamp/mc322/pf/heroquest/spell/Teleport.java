package br.unicamp.mc322.pf.heroquest.spell;

import javax.swing.text.Position;

public class Teleport extends Spell {
	
	public Teleport() {
	} 
	
	@Override
	public void cast(Position targetPosition) {
		// TODO Auto-generated method stub
		
	}
	public String getName() {
		return "Teleport";
	}
	
	public String getDescription() {
		return "The hero or monster moves to another visible position.";
	}


}
