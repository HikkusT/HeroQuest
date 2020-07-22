package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.item.armor.Armor;
import br.unicamp.mc322.pf.heroquest.item.weapon.Weapon;
import br.unicamp.mc322.pf.heroquest.utils.Directions;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private Weapon weapon;
	private Armor armor;
	private int healthPoints;
	private int inteligencePoints;
	private int attackPoints;

	public Entity(Vector2 position, boolean isTranslucent) {
		super(position, isTranslucent);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Entity entity) {
		int damage = DiceManager.attack(this.attackPoints + this.weapon.getAttackPoints());
		entity.defend(damage); 	
	}
	
	public abstract void defend(int Damage);
	
	public void equipWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void equipArmor(Armor armor) {
		this.armor = armor;
	}
	
	public void move(Directions direction) {
		
	}
	

}
