package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.PlayerStrategy;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.item.equipment.ArmorSlot;
import br.unicamp.mc322.pf.heroquest.item.equipment.Equipment;
import br.unicamp.mc322.pf.heroquest.item.potion.Potion;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Container;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Hero extends Entity {
	protected HeroType type;
	private Container<Item> backpack; 

	public Hero(String name, Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, Navigator navigator) {
		super(name, position, healthPoints, inteligencePoints, attackPoints, defensePoints, navigator);
		backpack = new Container<Item>(); 
		strategy = new PlayerStrategy(this);
	}
	
	@Override
	public void setupTurn() {
		HeroQuest.getInstance().getRenderer().renderEvent("Your Turn!");
		currentMovementPoints = DiceManager.move();
		HeroQuest.getInstance().getRenderer().renderEvent("You got " + currentMovementPoints + " movement points in dices.");
		HeroQuest.getInstance().getRenderer().update();
	}
	
	public void collectTreasure(Item content) {
			backpack.addObject(content);
	}

	@Override
	public void defendAttack(int attackDamage) {
		int defenseDices = defensePoints;
		ArmorSlot armorSlot = set.getArmorSlot();
		
		if (!armorSlot.isEmpty()) {
			defenseDices += armorSlot.getEquipment().getDefensePoints();
		}
		
		int damageMitigated = DiceManager.getHeroShieldRolls(defenseDices);
		int trueDamage = attackDamage - damageMitigated;
		
		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
		HeroQuest.getInstance().getRenderer().renderEvent(name + " blocked " + damageMitigated + " and received " + trueDamage + " of damage.");
	}
	
	@Override
	public void defendSpell(int attackDamage) {
		int defenseDices = inteligencePoints;
		
		int damageMitigated = DiceManager.getHeroShieldRolls(defenseDices);
		int trueDamage = attackDamage - damageMitigated;

		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}
	
	@Override
	public void handleEquipment(Equipment equipment) {
		boolean wasEquipped = equipment.equip(set);
		if (!wasEquipped) {
			Equipment removedEquipment = equipment.unequip(set);
			if (removedEquipment != null) {
				this.backpack.addObject(removedEquipment);
			}		
		}
	}
	
	public void handlePotion(Potion potion) {
		potion.consume(this);
		this.backpack.removeObject(potion);
	}
	
	public HeroType getType() {
		return type;
	}
	
	public Container<Item> getBackpack() {
		return backpack;
	}
}
