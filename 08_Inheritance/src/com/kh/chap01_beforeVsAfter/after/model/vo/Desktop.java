package com.kh.chap01_beforeVsAfter.after.model.vo;

public class Desktop extends Product{
	private boolean allInOne;
	
	// 기본생성자
	public Desktop() {
		//super();
	}
	
	// 매개변수생성자
	public Desktop(String brand, String pCode, String pName, int price,  boolean allInOne) {
		super(brand, pCode, pName, price);
		this.allInOne = allInOne;
	}
	
	// get/set
	public boolean isAllInOne() {
		return allInOne;
	}
	
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	// information함수
	public String information() {
		return super.information()+", "+allInOne;
	}
	
}
