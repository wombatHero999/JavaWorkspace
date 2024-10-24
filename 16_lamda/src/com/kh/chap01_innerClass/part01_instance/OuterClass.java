package com.kh.chap01_innerClass.part01_instance;

public class OuterClass {
	
	private String outerStr = "외부클래스 필드"; // 필드 == 멤버변수 == 인스턴스 필드
	private static String staticOuterStr = "외부클래스의 스태틱 변수";
	private Inner innerClass;
	/* 
	 * 1) 인스턴스 내부 클래스
	 *  - 필드와 같은 위치에서 선언하므로 인스턴스 내부클래스라고 부른다.
	 *  - 현재 클래스(OuterClass)에서만 생성하여 사용하는 객체를 선언할때 쓴다.
	 *  - 인스턴스 내부 클래스를 생성하여 사용할때는 일반적으로 외부클래스의 생성자 안에서 객체를 생성하는 방식을 사용한다.  
	 *  - 외부클래스의 "보조"적인 역할의 클래스를 정의할때나 2중 캡슐화로 정보은닉을 고도화하고자 할때 쓴다.
	 *  ex) HashMap에서 Node의 역할이 인스턴스 내부 클래스.
	 * */
	private class Inner{
		//내부 클래스의 영역
		int num = 100; // 내부클래스의 필드.
		static int sNum = 100; // 내부클래스의 스태틱변수.
		
		private void privateInnerMethod() {
			// Inner내부에서만 사용 가능한 메서드.
			System.out.println(outerStr);// 내부클래스에서는 외부클래스의 필드 사용이 가능.
			System.out.println(staticOuterStr);
		}
	}
	
	// 기본생성자
	public OuterClass() {
		innerClass = new Inner();
	}
	
	public void outerMethod() {
		// 내부클래스는 외부클래스에 포함되어있으므로 private접근제한자 이지만 호출이 가능.
		innerClass.privateInnerMethod();
	}
	
	
	
	
	
}
