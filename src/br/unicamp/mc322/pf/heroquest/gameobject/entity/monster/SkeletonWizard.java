package br.unicamp.mc322.pf.heroquest.gameobject.entity.monster;


import br.unicamp.mc322.pf.heroquest.gameobject.entity.SpellCaster;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.strategy.IdleStrategy;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.spell.MagicMissile;
import br.unicamp.mc322.pf.heroquest.spell.Spell;
import br.unicamp.mc322.pf.heroquest.utils.Container;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class SkeletonWizard extends Monster implements SpellCaster {
	private static final String NAME = "Skeleton Wizard";
	private static final int HEALTHPOINTS = 1;
	private static final int INTELIGENCEPOINTS = 0;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	private static final int MOVEMENTPOINTS = 10;
	private Container<Spell> spellbook;
	
	
	public SkeletonWizard(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, MOVEMENTPOINTS, navigator);
		this.strategy = new IdleStrategy(this);
		spellbook = new Container<Spell>();
		spellbook.addObject(new MagicMissile());
		spellbook.addObject(new MagicMissile());
	}

	public boolean isHeroInRange() {
		boolean canCastSpell = navigator.isInFieldOfView(position); // && has charges
		boolean canAttack = (1 == Vector2.distance(position, navigator.getHero().getPosition()));
		return (canCastSpell || canAttack);
	}

	public void attackHero() {
		boolean canCastSpell = navigator.isInFieldOfView(position); // && has charges
		if(canCastSpell) {
			//castSpell(navigator.getHero().getPosition(), spellbook.) // TODO:
		}
		else
			attack(navigator.getHero());
	}
	
	@Override
	public void castSpell(Vector2 target, Spell spell) {
		spell.cast(target, null);
		spellbook.removeObject(spell);
		
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return "Skeleton.png";
	}


}
