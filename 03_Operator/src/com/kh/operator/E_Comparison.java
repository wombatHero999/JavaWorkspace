package com.kh.operator;

public class E_Comparison {
	
	/*
	 * 비교연산자
	 * 두 개의 값을 가지고 비교, 비교연산한 결과가 참이라면 true, 거짓이라면 false
	 * 즉, 연산결과가 boolean자료형이다.
	 * 
	 * 크고 , 작음을 비교하는 연산자
	 * >, < , >=, <=
	 * 
	 * 둘이 일치함을 비교는 일치함비교(동일성비교)
	 * a == b, a != b 
	 *  */
	
	public void method1() {
		int a = 10;
		int b = 25;
		
		System.out.println("a > b : " + (a > b));//false
		System.out.println("a <= b : "+(a <= b));//true
		
		boolean result1 = a == b; // false
		
		boolean result2 = a != b; // true
		
		boolean result3 = a - b < 0; // true
		
		boolean result4 = a * 2 > b / 5; // true
		
		boolean result5 = a % 2 == 0; // true 짝수
		
		boolean result6 = a % 2 != 1; // 짝수
		
		boolean result7 = !(a % 2 == 1); // 짝수인지 검사
		
		// (==)는 기본자료형에서만 사용 가능.
		//--------------------------------------------------
		// 참조자료형에서 두 값이 동일한지 비교를 할때는 equals라는 함수를 사용
		String name = "민경민";
		String name2 = "민경민";
		boolean result8 = name == name2; // true이긴 하지만 99%의 상황에서 false
	}
	
	
	
	
	
	
	
	
	
	
	
}
