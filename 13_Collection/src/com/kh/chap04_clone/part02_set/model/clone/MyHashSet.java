package com.kh.chap04_clone.part02_set.model.clone;

import java.util.HashMap;

public class MyHashSet <T> {
	
	private HashMap<T, Boolean> map;
	
	public MyHashSet() {
		map = new HashMap<>();
	}
	
	public void add(T s) {
		map.put(s, true);
	}
	
	public void remove(T s) {
		map.remove(s);
	}
	
	public boolean contains(T s) {
		return map.containsKey(s);
	}
	
	public int size() {
		return map.size();
	}
	
	public void printAll() {
		for( T s  : map.keySet() ) {
			System.out.println(s);
		}
	}
	
	
}
