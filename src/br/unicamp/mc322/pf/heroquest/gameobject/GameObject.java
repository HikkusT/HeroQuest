package br.unicamp.mc322.pf.heroquest.gameobject;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class GameObject {
	protected Vector2 position;

	public GameObject(Vector2 position) {
		this.position = position;
	}
	
	public Vector2 getPosition() {
		return position;
	}
			
	public abstract boolean getTransposability();
	
	public abstract boolean getTranslucency();
	
	public boolean isVisible() {
		return true;
	}
	
	public abstract String getSprite();
}
