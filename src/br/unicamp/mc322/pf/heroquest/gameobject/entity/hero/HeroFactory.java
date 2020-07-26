package br.unicamp.mc322.pf.heroquest.gameobject.entity.hero;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.map.Navigator;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class HeroFactory {
	private static int maxPlayers = 1;
	private static int numberOfPlayers = 0;
	
	public static Hero createHero(Vector2 position, Navigator navigator, HeroType heroType) {
		if (numberOfPlayers >= maxPlayers) {
			throw new IllegalStateException("The max number of players has already been reached");
		}
		
		Hero hero;
		switch(heroType) {
		case BARBARIAN:
			hero = new Barbarian(position, navigator);
			break;
		case DWARF:
			hero = new Dwarf(position, navigator); 
			break;
		case ELF:
			hero = new Elf(position, navigator);
			break;
		case WIZARD:
			hero = new Wizard(position, navigator);
			break;
		default:
			throw new IllegalArgumentException("Creation for this type of hero has not yet been implemented");
		}
		
		navigator.setHero(hero);
		HeroQuest.getInstance().getRenderer().setHero(hero);
		return hero;
	}
}