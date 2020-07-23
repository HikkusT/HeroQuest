package br.unicamp.mc322.pf.heroquest.item;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;

public interface Equipable {
	public void equip(Entity entity);
	public void unequip(Entity entity);
}
