	package br.unicamp.mc322.pf.heroquest.gameobject.entity;


import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.GameObject;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.TurnStrategy;
import br.unicamp.mc322.pf.heroquest.item.Item;

import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.equipment.Set;
import br.unicamp.mc322.pf.heroquest.item.equipment.WeaponSlot;

import br.unicamp.mc322.pf.heroquest.item.potion.Potion;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Direction;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Entity extends GameObject {
	private String name;
	private int healthPoints;
	private final int maxHealthPoints;
	protected int inteligencePoints;
	private int attackPoints;
	protected int currentMovementPoints;
	protected TurnStrategy strategy;
	protected int defensePoints;
	protected Set set;
	protected Navigator navigator;

	public Entity(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Navigator navigator) {
		super(position);
		this.name = name;
		this.healthPoints = healthPoints;
		this.maxHealthPoints = healthPoints;
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
		entity.defendAttack(damage);
		
		
	}

	protected abstract void defendAttack(int attackDamage);
	
	public void defendSpell(int attackDamage) {
		int defenseDices = inteligencePoints;
		
		int damageMitigated = DiceManager.getMonsterShieldRolls(defenseDices);
		int trueDamage = attackDamage - damageMitigated;

		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}

	public final void receiveDamage(int damage) {
		healthPoints -= damage;

		if (healthPoints <= 0) {
			destroy();
		}

	}

	public void cure(int points) {
		healthPoints += points;
		if (healthPoints > maxHealthPoints) {
			healthPoints = maxHealthPoints;
		}
	}

	public void useItem(Item item) {
		item.use(this);
	}	
	public abstract void handleEquipment(Equipment equipment);
	
	public abstract void handlePotion(Potion potion);
	

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

	public boolean move(Vector2 target) {
		try {
			navigator.move(this, target);
			position = target;
		}
		catch (IllegalArgumentException e) {
			return false;
		}
		
		currentMovementPoints--;
		HeroQuest.getInstance().getRenderer().update();
		return true;
	}
	public String getName() {
		return name;
	}
	
	public boolean move(Direction direction) {
		return move(position.translated(direction));
	}
	
	public Navigator getNavigator() {
		return navigator;
	}
	
	@Override
	public boolean getTransposability() {
		return false;
	}
	
	@Override
	public boolean getTranslucency() {
		return true;
	}
	
	public int getCurrentHP() {
		return healthPoints;
	}
	
	public int getRemainingMovementPoints() {
		return currentMovementPoints;
	}

	public boolean getVisibility() {
		return navigator.isVisible(position);
	}
	
	private void destroy() {
		navigator.despawnEntity(this);
	}
}
