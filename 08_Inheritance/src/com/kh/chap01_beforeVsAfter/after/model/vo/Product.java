package com.kh.chap01_beforeVsAfter.after.model.vo;

// 세 클래스 모두 사용했던 공통속성 & 기능들을 정의
public class Product {
	
//	private String brand;
//	private String pCode;
//	private String pName;
//	private int price;
	
	protected String brand;
	protected String pCode;
	protected String pName;
	protected int price;
	
	public Product() {
		
	}

	public Product(String brand, String pCode, String pName, int price) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String information() {
		return brand+", "+pCode+", "+pName+", "+price;
	}
	
}
