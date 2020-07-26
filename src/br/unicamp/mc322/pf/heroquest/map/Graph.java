package br.unicamp.mc322.pf.heroquest.map;

import java.util.*; 
import br.unicamp.mc322.pf.heroquest.map.Node;
import br.unicamp.mc322.pf.heroquest.utils.*;

public class Graph {
	private Node[][] graph;
	private Queue<Node> queue = new LinkedList<Node>();
	private Navigator navigator;
	
	public Graph(int dimensionX, int dimensionY, Navigator navigator) {
		graph = new Node[dimensionX][dimensionY];
		this.navigator = navigator;
		for(int i = 0; i < dimensionX; i++)
			for(int j = 0; j < dimensionY; j++)
				graph[i][j] = new Node(new Vector2(i, j));
	}
	
	public Node calculatePath(Vector2 from, Vector2 to) {
		Node node = graph[from.getX()][from.getY()];
		node.attributeFather(null);
		queue.add(node);
		boolean hasFound = false;
		int i;
		
		while(!hasFound) {
			node = queue.poll();
			for(i = 0; i < 4; i++) {
				hasFound = processRelativeNode(node, Direction.NORTH, to);
				hasFound = processRelativeNode(node, Direction.SOUTH, to);
				hasFound = processRelativeNode(node, Direction.EAST, to);
				hasFound = processRelativeNode(node, Direction.WEST, to);
			}
		}
		return node;
	}
	
	private boolean processRelativeNode(Node node, Direction direction, Vector2 objective) {
		Vector2 position = node.getRelativePosition(direction);
		if(position == objective)
			return true;
		if(navigator.isPassable(position)) {
			Node next = graph[position.getX()][position.getY()];
			if(!next.wasVisited()) {
				next.attributeFather(node);
				queue.add(next);
			}
		}
		return false;
	}
}
