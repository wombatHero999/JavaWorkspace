package com.kh.chap4_method.controller;

/*
 *  메소드 오버로딩
 *  - 한 클래스 내에 "같은 이름으로 메소드"를 여러개 정의하는 방법.
 *  
 *  - 매개변수의 자료형의 개수나 순서가 다르게 작성되어야 한다.
 *  - 그 외 매개변수의 이름, 접근제한자, 반환형은 메소드 오버로딩에 영향을 주지 않는다.
 *  */
public class MethodTest2 {

	
	public void test() {
		System.out.println();
		System.out.println("하이");
		System.out.println(11111);
	}
	
	public void test(int a) {
		//System.out.printf
	}
	
//	public void test(int a2) {
//		//System.out.printf
//	}
	
	public void test(int a2 , String s) {
		
	}
	
	public void test(String s , int a2) {
		
	}
	
	/*
	 * protected void test() {
	 * 
	 * }
	 */
	
	/*
	 * public String test() {
	 * 
	 * }
	 */
	
	// 매개변수의 이름이나, 접근제한자, 반환형은 메소드오버로딩과 연관이 없다.
	// 즉 항상 매개변수의 자료형의 순서나,개수가 다르게 작성되어야 오버로딩이 적용된다.
	
	
	
	
	
	
	
	
	
}
