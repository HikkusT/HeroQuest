package br.unicamp.mc322.pf.heroquest;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.EntityManager;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.HeroType;
import br.unicamp.mc322.pf.heroquest.input.*;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.*;
import br.unicamp.mc322.pf.heroquest.map.illuminator.BasicIlluminator;

public class HeroQuest {
	private static HeroQuest instance;
	private Renderer renderer;
	private Input input;
	private EntityManager entityManager;

	public static HeroQuest getInstance() {
		if (instance == null) {
			instance = new HeroQuest();
		}

		return instance;
	}

	private HeroQuest() { }

	public void start(Renderer renderer, Input input) {
		this.renderer = renderer;
		this.input = input;

		entityManager = new EntityManager();
		HeroType hero = askHeroType();
		Map world = createWorld(hero);
		renderer.setMap(world);

		runGameLoop();
	}

	private HeroType askHeroType() {
		renderer.renderEvent("Press the number that indicates the hero you want to play with.");
		renderer.renderEvent("1 - Barbarian");
		renderer.renderEvent("2 - Dwarf");
		renderer.renderEvent("3 - Elf");
		renderer.renderEvent("4 - Wizard");
		
		Command answer;
		HeroType hero = null;
		boolean answered = false;

		while(!answered) {
			answer = input.waitForNextCommand();
			if(answer == Command.SEARCH_TREASURES) {
				hero = HeroType.BARBARIAN;
				answered = true;
			}
			else if(answer == Command.SEARCH_TRAPS) {
				hero = HeroType.DWARF;
				answered = true;
			}
			else if(answer == Command.DISARM_TRAP) {
				hero = HeroType.ELF;
				answered = true;
			}
			else if(answer == Command.AUX) {
				hero = HeroType.WIZARD;
				answered = true;
			}
		}
		return hero;
	}
	
	private Map createWorld(HeroType hero) {
		renderer.renderEvent("If you want to play in a random map, press 1.");
		renderer.renderEvent("If you want to play in a loaded map, press 2.");
		Command answer;
		Map world = null;
		boolean answered = false;
		
		while(!answered) {
			answer = input.waitForNextCommand();
			if(answer == Command.SEARCH_TREASURES) {
				world = new Map(new ClassicalMapGenerator(), new BasicIlluminator(), entityManager, hero);
				answered = true;
			}
			else if(answer == Command.SEARCH_TRAPS) {
				world = new Map(new FileMapGenerator(), new BasicIlluminator(), entityManager, hero);
				answered = true;
			}
		}
		return world;
	}
	
	private void runGameLoop() {
		while (true) {
			entityManager.nextTurn();
			renderer.renderWorld();

			// TODO: Maybe remove this delay. It´s ugly
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) { }

		}
	}

	public Input getInput() {
		return input;
	}

	public Renderer getRenderer() {
		return renderer;
	}
}
