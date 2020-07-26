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
	private boolean running;

	public static HeroQuest getInstance() {
		if (instance == null) {
			instance = new HeroQuest();
		}

		return instance;
	}

	private HeroQuest() { 
		running = false;
	}

	public void start(Renderer renderer, Input input) {
		this.renderer = renderer;
		this.input = input;
		entityManager = new EntityManager();
		HeroType heroType = chooseHeroType();
		Map world = createWorld(heroType);
		renderer.setMap(world);

		runGameLoop();
	}
	
	public void finishGame(boolean failed) {
		if (failed) {
			renderer.renderEvent("You lost the game :(");
			running = false;
		}
	}

	private HeroType chooseHeroType() {
		String[] classes = new String[] { "Barbarian", "Dwarf", "Elf", "Wizard" };
		renderer.askQuestion("Choose your class:", classes);
		int option = input.waitForOption();
		return HeroType.fromString(classes[option]);
	}
	
	private Map createWorld(HeroType heroType) {
		String[] mapGenerators = new String[] { "Random Map", "Loaded from file" };
		renderer.askQuestion("Choose how the map should be generated", mapGenerators);
		int option = input.waitForOption();
		if (option == 0) {
			return new Map(new ClassicalMapGenerator(heroType), new BasicIlluminator(), entityManager);
		} else {
			return new Map(new FileMapGenerator(heroType), new BasicIlluminator(), entityManager);
		}
	}
	
	private void runGameLoop() {
		running = true;
		while (running) {
			entityManager.nextTurn();
			renderer.update();

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
