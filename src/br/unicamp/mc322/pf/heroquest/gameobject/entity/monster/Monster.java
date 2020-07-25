package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.equipment.ArmorSlot;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Monster extends Entity {
	private int movementPoints;
	private final int maxMovementPoints;
	
	public Monster(String name,Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, int movementPoints, Navigator navigator) {
		
		super(name, position, healthPoints, inteligencePoints, attackPoints, defensePoints, navigator);
		this.movementPoints = movementPoints;
		this.maxMovementPoints = movementPoints;
	}
	
	public int getMovementPoints() {
		return movementPoints;
	}
	
	@Override
	public void defend(int attackDamage) {
		int defenseDices = defensePoints;
		ArmorSlot armorSlot = set.getArmorSlot();
		
		if (!armorSlot.isEmpty()) {
			defenseDices += armorSlot.getEquipment().getDefensePoints();
		}
		
		int damageMitigated = DiceManager.defendMonster(defenseDices);
		int trueDamage = attackDamage - damageMitigated;
		
		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}
	

}
