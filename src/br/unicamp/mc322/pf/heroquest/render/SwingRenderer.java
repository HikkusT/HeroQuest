package br.unicamp.mc322.pf.heroquest.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.unicamp.mc322.pf.heroquest.map.Map;

public class SwingRenderer extends Renderer {
	JFrame gameWindow;
	MapPanel mapPanel;
	JPanel infoPanel;
	JPanel eventPanel;
	
	public SwingRenderer(int width, int height) {
		gameWindow = new JFrame("HeroQuest");
		gameWindow.setSize(width, height);
		setupBasicWindowLayout();
		gameWindow.setVisible(true);
	}
	
	public void setMap(Map map) {
		if (mapPanel == null) {
			mapPanel = new MapPanel(map);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 2;
			c.gridheight = 2;
			c.weightx = 1;
			c.weighty = 1;
			gameWindow.add(mapPanel, c);
		} else {
			mapPanel.setMap(map);
		}
		gameWindow.pack();
	}
	
	private void setupBasicWindowLayout() {
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setLayout(new GridBagLayout());
		
		
		////gameWindow.setLayout(new GridLayout(1, 2));
		//gameWindow.setLayout(new FlowLayout());
		
		//gamePanel = new JPanel();
		//gamePanel.setBackground(Color.GREEN);
		//gameWindow.add(gamePanel);
		//gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		////mapPanel = new MapPanel();
		////gamePanel.add(mapPanel);
		////infoPanel = new JPanel();
		////gamePanel.add(infoPanel);
		
		eventPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(eventPanel);
		gameWindow.getContentPane().add(scrollPane);
		eventPanel.setPreferredSize(new Dimension(200, 10));
		eventPanel.setBackground(new Color(0, 43, 54));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.weightx = 0.5;
		c.weighty = 1;
		gameWindow.add(eventPanel, c);
		eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
		//Box.createHorizontalStrut(300);
	}
	
	@Override
	public void renderWorld() {
		mapPanel.repaint();
	}

	@Override
	public void renderInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderEvent(String event) {
		JLabel newEntry = new JLabel(event);
		newEntry.setAlignmentX(0.2f);
		//newEntry.setFont(new Font("Serif", Font.PLAIN, 14));
		newEntry.setForeground(new Color(255, 246, 227));
		eventPanel.add(newEntry);
		eventPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		gameWindow.pack();
	}

}
