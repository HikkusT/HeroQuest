package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.SmartStrategy;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Goblin extends Monster {
	private static final String NAME = "Goblin";
	private static final int HEALTHPOINTS = 1;
	private static final int INTELIGENCEPOINTS = 0;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	private static final int MOVEMENTPOINTS = 10;

	public Goblin(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, MOVEMENTPOINTS, navigator);
		this.strategy = new SmartStrategy(this);
	}

	public boolean isHeroInRange() {
		return (getBiggerWeaponRange() >= Vector2.distance(position, navigator.getHero().getPosition()));
	}

	public void attackHero() {
		attack(navigator.getHero());
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

}
