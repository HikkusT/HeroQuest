package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.gameobject.entity.Entity;
import br.unicamp.mc322.pf.heroquest.gameobject.interactable.Interactable;

public class Tile {
	private TileType type;
	private boolean isVisible;
	private Entity entity;
	private Interactable interactable;
	
	public Tile() {
		this(TileType.FLOOR);
	}
	
	public Tile(Interactable interactable) {
		this();
		this.interactable = interactable;
	}
	
	public Tile(TileType type) {
		this.type = type;
		this.isVisible = false;
	}
	
	public void setVisibility(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public boolean getVisibility() {
		return this.isVisible;
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
		
		switch (type) {
		case WALL:
			return false;
		default:
			return true;
		}
	}
	
	public boolean isTranslucent() {	
		if (entity != null )
			return entity.getTranslucency();
		
		if (interactable != null)
			return interactable.getTranslucency();
		
		switch (type) {
		case WALL:
			return false;
		default:
			return true;
		}
		
	}
	
	public TileType getTileType() {
		//We have to define the final format of the tiles,
		return this.type;
		
	}
	
	public String getSprite() {
		if (!isVisible)
			return "Unlit.png";
		
		// TODO: Fix this
		if (interactable != null) {
			return "Door.png";
		}
		
		switch (type) {
		case WALL:
			return "Wall.png";
		default:
			return "Floor.png";
		}
	}
	
	@Override
	public String toString() {
		if (!this.isVisible)
			return " ";
		
		switch (type) {
		case WALL:
			return "#";
		default:
			return ".";
		}
	}
}
