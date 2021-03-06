package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.entity.hero.Hero;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.Interactable;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.InteractionType;

public class Tile {
	private TileType type;
	private boolean isVisible;
	private Entity entity;
	private Interactable interactable;

	public Tile() {
		this(TileType.FLOOR);
	}

	public Tile(Interactable interactable) {
		this(TileType.FLOOR);
		this.interactable = interactable;
	}

	public Tile(TileType type) {
		this.type = type;
		this.isVisible = true;
	}

	public void receiveEntity(Entity entity) {
		// TODO: check if it is transposable instead
		if (hasEntity()) {
			throw new IllegalStateException("Trying to spawn an entity on already occupied tile");
		}

		this.entity = entity;
	}
	
	public void addInteractable(Interactable interactable) {
		if (this.interactable == null) {
			this.interactable = interactable;
		}
	}

	public boolean hasEntity() {
		return entity != null;
	}

	public Entity getEntity() {
		return entity;
	}

	public void interact(InteractionType type, Hero source) {
		if (interactable != null) {
			interactable.interact(type, source);
		}
	}
	
	public void illuminate() {
		this.isVisible = true;
	}
	
	public void blackOut() {
		this.isVisible = false;
	}
	
	public boolean isIlluminated() {
		return isVisible;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public void removeEntity() {
		this.entity = null;
	}


	public boolean isTransposable() {

		if (entity != null )
			return entity.getTransposability();

		if (interactable != null)
			return interactable.getTransposability();

		return type.isTransposable();
	}

	public boolean isTranslucent() {
		if (entity != null )
			return entity.getTranslucency();

		if (interactable != null)
			return interactable.getTranslucency();

		return type.isTranslucent();
	}

	public TileType getTileType() {
		//We have to define the final format of the tiles,
		return this.type;
	}

	public String getSprite() {
		if (!isVisible)
			return "Unlit.png";

		if (entity != null && entity.isVisible()) {
			return entity.getSprite();
		}

		if (interactable != null && interactable.isVisible()) {

			return interactable.getSprite();
		}

		return type.getSprite();
	}

	@Override
	public String toString() {
		if (!this.isVisible)
			return " ";
		
		if (entity != null && entity.isVisible()) {
			return entity.toString();
		}

		if (interactable != null && interactable.isVisible()) {

			return interactable.toString();
		}

		return type.toString();
	}
}
