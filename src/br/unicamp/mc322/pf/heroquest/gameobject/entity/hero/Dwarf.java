package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.item.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Dwarf extends Hero {
	private static final String NAME = "Dwarf";
	private static final int HEALTHPOINTS = 7;
	private static final int INTELIGENCEPOINTS = 3;
	private static final int ATTACKPOINTS = 2;
	private static final int DEFENSEPOINTS = 2;
	
	public Dwarf(Vector2 position,  Navigator navigator) {
		super(NAME, position, HEALTHPOINTS, INTELIGENCEPOINTS, ATTACKPOINTS, DEFENSEPOINTS, navigator);
		new ShortSword().equip(set);
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
			return "D";

	}
}
