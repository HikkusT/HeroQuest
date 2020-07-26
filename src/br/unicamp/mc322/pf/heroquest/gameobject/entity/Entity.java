package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.TurnStrategy;
import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;
import br.unicamp.mc322.pf.heroquest.item.equipment.WeaponSlot;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Direction;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private String name;
	private int healthPoints;
	private final int maxhealthPoints;
	private int inteligencePoints;
	private int attackPoints;
	protected TurnStrategy strategy;
	protected int defensePoints;
	protected Set set;
	protected Navigator navigator;

	public Entity(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Navigator navigator) {
		super(position, false, false);
		this.name = name;
		this.healthPoints = healthPoints;
		this.maxhealthPoints = healthPoints;
		this.inteligencePoints = inteligencePoints;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.set = new Set();
		this.navigator = navigator;

	}

	public abstract void setupTurn();

	public final void performTurn() {
		strategy.execute();
	}

	public void attack(Entity entity) {
		int attackDices = attackPoints;
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();

		if (!leftWeaponSlot.isEmpty()) {
			attackDices += leftWeaponSlot.getEquipment().attack(this);
		}
		if (!rightWeaponSlot.isEmpty()) {
			attackDices += rightWeaponSlot.getEquipment().attack(this);
		}

		int damage = DiceManager.getSkullRolls(attackDices);
		entity.defend(damage);
	}

	protected abstract void defend(int attackDamage);

	public final void receiveDamage(int damage) {
		healthPoints -= damage;

		//We have to discuss later about removing this entity from the active entities.
		if (healthPoints <= 0) {
			//navigator.removeEntity(position);
		}

	}

	public void cure(int points) {
		healthPoints += points;
	}

	public void equipEquipment(Equipment equipment) {
		equipment.equip(set);// ta retornando true ou false caso de pra equipar ou nao.
	}

	public int getBiggerWeaponRange() {
		int rangeLeft = 0;
		int rangeRight = 0;
		WeaponSlot leftWeaponSlot = set.getleftHandWeaponSlot();
		WeaponSlot rightWeaponSlot = set.getRightHandWeaponSlot();

		if (!leftWeaponSlot.isEmpty()) {
			rangeLeft = leftWeaponSlot.getEquipment().getRange();
		}

		if (!rightWeaponSlot.isEmpty()) {
			rangeRight = rightWeaponSlot.getEquipment().getRange();
		}

		if(rangeLeft >= rangeRight)
			return rangeLeft;
		else
			return rangeRight;
	}

	public boolean canMove(Direction direction) {
		Vector2 target = Vector2.sum(position, direction.toVector2());
		return navigator.isPassable(target);
	}

	public void move(Direction direction) {
		//Direction obtained from update.
		//TODO: return boolean, if it moved or not.
		try {
			Vector2 target = Vector2.sum(position, direction.toVector2());
			navigator.move(this, target);
			position = target;
		}
		catch (IllegalArgumentException e) {
			System.out.println("\n***Invalid movement, there is something in your path!***\n***Please, enter a valid command!***\n");
		}
	}
}
