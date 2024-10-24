package com.kh.chap01_innerClass.run;

import com.kh.chap01_innerClass.part01_instance.OuterClass;

public class Run {
	public static void main(String[] args) {
		/* 
		 * 내부클래스?
		 * 클래스 "내부"에 선언한 클래스
		 * 내부클래스는 외부클래스와 밀접한 관련이 있으면서, 그 밖에 다른 클래스들과는 서로 사용할 일이 없는 경우
		 * 내부클래스로 선언하여 사용한다.
		 * 
		 * 내부클래스의 종류?
		 * 1) 인스턴스 내부 클래스
		 * 2) 정적 내부 클래스
		 * 3) 지역 내부 클래스
		 * 4) 익명 내부 클래스
		 * 
		 * */
		OuterClass oc = new OuterClass();
		//OuterClass.Inner oci  = oc.new Inner(); 
		oc.outerMethod();
		
		
		
	}
	
	
	
}
