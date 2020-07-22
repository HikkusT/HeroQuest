package br.unicamp.mc322.pf.heroquest.render;

import br.unicamp.mc322.pf.heroquest.map.Map;

public class TerminalRenderer extends Renderer {
	private Map map;
	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public void renderWorld() {
		if (map == null) 
			throw new IllegalStateException("Map is not set");
		
		map.CalculateIllumation();
		System.out.print(map);
	}

	@Override
	public void renderInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderEvent(String event) {
		System.out.println(event);
	}
}
