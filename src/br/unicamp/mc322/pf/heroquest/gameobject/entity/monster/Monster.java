package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.equipment.ArmorSlot;
import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.potion.Potion;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Monster extends Entity {
	protected final int movementPoints;

	public Monster(String name,Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, int movementPoints, Navigator navigator) {
		super(name, position, healthPoints, inteligencePoints, attackPoints, defensePoints, navigator);
		this.movementPoints = movementPoints;
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public void moveToHero() {
		navigator.findSmallerPath(this, movementPoints);
	}

	public void setupTurn() {
		
	}
	
	public abstract boolean isHeroInRange();

	public abstract void attackHero();

	@Override
	public void defendAttack(int attackDamage) {
		int defenseDices = defensePoints;
		ArmorSlot armorSlot = set.getArmorSlot();

		if (!armorSlot.isEmpty()) {
			defenseDices += armorSlot.getEquipment().getDefensePoints();
		}

		int damageMitigated = DiceManager.getMonsterShieldRolls(defenseDices);
		int trueDamage = attackDamage - damageMitigated;

		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
		HeroQuest.getInstance().getRenderer().renderEvent(name + " blocked " + damageMitigated + " and received " + trueDamage + " of damage.");
	}
	
	@Override
	public void defendSpell(int attackDamage) {
		int defenseDices = inteligencePoints;
		
		int damageMitigated = DiceManager.getMonsterShieldRolls(defenseDices);
		int trueDamage = attackDamage - damageMitigated;

		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}

	@Override
	public void handleEquipment(Equipment equipment) {
		boolean wasEquipped = equipment.equip(set);
		if (!wasEquipped) {
			equipment.unequip(set);	
		}
	}

	@Override
	public void handlePotion(Potion potion) {
		potion.consume(this);
	}

}
