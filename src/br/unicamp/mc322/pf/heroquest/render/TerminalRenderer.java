package br.unicamp.mc322.pf.heroquest.render;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.map.Map;

public class TerminalRenderer extends Renderer {
	private Map map;
	private Hero hero;
	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	@Override
	protected void renderWorld() {
		if (map == null) 
			throw new IllegalStateException("Map is not set");
		
		map.CalculateIllumation();
		System.out.print(map);
	}

	@Override
	protected void renderInfo() {
		if (map == null) 
			throw new IllegalStateException("Map is not set");
		
		System.out.print("Class: " + hero.getType() + "   ");
		System.out.print("HP: " + hero.getCurrentHP() + "   ");
		System.out.print("Movements: " + hero.getRemainingMovementPoints() + "   ");
		if (!hero.getBackpack().isEmpty())
			System.out.print("Items: " + hero.getBackpack().toString() + "   ");
		System.out.println();
	}

	@Override
	public void renderEvent(String event) {
		System.out.println(event);
	}
	
	@Override
	public void askQuestion(String question, String[] options) {
		System.out.println(question);
		
		for (int i = 0; i < options.length; i ++) {
			System.out.print((i + 1) + "- ");
			System.out.println(options[i]);
		}
	}
}
