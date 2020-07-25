package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.LongSword;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Barbarian extends Hero {
	private static final String NAME = "Barbarian";
	private static final int HEALTHPOINTS = 8;
	private static final int INTELIGENCEPOINTS = 2;
	private static final int ATTACKPOINTS = 3;
	private static final int DEFENSEPOINTS = 2;

	public Barbarian(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, navigator);
		new LongSword().equip(set);
	}

	@Override
	public String toString() {
			return "B";
	}
}
