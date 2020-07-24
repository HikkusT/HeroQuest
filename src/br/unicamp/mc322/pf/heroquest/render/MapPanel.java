package br.unicamp.mc322.pf.heroquest.render;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.unicamp.mc322.pf.heroquest.map.Map;
import br.unicamp.mc322.pf.heroquest.map.Tile;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class MapPanel extends JPanel {
	private final String imgPath = "images/";
	private final int spriteSize = 16;
	private Map map;
	
	public MapPanel(Map map) {
		setMap(map);
	}
	
	public void setMap(Map map) {
		this.map = map;
		Vector2 newSize = map.getDimension();
		setPreferredSize(new Dimension(newSize.getX() * spriteSize, newSize.getY() * spriteSize));
		System.out.println(getWidth());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		renderMap(g);
	}
	
	private void renderMap(Graphics g) {
		if (map == null) 
			throw new IllegalStateException("Map is not set");
		
		// map.CalculateIllumation();
		Tile[][] tileMap = map.prepareToRender();
		for (int i = 0; i < tileMap.length; i ++) {
			for (int j = 0; j < tileMap[0].length; j ++) {
				ImageIcon sprite = new ImageIcon(imgPath + tileMap[i][j].getSprite());
				g.drawImage(sprite.getImage(), spriteSize * j, spriteSize * i, null);
			}
		}
	}
}
