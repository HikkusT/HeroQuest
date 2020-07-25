package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.SpellCaster;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.spell.Spell;
import br.unicamp.mc322.pf.heroquest.utils.Container;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Elf extends Hero implements SpellCaster {
	private static final String NAME = "Elf";
	private static final int HEALTHPOINTS = 6;
	private static final int INTELIGENCEPOINTS = 4;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	private Container<Spell> spellbook;
	
	public Elf(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, navigator);
		new ShortSword().equip(set);
		spellbook = new Container<Spell>();
		//adicionar magias iniciais.
	}
	
	@Override
	public String toString() {
			return "E";
	}

	@Override
	public void cast(Container<Spell> spellbook) {
		// TODO Auto-generated method stub
		
	}
}
