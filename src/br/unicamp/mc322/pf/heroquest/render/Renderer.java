package br.unicamp.mc322.pf.heroquest.render;

import br.unicamp.mc322.pf.heroquest.map.Map;

public abstract class Renderer {
	public abstract void setMap(Map map);
	
	public abstract void renderWorld();
	
	public abstract void renderInfo();
	
	public abstract void renderEvent(String event);
}
