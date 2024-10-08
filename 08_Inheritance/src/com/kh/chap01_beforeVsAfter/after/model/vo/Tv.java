package com.kh.chap01_beforeVsAfter.after.model.vo;

//           자식           부모 
//           후손           조상
//           하위           상위
public class Tv extends Product {
	
	private int inch;
	
	public Tv() {
		super();
	}
	
	public Tv(String brand, String pCode, String pName, int price,  int inch) {
		// 부모클래스의 필드값을 초기화 하기 위한 방법 
		// 1. 부모클래스의 필드를 protected로 변경
//		this.brand = brand;		
//		this.pCode = pCode;
//		this.pName = pName;
//		this.price = price;
		
		// 2. 부모클래스의 setter함수 호출
//		super.setBrand(brand);
//		super.setpCode(pCode);
//		super.setpName(pName);
//		super.setPrice(price);
		
		// 3. 부모클래스의 매개변수 생성자 호출
		super(brand,pCode,pName,price);
		
		this.inch = inch;
	}
	
	// 메소드 오버라이딩 : 부모클래스의 메소드를 내 입맛대로 재정의
	public String information() {
		//return getBrand()+", "+getpCode()+", "+getpName()+", "+getPrice()+", "+inch;
		return super.information()+", "+inch;
	}
	
	
}
