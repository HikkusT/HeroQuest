package br.unicamp.mc322.pf.heroquest;

import br.unicamp.mc322.pf.heroquest.render.*;
import br.unicamp.mc322.pf.heroquest.map.*;
import br.unicamp.mc322.pf.heroquest.map.generation.ClassicalMapGenerator;
import br.unicamp.mc322.pf.heroquest.map.generation.FileMapGenerator;
import br.unicamp.mc322.pf.heroquest.map.illuminator.BasicIlluminator;

public class HeroQuest {
	Renderer renderer;
	
	public HeroQuest(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void start() {
		Map world = new Map(new ClassicalMapGenerator(), new BasicIlluminator());
		//Map world = new Map(new FileMapGenerator(), new BasicIlluminator());
		renderer.setMap(world);
		renderer.renderWorld();
				
		while (true) {
		}
	}
}
