package br.unicamp.mc322.pf.heroquest;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.EntityManager;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.ClassicalMapGenerator;
import br.unicamp.mc322.pf.heroquest.map.generation.FileMapGenerator;
import br.unicamp.mc322.pf.heroquest.map.illuminator.BasicIlluminator;

public class HeroQuest {
	private Renderer renderer;
	private EntityManager entityManager;
	
	public HeroQuest(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void start() {
		entityManager = new EntityManager();
		Map world = new Map(new ClassicalMapGenerator(), new BasicIlluminator(), entityManager);
		//Map world = new Map(new FileMapGenerator(), new BasicIlluminator());
		renderer.setMap(world);
		renderer.renderWorld();
				
		runGameLoop();
	}
	
	private void runGameLoop() {
		while (true) {
			entityManager.nextTurn();
			
			// TODO: Maybe remove this delay. It´s ugly
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
			
			renderer.renderWorld();
		}
	}
}
