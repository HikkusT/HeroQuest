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
	
	HeroPanel(Hero hero) {
		this.hero = hero;
		holder = new JPanel();
		holder.setBackground(new Color(133, 153, 0));
		holder.setLayout(new FlowLayout());
		holder.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		name = new JLabel("Class: ");
		name.setForeground(new Color(255, 246, 227));
		hp = new JLabel("HP: ");
		hp.setForeground(new Color(255, 246, 227));
		holder.add(name);
		holder.add(hp);
		add(holder);
	}
	
	void setHero(Hero hero) {
		this.hero = hero;
		updateInfo();
	}
	
	void updateInfo() {
		
	}
}
