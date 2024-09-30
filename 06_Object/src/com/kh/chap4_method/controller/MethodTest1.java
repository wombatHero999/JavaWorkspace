package com.kh.chap4_method.controller;

public class MethodTest1 {
	
	/* 
	 * 메소드
	 * [표현법]
	 * 접근제한자 예약어 반환형 메소드명(매개변수){
	 *   수행할 코드
	 *  
	 *   [return 반환할값]
	 * }
	 * */
	
	// 1. 매개변수가 없고 반환형이 없는 메소드
	public void method1() { // input X
		
		int sum = 0;
		for(int i =0; i<11; i++) {
			sum += i;
		}
		System.out.println("sum ? "+sum);
		//return; --> JVM이 자동으로 생성
		// output x
	}
	
	//2. 매개변수 x , 반환값은 o
	public int getAge() {
		return 11;
	}
	
	//3. 매개변수 o , 반환값은 x
	public void setAge(int age) {
		//필드 = age;
	}
	
	//4. 매개변수 o , 반환값도 o
	public int method2(int a, int b) {
		// a와 b중 더 큰값을 반환
		return a > b ? a : b;
	}
	
	
	
	
	
	
	
	
}
