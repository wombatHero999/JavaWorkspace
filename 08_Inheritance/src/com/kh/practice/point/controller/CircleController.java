package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String caclcArea(int x , int y, int radius) {
		c.setRadius(radius);
		c.setX(x);
		c.setY(y);
		
		return "면적 : "+ c + " / "+ (Math.PI * c.getRadius() * c.getRadius());
	}
	
	public String calcCircum(int x, int y, int radius) {
		//둘레 : 2, 4, 1 / 6.28318530717958
		//c = new Circle(x , y , radius);
		c.setRadius(radius);
		c.setX(x);
		c.setY(y);
		
		return "둘레 : "+ c + " / "+ (Math.PI * c.getRadius() * 2);
	}
}
