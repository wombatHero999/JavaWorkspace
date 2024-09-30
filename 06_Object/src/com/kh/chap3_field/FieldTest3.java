package com.kh.chap3_field;

//static
public class FieldTest3 {
	
	public static String sta = "static변수";
	
	/* 
	 * static은 '정적인, 고정된, 움직이지 않는'이라는 의미를 가짐.
	 * 즉, static키워드는 특정 변수나 메서드를 메모리에 "고정"시켜둔다.
	 * 이렇게 static영역에 고정된 데이터는 모든 객체에서 "공유"할 수 있다.
	 * 
	 * 생성시점 : 프로그램 시작과 동시에 메모리의 static영역에 할당됨.
	 * 소멸시점 : 프로그램 종료시 소멸.
	 * 
	 * */
	
	/* 
	 * 상수필드와 함께 자주 사용
	 * public static final 자료형 변수명 = 값;
	 * 
	 * static : 공유 및 재사용의 개념
	 * final  : 한번 지정된 값을 변경하지 않음(상수)
	 * 
	 * 값이 변경되서는 안되는 어떤 고정적인 값을 메모리에 올려두고 공유하면서 사용하는 목적
	 * */
	private FieldTest3() {
		
	}
	
	public static final int NUM = 10;
	
	public static void test() {
		System.out.println("안녕");
	}
	
	
}
