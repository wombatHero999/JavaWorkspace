package com.kh.chap3_field.run;

import com.kh.chap3_field.FieldTest1;
import com.kh.chap3_field.FieldTest2;
import com.kh.chap3_field.FieldTest3;

public class Run {
	public static void main(String[] args) {
		//1. FieldTest1
		FieldTest1 ft1 = new FieldTest1();
		ft1.test(12345);
		
		//2. FieldTest2
		FieldTest2 ft2 = new FieldTest2();
		System.out.println(ft2.pub);
		
		System.out.println(Math.random());
		
		//3.FieldTest3
		// static변수 호출방법
		// 클래스명.static변수명
		// 클래스명.static메서드명
		
		//FieldTest3 ft3 = new FieldTest3();
		System.out.println(FieldTest3.sta);
		//System.out.println(ft3.sta);
		FieldTest3.test();
		
		
	}
	
	
	
	
	
	
	
	
	
}
