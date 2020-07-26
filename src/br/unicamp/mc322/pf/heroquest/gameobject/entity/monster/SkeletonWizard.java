package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.IdleStrategy;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class SkeletonWizard extends Monster {
	private static final String NAME = "Skeleton Wizard";
	private static final int HEALTHPOINTS = 1;
	private static final int INTELIGENCEPOINTS = 0;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	private static final int MOVEMENTPOINTS = 10;

	public SkeletonWizard(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, MOVEMENTPOINTS, navigator);
		this.strategy = new IdleStrategy(this);
	}

	public boolean isHeroInRange() {
		boolean canCastSpell = navigator.isInFieldOfView(this); // && has charges
		boolean canAttack = (1 == Vector2.distance(position, navigator.getHero().getPosition()));
		return (canCastSpell || canAttack);
	}

	public void attackHero() {
		boolean canCastSpell = navigator.isInFieldOfView(this); // && has charges
		if(canCastSpell) {
			//cast(hero.getPosition())
		}
		else
			attack(navigator.getHero());
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return "Skeleton.png";
	}
}
