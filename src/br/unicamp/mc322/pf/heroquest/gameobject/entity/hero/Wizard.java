package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.Dagger;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Wizard extends Hero {
	private static final String NAME = "Wizard";
	private static final int HEALTHPOINTS = 4;
	private static final int INTELIGENCEPOINTS = 6;
	private static final int ATTACKPOINTS = 1;
	private static final int DEFENSEPOINTS = 2;
	
	public Wizard(Vector2 position, Map map) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, map);
		new Dagger().equip(this);
	}

	@Override
	public String toString() {
			return "W";
	}
}
