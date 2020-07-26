package br.unicamp.mc322.pf.heroquest;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.EntityManager;
import br.unicamp.mc322.pf.heroquest.input.Input;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.ClassicalMapGenerator;
import br.unicamp.mc322.pf.heroquest.map.generation.FileMapGenerator;
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
		Map world = new Map(new ClassicalMapGenerator(), new BasicIlluminator(), entityManager);
		renderer.setMap(world);
				
		runGameLoop();
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
