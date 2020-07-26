package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.SpellCaster;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.spell.SimpleHeal;
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
		type = HeroType.ELF;
		new ShortSword().equip(set);
		spellbook = new Container<Spell>();
		spellbook.addObject(new SimpleHeal());
	}
	
	@Override
	public void castSpell(Vector2 target, Spell spell) {
		spell.cast(target, null);
		spellbook.removeObject(spell);
		
	}
	
	@Override
	public String getSprite() {
		return "Elf.png";
	}
	
	@Override
	public String toString() {
			return "E";
	}

}
