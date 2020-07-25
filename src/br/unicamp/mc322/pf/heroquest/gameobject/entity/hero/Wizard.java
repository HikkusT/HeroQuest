package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.SpellCaster;
import br.unicamp.mc322.pf.heroquest.item.weapon.Dagger;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Wizard extends Hero implements SpellCaster {
	private static final String NAME = "Wizard";
	private static final int HEALTHPOINTS = 4;
	private static final int INTELIGENCEPOINTS = 6;
	private static final int ATTACKPOINTS = 1;
	private static final int DEFENSEPOINTS = 2;
	private Container<Spell> spellbook;
	//adicionar magias iniciais.
	
	public Wizard(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, navigator);
		new Dagger().equip(this);
		spellbook = new Container<Spell>();
		//adicionar magias iniciais.
	}

	@Override
	public String toString() {
			return "W";
	}

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		
	}
}
