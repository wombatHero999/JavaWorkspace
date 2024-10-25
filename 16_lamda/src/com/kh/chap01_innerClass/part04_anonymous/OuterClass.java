package com.kh.chap01_innerClass.part04_anonymous;

public class OuterClass {
	/* 
	 * 4) 익명 내부 클래스
	 *  - 이름이 없는 내부 클래스
	 *  - 지역 내부 클래스에서 불필요한 클래스명 작성을 간결화한 문법.
	 *  - class선언부분과 객체생성부분을 합쳐서 표현
	 * */
	
	public Runnable runner ;
	{
		runner = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+" 실행중");
			}
		};
	}
	
	public Runnable getRunnable(String threadName) {
		// 클래스 정의와 객체 생성을 한번에 진행
		// new + 자료형 + 익명생성자 + {코드 구현} + ;
		return new Runnable () {
			@Override
			public void run() {
				//threadName = "zz";
				System.out.println(threadName+" 실행중");
			}
		};
	}
	
	
	
	
	
	
}
