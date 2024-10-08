package com.kh.hw.person.model.vo;

public class Person {

	private String name;
	private int age;
	private double height;
	private double weitht;

	public Person() {

	}

	public Person(String name, int age, double height, double weitht) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weitht = weitht;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeitht() {
		return weitht;
	}

	public void setWeitht(double weitht) {
		this.weitht = weitht;
	}
	

	@Override
	public String toString() {
		return name+", "+age+", "+height+", "+weitht;
	}

}
