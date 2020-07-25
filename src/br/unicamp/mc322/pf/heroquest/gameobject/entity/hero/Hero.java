package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.item.equipment.ArmorSlot;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Container;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Hero extends Entity {
	private Container<Item> backpack; 

	public Hero(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Navigator navigator) {
		super(name, position, healthPoints, inteligencePoints, attackPoints, defensePoints, navigator);
		backpack = new Container<Item>(); 
	}
	
	public void detectTrap() {
		
	}

	@Override
	public void defend(int attackDamage) {
		int defenseDices = defensePoints;
		ArmorSlot armorSlot = set.getArmorSlot();
		
		if (!armorSlot.isEmpty()) {
			defenseDices += armorSlot.getEquipment().getDefensePoints();
		}
		
		int damageMitigated = DiceManager.defendHero(defenseDices);
		int trueDamage = attackDamage - damageMitigated;
		
		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}
}
