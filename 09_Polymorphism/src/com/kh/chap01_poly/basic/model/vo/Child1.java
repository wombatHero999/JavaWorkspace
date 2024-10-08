package com.kh.chap01_poly.basic.model.vo;

public class Child1 extends Parent{

	private int z;
	
	public Child1() {
		
	}
	
	public Child1(int z) {
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void printChild1() {
		System.out.println("자식1 클래스");
	}

	@Override
	public void print() {
		System.out.println("자식1이야~");
	}
	
	
	
	
	
	
	
	
	
}
