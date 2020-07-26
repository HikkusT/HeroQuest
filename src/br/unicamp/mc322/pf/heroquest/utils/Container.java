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
	
	public T getObjectAtIndex(int i) {
		return container.get(i);
	}
	
	public void printContainer() {
		for (T object : container) {
			System.out.println(object);
		}
	}
}
