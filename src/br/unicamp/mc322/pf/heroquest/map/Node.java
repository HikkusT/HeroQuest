package br.unicamp.mc322.pf.heroquest.map;

import br.unicamp.mc322.pf.heroquest.utils.*;

public class Node {
	private Vector2 position;
	private Node father;
	boolean visited;
	
	Node(Vector2 position) {
		this.position = position;
		visited = false;
	}
	
	boolean wasVisited() {
		return visited;
	}
	
	void attributeFather(Node node) {
		father = node;
		visited = true;
	}
	
	Node getFather() {
		return father;
	}
	
	Vector2 getPosition() {
		return position;
	}
	
	Vector2 getRelativePosition(Direction direction) {
		return Vector2.sum(position, direction.toVector2());
	}
}
