package br.unicamp.mc322.pf.heroquest.render;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.map.Map;

public abstract class Renderer {
	public abstract void setMap(Map map);
	
	public abstract void setHero(Hero hero);
	
	public final void update() {
		renderWorld();
		renderInfo();
	}
	
	protected abstract void renderWorld();
	
	protected abstract void renderInfo();
	
	public abstract void renderEvent(String event);
	
	public abstract void askQuestion(String question, String[] options);
}
