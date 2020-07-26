package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Trap extends Interactable {
	private static final int DICESTODISARM = 1;
	private boolean isDetected;
	private TrapType type;
	
	public Trap(Vector2 position, TrapType traptype) {
		super(position);
		type = traptype;
		isDetected = false;
	}
	
	public void detect() {
		isDetected = true;
	}
	
	public void activateTrap(Hero hero) {
		isDetected = true;
		hero.receiveDamage(type.getDamage());
		this.destroyTrap();
	}
	
	public void destroyTrap() {
		//TODO we need to get rid of the trap.
	}
	
	public void interact(InteractionType interaction, Hero user) {
		if (interaction == InteractionType.FIND_TRAP) {
			this.detect();
		}
		else if (interaction == InteractionType.DISARM_TRAP && this.isDetected) {
			if(DiceManager.getMonsterShieldRolls(DICESTODISARM) == 0) {
				activateTrap(user);
			}
		
			this.destroyTrap();
		}
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
			
	//TODO Maybe we need to add the step on trap interaction.
}
