package com.kh.chap01_constant.model.vo;

import com.kh.chap01_constant.model.constant.CarColor;

public class Car {
	private String name;
	private int color;
	
	private CarColor carColor;
	
	public Car() {

	}
	
	public Car(String name, int color) {
		super();
		this.name = name;
		this.color = color;
	}

	public CarColor getCarColor() {
		return carColor;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

}
