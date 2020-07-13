package br.unicamp.mc322.pf.heroquest.item;

public abstract class Item {
	private String itemName;
	
	protected Item(String itemName){
		this.itemName = itemName;
	}
	
	
	public String getItemName() {
		return this.itemName;
	}

}