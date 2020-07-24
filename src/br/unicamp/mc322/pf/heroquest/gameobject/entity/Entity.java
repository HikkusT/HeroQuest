package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.item.Equipable;
import br.unicamp.mc322.pf.heroquest.item.armor.Armor;
import br.unicamp.mc322.pf.heroquest.item.weapon.Weapon;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Directions;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private String name;
	//We need 2 weapons.
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
			attackDices += weapon.attack();
		}
		
		int damage = DiceManager.attack(attackDices);
		entity.defend(damage); 	
	}
	
	protected abstract void defend(int attackDamage);
	
	protected final void receiveDamage(int damage) {
		healthPoints -= damage;
		
		//We have to discuss later about removing this entity from the active entities.
		if (healthPoints <= 0) {
			map.removeEntity(position);
		}
		
	}
	
	
	public void cure(int points) {
		healthPoints += points;
	}
	
	
	public void equipEquipment(Equipable equipment) {
		equipment.equip(this);
	}
	
	
	private void move(Directions direction) {
		//Direction obtained from update.
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
		map.placeEntity(this, new_position);
		map.removeEntity(position);
		position = new_position;
	
	}
	
	void goSouth()
	{
		Vector2 south = new Vector2(0, -1);
		Vector2 new_position = Vector2.sum(this.position, south);
		map.placeEntity(this, new_position);
		map.removeEntity(position);
		position = new_position;
	
	}
	
	void goEast()
	{
		Vector2 east = new Vector2(1, 0);
		Vector2 new_position = Vector2.sum(this.position, east);
		map.placeEntity(this, new_position);
		map.removeEntity(position);
		position = new_position;
	

	}
	
	void goWest()
	{
		Vector2 west = new Vector2(-1, 0);
		Vector2 new_position = Vector2.sum(this.position, west);
		map.placeEntity(this, new_position);
		map.removeEntity(position);
		position = new_position;
	
	}


}
