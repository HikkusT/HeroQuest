package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.LongSword;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Barbarian extends Hero {

	public Barbarian(Vector2 position, Navigator navigator) {
		super("Barbarian", position, 8, 2, 3, 2, navigator);
		new LongSword().equip(this);;
	}

	@Override
	public String toString() {
			return "B";
	}
}
