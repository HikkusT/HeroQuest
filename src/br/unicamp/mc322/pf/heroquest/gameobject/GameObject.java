package br.unicamp.mc322.pf.heroquest.gameobject;
import br.unicamp.mc322.pf.heroquest.utils.Vector2;

public abstract class GameObject {
	private Vector2 position;
	protected boolean isTranslucent;
	

	public GameObject(Vector2 position, boolean isTranslucent) {
		this.position = position;
		this.isTranslucent = isTranslucent;
	}

	public void setIsTranslucent(boolean isTranslucent){
		this.isTranslucent = isTranslucent;
	}
}
