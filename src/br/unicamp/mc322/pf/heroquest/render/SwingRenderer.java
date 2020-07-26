package br.unicamp.mc322.pf.heroquest.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.input.SwingInput;
import br.unicamp.mc322.pf.heroquest.map.Map;

public class SwingRenderer extends Renderer {
	private SwingInput swingInput;
	private JFrame gameWindow;
	private MapPanel mapPanel;
	private HeroPanel infoPanel;
	private JPanel eventPanel;
	private JScrollPane scroll;
	
	public SwingRenderer(SwingInput swingInput) {
		this.swingInput = swingInput;
		gameWindow = new JFrame("HeroQuest");
		gameWindow.addKeyListener(swingInput);
		setupBasicWindowLayout();
		gameWindow.setVisible(true);
	}
	
	public void setMap(Map map) {
		if (mapPanel == null) {
			mapPanel = new MapPanel(map);
			GridBagConstraints c = new GridBagConstraints();
			//c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.weightx = 0.66;
			gameWindow.add(mapPanel, c);
		} else {
			mapPanel.setMap(map);
		}
		gameWindow.pack();
	}
	
	public void setHero(Hero hero) {
		if (infoPanel == null) {
			infoPanel = new HeroPanel(hero);
			infoPanel.setPreferredSize(new Dimension(300, 75));
			infoPanel.setBackground(new Color(133, 153, 0));
			infoPanel.setBorder(new EmptyBorder(new Insets(10, 10, 30, 10)));
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			gameWindow.add(infoPanel, c);
		}
		gameWindow.pack();
	}
	
	private void setupBasicWindowLayout() {
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setLayout(new GridBagLayout());
		
		eventPanel = new JPanel();
		eventPanel.setBackground(new Color(0, 43, 54));
		eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
		eventPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		eventPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		scroll = new JScrollPane(eventPanel);
		scroll.setPreferredSize(new Dimension(300, 10));
		scroll.setBackground(new Color(0, 43, 54));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(eventPanel);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		c2.gridx = 1;
		c2.gridy = 0;
		c2.gridwidth = 1;
		c2.gridheight = 2;
		c2.weightx = 2;
		gameWindow.add(scroll, c2);
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
		newEntry.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		//newEntry.setFont(new Font("Serif", Font.PLAIN, 14));
		newEntry.setForeground(new Color(255, 246, 227));
		eventPanel.add(newEntry);
		eventPanel.add(Box.createVerticalStrut(3));
		gameWindow.pack();
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
	}
	
	@Override
	public void askQuestion(String question, String[] options) {
		int answer = JOptionPane.showOptionDialog(
			gameWindow, 
			question, 
			"Dialog",
			JOptionPane.DEFAULT_OPTION, 
			JOptionPane.QUESTION_MESSAGE, 
			null,
			options,
			options[0]);
		swingInput.setOption(answer);
	}

}
