package br.unicamp.mc322.pf.heroquest.item.armor;

import br.unicamp.mc322.pf.heroquest.item.Equipable;
import br.unicamp.mc322.pf.heroquest.item.Item;

public abstract class Armor extends Item implements Equipable {

	private int defensePoints;
	public Armor(String itemName, int defensePoints) {
		super(itemName);
		this.defensePoints =  defensePoints;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unequip() {
		// TODO Auto-generated method stub

	}

}
