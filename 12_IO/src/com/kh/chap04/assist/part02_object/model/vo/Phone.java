package com.kh.chap04.assist.part02_object.model.vo;

import java.io.Serializable;

public class Phone implements Serializable{
	
	// 기본생성자, 매개변수생성자, get/set , toString
	private static final long serialVersionUID = 1000L;
	
	//transient : 객체 입출력 스트림에서 해당값을 전송하지 않게 하는 예약어
	private transient String name;
	private int price;
	private String brand;
	
	public Phone() {
		
	}

	public Phone(String name, int price, String brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
