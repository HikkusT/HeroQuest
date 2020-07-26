package br.unicamp.mc322.pf.heroquest.gameobject.interactable;
import java.util.Random;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.item.Item;
import br.unicamp.mc322.pf.heroquest.item.equipment.armor.ClothArmor;
import br.unicamp.mc322.pf.heroquest.item.equipment.armor.PlateArmor;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Dagger;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Excalibur;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.LongSword;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.ShortSword;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.StormBreaker;
import br.unicamp.mc322.pf.heroquest.item.equipment.weapon.Weapon;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public class Treasure extends Interactable {
	private static final boolean ISTRANSLUCENT = true;
	private static final boolean ISTRANSPOSABLE = true;
	private static final Item[] POSSIBLETREASURES= {new LongSword(), new ShortSword(), new Dagger(), new Excalibur(), new StormBreaker()
													, new ClothArmor(), new PlateArmor()};
	
	private Item content;
	private boolean isOpened;
	
	public Treasure(Vector2 position) {
		super(position, ISTRANSLUCENT, ISTRANSPOSABLE);
		isOpened = false;
		Item randomTreasure = POSSIBLETREASURES[new Random().nextInt(POSSIBLETREASURES.length)];
		content = randomTreasure;
		
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
