package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class SquareController {
	
	private Shape s = new Shape();
	
	public double calcPerimeter(double height, double width) {
		//둘레: 너비*2 + 높이*2
		s = new Shape(4, height , width);
		return s.getWidth() *2 + s.getHeight() * 2;
	}
	
	public double calcArea(double height, double width) {
		//이 : 너비 * 높이
		s = new Shape(4, height , width);
		return s.getWidth() * s.getHeight();
	}
	
	public void paintColor(String color) {
		s.setColor(color);		
	}
	
	public String print() {
		return "사각형"+s.information();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
