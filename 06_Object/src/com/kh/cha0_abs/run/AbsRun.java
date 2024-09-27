package com.kh.cha0_abs.run;

import com.kh.cha0_abs.model.vo.Student;

//import com.kh.cha0_abs.model.vo.Student;

public class AbsRun {
	/*
	 *	1. 객체지향언어란? 
	 *   - 객체들을 통해 동작하는 프로그램을 만들수 있도록 지원하는 언어 
	 *   
	 *  2. 객체란 ? 
	 *   - Class에 정의된 내용을 토대로 메모리 영역에 생성된 데이터.
	 *   
	 *  3. 구현하고자하는 프로그램 상의 필요한 객체를 생성하기 위해서 클래스를 정의할 예정
	 *     (클래스란 객체들의 속성,기능들을 담아낼 수 있는 그릇과도 같은 존재)
	 *     (클래스 생성을 위해선 ? 추상화 + 캡슐화)
	 *  
	 *  4. 추상화 과정
	 *    학생관련 프로그램을 설계한다고 가정.
	 *    1) 학번
	 *    2) 학점
	 *    3) 이름
	 *    4) 성적
	 *    5) 주량
	 *    6) 성별
	 *    7) 키 , 전화번호, 학년, 반 ,...
	 *    
	 *    만약, 학생의 건강을 관리하는 프로그램이다 ? 학번, 이름, 주량, 성별, 키, 전화번호, 학년, 반
	 *    
	 *    공통적인 속성들에서 프로그램의 목적상 필요 없는 속성은 제거. ==> 추상화
	 *    학번 -> int studentNo;
	 *    이름 -> String name;
	 *  */
	
	public static void main(String[] args) {
		//1. Student 클래스를 통해 객체를 생성(인스턴스화)
		Student hong = new Student();
		
		hong.name = "홍길동";
		hong.age = 20;
		hong.height = 180.3;
		
		System.out.println(hong.name); // null
		System.out.println(hong.age); // 0
		System.out.println(hong.height);// 0.0
		
		//2. 여러분을 표현하는 객체 생성.
		Student mkm = new Student();
		
		mkm.name = "민경민";
		mkm.age = 35;
		mkm.height = 180.5;
		
		System.out.println(mkm.name); // 
		System.out.println(mkm.age); // 
		System.out.println(mkm.height);// 
		
		System.out.println(hong);
		System.out.println(mkm);
		
}
	
	
	
	
	
	
	
	
	
}
