package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import java.util.ArrayList;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Hero extends Entity {
	private ArrayList<Item> backpack; 

	public Hero(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, Map map) {
		super(name, position, healthPoints, inteligencePoints, attackPoints, 2, map);
		backpack = new ArrayList<Item>(); 
		// TODO Auto-generated constructor stub
	}
	
	public void detectTrap() {
		
	}

	@Override
	public void defend(int attackDamage) {
		int defenseDices = defensePoints;
		
		if (this.armor != null) {
			defenseDices += armor.getDefensePoints();
		}
		
		int damageMitigated = DiceManager.defendHero(defenseDices);
		int trueDamage = attackDamage - damageMitigated;
		
		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);

	}

}
