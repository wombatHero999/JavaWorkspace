package com.kh.example.practice3.model.vo;

public class Circle {
	private final double PI = 3.14;
	private int radius = 1;
	
	public Circle() {
		
	}
	
	public void incrementRadius() {
		radius++;
	}
	
	// 반지름 * 2 * pi
	public void getAreaOfCircle() {
		System.out.println(radius * 2 * PI);
	}
	
	// 반 * 반 * pi
	public void getSizeOfCircle() {
		System.out.println(radius * radius * PI);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
