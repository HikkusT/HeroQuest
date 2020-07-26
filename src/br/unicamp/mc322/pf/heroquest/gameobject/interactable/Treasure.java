package br.unicamp.mc322.pf.heroquest.gameobject.interactable;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Treasure extends Interactable {
	private Item[] content;
	private boolean isOpened;
	
	public Treasure(Vector2 position, Item[] items) {
		super(position);
		isOpened = false;
		content = items;
	}

	public void interact(InteractionType interaction, Hero user) {
		if (interaction == InteractionType.FINDTREASURE && !isOpened) {
			user.collectTreasure(content);
		}
		// TODO Possibility of summon a monster.
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
}
