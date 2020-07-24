package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Elf extends Hero {

	public Elf(Vector2 position, Map map) {
		super("Elf", position, 6, 4, 2, 2, map);
		new ShortSword().equip(this);
	}
	
	@Override
	public String toString() {
			return "E";
	}
}