package com.kh.chap3_field;

/* 
 * 변수의 구분
 * - 전역변수 : 클래스 영역에 바로 선언하는 변수 => 클래스 내에서면 어디든 사용 가능.
 * - 지역변수 : 클래스 영역 내에 특정한 구역({})에 선언한 변수 => 선언한 지역에서만 사용 가능.
 *            ex) 메서드, if, for, switch...
 *            
 * 1. 전역변수(2가지로 구분이됨)
 *  - 멤버변수 == 인스턴스변수 == 필드
 *    생성시점 : 객체 생성시 메모리 영역에 저장공간이 할당.
 *    소멸시점 : 객체 소멸시 함께 소멸
 * 
 *  - 클래스 변수 == static 변수 : static이라는 예약어가 붙어 있는 필드.
 *    생성시점 : 프로그램 시작과 동시에 생성
 *    소멸시점 : 프로그램 종료시 소멸
 *  
 *  2. 지역변수
 *     생성시점 : 특정 구역({})이 실행될때 메모리에 영역이 할당
 *     소멸시점 : 특정 구역({})이 끝날때 소멸
 * */

// 변수 선언 위치에 따른 구분
public class FieldTest1 {
	
	private int globalInt;// 필드 == 인스턴스변수 == 멤버변수
	
	public void test(int num) { // 매개변수 == 지역변수
		
		// 지역변수
		int localNum = 0;
		
		if(true) {
			int ifNum = 0;
			
			System.out.println(ifNum);
		}
		// System.out.println(ifNum); // if블럭 종료로 에러발생
		
		System.out.println(globalInt); // 0 -> JVM이 객체 생성시 값을 자동으로 초기화.
		
		System.out.println(localNum);
		
		System.out.println(num);//현재 메서드를 호출하기 위해서는 반드시 값을 넘겨줘야 호출이 가능하기때문에.
		
	}
	
	
	
	
	
	
	
	
	
}

