package br.unicamp.mc322.pf.heroquest.item.equipment.armor;

public class ClothArmor extends Armor {
	private final static String NAME = "Cloth Armor";
	private final static int DEFENSEPOINTS = 1;
	
	public ClothArmor() {
		super(NAME, DEFENSEPOINTS);
	}
	
	@Override
	public String toString() {
		return NAME;
	}

}
