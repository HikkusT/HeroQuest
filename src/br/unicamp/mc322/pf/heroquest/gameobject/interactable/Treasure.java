package br.unicamp.mc322.pf.heroquest.gameobject.interactable;
import java.util.Random;

import br.unicamp.mc322.pf.heroquest.HeroQuest;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.item.equipment.armor.ClothArmor;
import br.unicamp.mc322.pf.heroquest.item.equipment.armor.PlateArmor;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Dagger;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Excalibur;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.LongSword;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.StormBreaker;
import br.unicamp.mc322.pf.heroquest.item.potion.GreatHealthPotion;
import br.unicamp.mc322.pf.heroquest.item.potion.MinorHealthPotion;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Treasure extends Interactable {
	private static final Item[] POSSIBLETREASURES= {new LongSword(), new ShortSword(), new Dagger(), new Excalibur(), new StormBreaker()
													, new ClothArmor(), new PlateArmor(), new MinorHealthPotion(), new GreatHealthPotion()};
	
	private Item content;
	private boolean isOpened;
	
	public Treasure(Vector2 position) {
		super(position);
		isOpened = false;
		Item randomTreasure = POSSIBLETREASURES[new Random().nextInt(POSSIBLETREASURES.length)];
		content = randomTreasure;
		
	}

	public void interact(InteractionType interaction, Hero user) {
		if (interaction == InteractionType.FIND_TREASURE && !isOpened) {
			HeroQuest.getInstance().getRenderer().renderEvent("You found a treasure! It has a " + content.toString());
			user.collectTreasure(content);
			isOpened = true;
		}
		// TODO Possibility of summon a monster.
	}
	
	@Override
	public boolean isVisible() {
		return !isOpened;
	}
	
	@Override
	public String getSprite() {
		// TODO Auto-generated method stub
		return "Treasure.png";
	}
	
	@Override
	public String toString() {
		return "t";
	}
}
