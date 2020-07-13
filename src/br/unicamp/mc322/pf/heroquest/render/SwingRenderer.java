package br.unicamp.mc322.pf.heroquest.render;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unicamp.mc322.pf.heroquest.map.Map;

public class SwingRenderer extends Renderer {
	JFrame gameWindow;
	JPanel worldPanel;
	JPanel infoPanel;
	JPanel eventPanel;
	
	public SwingRenderer(int width, int height) {
		gameWindow = new JFrame("HeroQuest");
		gameWindow.setSize(width, height);
		setupBasicWindowLayout();
		gameWindow.setVisible(true);
	}
	
	private void setupBasicWindowLayout() {
		gameWindow.setLayout(new GridLayout(1, 2));
		
		JPanel gamePanel = new JPanel();
		gameWindow.add(gamePanel);
		gamePanel.setLayout(new GridLayout(2, 1));
		worldPanel = new JPanel();
		gamePanel.add(worldPanel);
		infoPanel = new JPanel();
		gamePanel.add(infoPanel);
		
		eventPanel = new JPanel();
		gameWindow.add(eventPanel);
		eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
	}
	
	@Override
	public void renderWorld(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderEvent(String event) {
		eventPanel.add(new JLabel(event));
	}

}
