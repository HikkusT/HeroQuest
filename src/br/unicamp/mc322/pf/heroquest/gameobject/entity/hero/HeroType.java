package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;

public enum HeroType {
	BARBARIAN("Barbarian"),
	DWARF("Dwarf"),
	ELF("Elf"),
	WIZARD("Wizard");
	
	private final String name;
	
	private HeroType(String name) {
		this.name = name;
	}
	
	public static HeroType fromString(String heroType) {
		for (HeroType type : HeroType.values()) {
			if (type.toString() == heroType)
				return type;
		}
		
		throw new IllegalArgumentException("Undefined hero type");
	}
	
	@Override
	public String toString() {
		return name;
	}
}
