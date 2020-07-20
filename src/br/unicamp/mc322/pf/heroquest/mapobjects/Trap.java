package br.unicamp.mc322.pf.heroquest.mapobjects;

public class Trap extends MapObject {
	private boolean detected;
	private boolean disarmed;
	private TrapType type;
	
	public Trap(int posX, int posY, TrapType traptype) {
		super(posX, posY);
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
}
