package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.IdleStrategy;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Skeleton extends Monster {
	private static final String NAME = "Skeleton";
	private static final int HEALTHPOINTS = 1;
	private static final int INTELIGENCEPOINTS = 0;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	private static final int MOVEMENTPOINTS = 10;

	public Skeleton(Vector2 position, Navigator navigator, Hero hero) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, MOVEMENTPOINTS, navigator, hero);
		this.strategy = new IdleStrategy(this);
	}

	public boolean isHeroInRange() {
		return weapon.getRange() >= Vector2.distance(position, hero.getPosition());
	}
}
