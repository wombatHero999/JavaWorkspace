package com.kh.chap01_innerClass.part03_local;

public class OuterClass {
	/* 
	 * 3) 지역 내부 클래스
	 *  - 지역변수처럼 "메서드"내부에서 클래스를 정의하여 사용하는 클래스
	 *  - 이렇게 생성된 클래스는 메서드 안에서만 사용가능.
	 *  - 지역내부클래스안에서 지역변수는 final예약어가 붙은 것처럼 취급된다.(상수)
	 * 
	 * 복습
	 *  1. 메서드 호출시 스택메모리에는 호출된 메소드가 쌓이며, 스택프레임 안에는 지역변수를 위한 저장공간이 할당됨. 
	 *     메소드가 종료되면, 메소드가 스택에서 제거되며 스택프레임 안에 있던 지역변수들도 메모리에서 삭제된다.
	 *      * 스택프레임(매개변수정보, 지역변수정보, 반환되는 위치정보, 반환형정보 등이 저장)
	 *  2. static키워드가 붙은 필드는 static메모리에 저장공간을 할당받음.
	 *     static final(상수)키워드가 붙은 필드는 static메모리 안에서 상수풀에 저장공간이 할당된다.
	 *     final 키워드만 붙은 필드도 상수풀에 저장공간을 할당받는다.
	 * */
	
	private String outerStr = "외부클래스 필드";
	private static String staticOuterStr = "외부클래스의 정적 필드";
	
	// Runnable인터페이스를 구현한 지역내부클래스를 반환.
	public Runnable getRunnable(int num) {
		int localVar = 1; 
		//localVar = 2;
		
		// 지역내부클래스. -> 지역변수와 동일한 생명주기를 가지고 있음.
		class LocalInnerClass implements Runnable{
			int localNum = 10;// 지역내부클래스의 필드.
			
			@Override
			public void run() {
				System.out.println(localVar);
				//localVar = 2;
				//num = 2;
				/* 
				 * 1) 메서드는 종료시 스택영역에서 제거가된다.
				 * 2) 메서드 안에는 지역변수가 들어가 있다.
				 * 3) 지역내부클래스에서 이 지역변수를 사용하려고 할때, 만약 삭제된 스택영역의 메모리주소를 찾아
				 *    가려고 하면 에러가 날것이다.
				 * 4) 그럼 지역내부클래스에서 지역변수를 사용하려고 하는 순간 지역변수를 상수풀로 이동시키면 된다.
				 * */
				outerStr =" 123 ";
				System.out.println(outerStr);
				System.out.println(staticOuterStr);
				System.out.println(localNum);
			}
		}
		return new LocalInnerClass();
	}
	
	
	
	
	
	
	
	
	
	
}
