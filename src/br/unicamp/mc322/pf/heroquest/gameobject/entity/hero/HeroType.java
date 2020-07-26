package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.utils.Vector2;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.*;

public enum HeroType {
	BARBARIAN,
	DWARF,
	ELF,
	WIZARD;
	
	public Hero createHero(Vector2 position, Navigator navigator) {
		switch(this) {
		case BARBARIAN:
			return new Barbarian(position, navigator);
		case DWARF:
			return new Dwarf(position, navigator); 
		case ELF:
			return new Elf(position, navigator);
		case WIZARD:
			return new Wizard(position, navigator);
		default:
			return null;
		}
	}
}
