package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.item.armor.Armor;
import br.unicamp.mc322.pf.heroquest.item.weapon.Weapon;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Directions;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private String name;
	private Weapon weapon;
	protected Armor armor;
	private int healthPoints;
	private int inteligencePoints;
	private int attackPoints;
	protected int defensePoints;
	private Map map;

	public Entity(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Map map) {
		super(position, false, false);
		this.name = name;
		this.healthPoints = healthPoints;
		this.inteligencePoints = inteligencePoints;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.map = map;
	}
	
	public void attack(Entity entity) {
		int attackDices = attackPoints;
		
		if (weapon != null) {
			attackDices += weapon.getAttackPoints();
		}
		
		int damage = DiceManager.attack(attackDices);
		entity.defend(damage); 	
	}
	
	public abstract void defend(int attackDamage);
	
	protected final void receiveDamage(int damage) {
		healthPoints -= damage;
		// ver como vai ser a movimenta��o, para ver se tirar a entity de um tile ser� como mat�-la. Al�m de ser necess�rio
		// tir�-la do ciclo de entidades.
	}
	
	
	public void equipWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void equipArmor(Armor armor) {
		this.armor = armor;
	}
	
	public void move(Directions direction) {
		try {
			switch(direction) {
			case NORTH:
				this.goNorth();
			case SOUTH:
				this.goSouth();
			case EAST:
				this.goEast();
			case WEST:
				this.goWest();
				
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("\n***Invalid movement, there is something in your path!***\n***Please, enter a valid command!***\n");
		}
		
	}
	
	void goNorth()
	{
		
		Vector2 north = new Vector2(0, 1);
		Vector2 new_position = Vector2.sum(this.position, north);
		//map.map.setEntity(new_position);
		position = new_position;
	
	}
	
	void goSouth()
	{
		Vector2 south = new Vector2(0, -1);
		Vector2 new_position = Vector2.sum(this.position, south);
		//map.map.setEntity(new_position);
		position = new_position;
	
	}
	
	void goEast()
	{
		Vector2 east = new Vector2(1, 0);
		Vector2 new_position = Vector2.sum(this.position, east);
		//map.map.setEntity(new_position);
		position = new_position;
	

	}
	
	void goWest()
	{
		Vector2 west = new Vector2(-1, 0);
		Vector2 new_position = Vector2.sum(this.position, west);
		//map.map.setEntity(new_position);
		position = new_position;
	
	}
	
	public void cure(int points) {
		healthPoints += points;
	}
	
	public void getDamage(int points) {
		healthPoints -= points;
	}

}
