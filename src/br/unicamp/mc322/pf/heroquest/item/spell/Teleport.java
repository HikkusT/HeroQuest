package br.unicamp.mc322.pf.heroquest.item.spell;

public class Teleport extends Spell {
	
	public Teleport() {
	} 
	
	public void cast() {
		int position = Input.askPosition();
		Hero.move(position);
	}
	
	public String getName() {
		return "Teleport";
	}
	
	public String getDescription() {
		return "The hero or monster moves to another visible position.";
	}
}
