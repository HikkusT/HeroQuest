package br.unicamp.mc322.pf.heroquest.utils;

import java.util.ArrayList;

public class Container<T> {
	ArrayList<T> container;
	
	public Container() {
		container = new ArrayList<T>();		
	}
	
	public void addObject(T object) {
		container.add(object);
	}
	
	public void removeObject(T object) {
		container.remove(object);
	}
	public boolean isEmpty() {
		return container.isEmpty();
	}
	
	public int size() {
		return container.size();
	}
	
	public String[] asOptions() {
		String[] options = new String[container.size()];
		for (int i = 0; i < container.size(); i++) {
			options[i] = container.get(i).toString();
		}
		
		return options;
	}
	
	public T getObjectAtIndex(int i) {
		return container.get(i);
	}
	
	@Override
	public String toString() {
		String bag = "";
		for (T object : container) {
			bag += object.toString() + ", ";
		}
		
		return bag.trim();
	}
}
