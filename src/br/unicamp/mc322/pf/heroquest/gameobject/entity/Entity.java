package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.TurnStrategy;
import br.unicamp.mc322.pf.heroquest.item.Equipable;
import br.unicamp.mc322.pf.heroquest.item.armor.Armor;
import br.unicamp.mc322.pf.heroquest.item.weapon.Weapon;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Directions;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private String name;
	private int healthPoints;
	private final int maxhealthPoints;
	private int inteligencePoints;
	private int attackPoints;
	protected TurnStrategy strategy;
	protected int defensePoints;
	private Weapon[] weapons;
	protected Armor armor;
	private Navigator navigator;

	public Entity(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Navigator navigator) {
		super(position, false, false);
		this.name = name;
		this.healthPoints = healthPoints;
		this.inteligencePoints = inteligencePoints;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.weapons = new Weapon[2];
		this.navigator = navigator;
		this.maxhealthPoints = healthPoints;
	}

	public void setupTurn() {
		// Here we can do things like reset the number of movements I can make, etc and decide which strategy to use
	}

	public final void performTurn() {

		strategy.execute();
	}

	public void attack(Entity entity) {
		int attackDices = attackPoints;

		if (weapons[0] != null) {
			attackDices += weapons[0].attack(this);
		}
		if (weapons[1] != null) {
			attackDices += weapons[1].attack(this);
		}

		int damage = DiceManager.attack(attackDices);
		entity.defend(damage);
	}

	protected abstract void defend(int attackDamage);

	protected final void receiveDamage(int damage) {
		healthPoints -= damage;

		//We have to discuss later about removing this entity from the active entities.
		if (healthPoints <= 0) {
			// map.removeEntity(position);
		}

	}

	public void cure(int points) {
		healthPoints += points;
	}

	public void equipEquipment(Equipable equipment) {
		equipment.equip(this);
	}

	public void equiWeapon(Weapon weapon) {
		this.weapons[0] = weapon;
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
		navigator.move(this, new_position);
		position = new_position;

	}

	void goSouth()
	{
		Vector2 south = new Vector2(0, -1);
		Vector2 new_position = Vector2.sum(this.position, south);
		navigator.move(this, new_position);
		position = new_position;

	}

	void goEast()
	{
		Vector2 east = new Vector2(1, 0);
		Vector2 new_position = Vector2.sum(this.position, east);
		navigator.move(this, new_position);
		position = new_position;


	}

	void goWest()
	{
		Vector2 west = new Vector2(-1, 0);
		Vector2 new_position = Vector2.sum(this.position, west);
		navigator.move(this, new_position);
		position = new_position;

	}


}
