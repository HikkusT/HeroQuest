package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.dice.DiceManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class Monster extends Entity {
	protected Hero hero;
	private int movementPoints;
	private final int maxMovementPoints;

	public Monster(String name,Vector2 position, int healthPoints, int inteligencePoints, int attackPoints, int defensePoints, int movementPoints, Navigator navigator, Hero hero) {
		super(name, position, healthPoints, inteligencePoints, attackPoints, defensePoints, navigator);
		this.movementPoints = movementPoints;
		this.maxMovementPoints = movementPoints;
	}

	public void decrementMovementPoints() {
		movementPoints--;
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public abstract boolean isHeroInRange();

	public void attackHero() {
	}

	@Override
	public void defend(int attackDamage) {
		int defenseDices = defensePoints;

		if (this.armor != null) {
			defenseDices += armor.getDefensePoints();
		}

		int damageMitigated = DiceManager.defendMonster(defenseDices);
		int trueDamage = attackDamage - damageMitigated;

		trueDamage = (trueDamage > 0) ? trueDamage : 0;

		this.receiveDamage(trueDamage);
	}

}
