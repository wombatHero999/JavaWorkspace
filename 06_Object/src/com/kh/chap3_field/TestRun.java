package com.kh.chap3_field;

public class TestRun {
	
	public static void main(String[] args) {
		FieldTest2 ft2 = new FieldTest2();
		
		// 어디서든 접근가능
		System.out.println(ft2.pub);
		
		// protected => 같은패키지에서만 접근가능. 다른 패키지에서는 접근 불가
		System.out.println(ft2.pro);
		
		// default  => 같은패키지에서만 접근가능. 다른 패키지에서는 접근 불가
		System.out.println(ft2.def);
		
	}
	
	
}







