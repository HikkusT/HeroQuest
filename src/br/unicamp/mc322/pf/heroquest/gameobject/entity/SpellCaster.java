package br.unicamp.mc322.pf.heroquest.gameobject.entity;

import br.unicamp.mc322.pf.heroquest.item.spell.Spell;
import br.unicamp.mc322.pf.heroquest.utils.Container;

public interface SpellCaster {
	
	// We set Container<Spells> as a parameter to reinforce that every SpellCaster needs your "Container<Spells>", a.k.a, spellbook.
	public void cast(Container<Spell> spellbook);
}
