package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Elf extends Hero {
	private static final String NAME = "Elf";
	private static final int HEALTHPOINTS = 6;
	private static final int INTELIGENCEPOINTS = 4;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	
	public Elf(Vector2 position, Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, navigator);
		new ShortSword().equip(this);
	}
	
	@Override
	public String toString() {
			return "E";
	}
}
