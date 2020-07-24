package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Dwarf extends Hero {

	public Dwarf(Vector2 position, Map map) {
		super("Dwarf", position, 7, 3, 2, 2, map);
		new ShortSword().equip(this);
	}

	@Override
	public String toString() {
			return "D";

	}
}
