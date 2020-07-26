package br.unicamp.mc322.pf.heroquest.render;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;

public class HeroPanel extends JPanel {
	private Hero hero;
	private JPanel holder;
	private JLabel name;
	private JLabel hp;
	private JLabel movement;
	
	HeroPanel(Hero hero) {
		this.hero = hero;
		holder = new JPanel();
		holder.setBackground(new Color(133, 153, 0));
		holder.setLayout(new FlowLayout());
		holder.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		name = new JLabel();
		name.setForeground(new Color(255, 246, 227));
		hp = new JLabel();
		hp.setForeground(new Color(255, 246, 227));
		movement = new JLabel();
		movement.setForeground(new Color(255, 246, 227));
		holder.add(name);
		holder.add(hp);
		holder.add(movement);
		add(holder);
	}
	
	void setHero(Hero hero) {
		this.hero = hero;
		updateInfo();
	}
	
	void updateInfo() {
		name.setText("Class: " + hero.getType().toString());
		hp.setText("HP: " + hero.getCurrentHP());
		movement.setText("Movements: " + hero.getRemainingMovementPoints());
		
		revalidate();
		repaint();
	}
}
