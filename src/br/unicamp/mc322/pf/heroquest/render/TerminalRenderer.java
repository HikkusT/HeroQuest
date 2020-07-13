package br.unicamp.mc322.pf.heroquest.render;

import br.unicamp.mc322.pf.heroquest.map.Map;

public class TerminalRenderer extends Renderer {

	@Override
	public void renderWorld(Map map) {
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
