package br.unicamp.mc322.pf.heroquest.gameobject;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class GameObject {
	protected Vector2 position;
	protected boolean isTranslucent;
	protected boolean isTransposable;
	

	public GameObject(Vector2 position, boolean isTranslucent, boolean isTransposable) {
		this.position = position;
		this.isTranslucent = isTranslucent;
		this.isTransposable = isTransposable;
	}

	public boolean getTranslucency() {
		return isTranslucent;
	}
	
	public boolean getTransposability() {
		return isTransposable;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public abstract String getSprite();
}
