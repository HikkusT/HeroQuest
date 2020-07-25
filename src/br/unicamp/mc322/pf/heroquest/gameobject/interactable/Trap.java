package br.unicamp.mc322.pf.heroquest.gameobject.interactable;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Trap extends Interactable {
	private boolean detected;
	private boolean disarmed;
	private TrapType type;
	
	public Trap(Vector2 position, TrapType traptype) {
		super(position, true, true);
		type = traptype;
		detected = false;
		disarmed = false;
	}
	
	public boolean isDetected() {
		return detected;
	}
	
	public boolean isDisarmed() {
		return disarmed;
	}
	
	public void interact() {
		if(detected) {
			disarmed = true;
		}
	}
	
	public void detect() {
		detected = true;
	}
	
	public int fallInTrap() {
		detected = true;
		disarmed = true;
		return type.getDamage();
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
}
