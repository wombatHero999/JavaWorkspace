package com.kh.chap01_innerClass.part02_static;

public class OuterClass {
	
	/* 
	 * 2) 정적 내부 클래스
	 *  - 인스턴스 내부 클래스에서 사용하기 힘든 static필드 및 메소드를 쉽게 사용할 수 있는 클래스.
	 *  - 외부클래스가 로드되는 시점에 정적 내부 클래스는 static영역에 저장공간을 할당 받는다.
	 *    즉, 외부클래스에 종속적이지 않다.
	 *  - 하나의 클래스파일을 통해 각종 클래스를 설계하고 객체를 생성할 수 있다.
	 *  - 외부클래스와 무관하게 다른 클래스에도 정적내부클래스를 사용할 수 있다.
	 *  ex) Builder패턴, DTO(Data Transfer Object)등을 정의할때 자주 사용된다.
	 * */
	
	private String oStr = "외부클래스 필드"; 
	private static String staticOstr = "외부클래스의 스태틱 변수";
	
	
	public static class StaticInner { // 정적 내부 클래스 -> 외부클래스명.내부클래스명
		int num = 100;
		static int num2 = 100; // OuterClass.StaticInner.num2
		
		void test() {
			System.out.println(staticOstr);
			// System.out.println(oStr); // 객체 생성시점이 다르므로
		}
		
		// OuterClass.StaticInner.sTest()
		public static void sTest() {
			//System.out.println(num); // num은 StaticInner객체가 생성되어야 메모리에 저장공간할당
			System.out.println(num2); // num2는 객체를 생성하지 않아도 static에 저장공간이 준비됨.
		}
	}
	

	
	
	
	
	
}
