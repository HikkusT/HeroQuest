package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.Dagger;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Wizard extends Hero {

	public Wizard(Vector2 position, Map map) {
		super("Wizard", position,4, 6, 1, 2, map);
		new Dagger().equip(this);
	}

	@Override
	public String toString() {
			return "W";
	}
}
