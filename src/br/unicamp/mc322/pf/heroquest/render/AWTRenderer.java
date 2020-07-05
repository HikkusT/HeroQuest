package br.unicamp.mc322.pf.heroquest.render;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;


// AWT is bad, this should be deprecated and changed to Swing
public class AWTRenderer extends Renderer {
	Frame gameWindow;
	Panel worldPanel;
	Panel infoPanel;
	Panel eventPanel;
	
	public AWTRenderer(int width, int height) {
		gameWindow = new Frame("HeroQuest");
		gameWindow.setSize(width, height);
		setupBasicWindowLayout();
		gameWindow.setVisible(true);
	}
	
	private void setupBasicWindowLayout() {
		gameWindow.setLayout(new GridLayout(1, 2));
		
		Panel gamePanel = new Panel();
		gameWindow.add(gamePanel);
		gamePanel.setLayout(new GridLayout(2, 1));
		worldPanel = new Panel();
		gamePanel.add(worldPanel);
		infoPanel = new Panel();
		gamePanel.add(infoPanel);
		
		eventPanel = new Panel();
		gameWindow.add(eventPanel);
	}
	
	@Override
	public void renderWorld() {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderEvent(String event) {
		eventPanel.add(new Label(event));
	}

}
