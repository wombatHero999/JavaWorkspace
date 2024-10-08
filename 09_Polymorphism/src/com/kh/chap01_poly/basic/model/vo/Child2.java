package com.kh.chap01_poly.basic.model.vo;

public class Child2 extends Parent {
	
	private int n;
	
	public Child2() {
		
	}
	
	public Child2(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public void printChild2() {
		System.out.println("자식2 클래스");
	}
	
	@Override
	public void print() {
		System.out.println("자식2!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
