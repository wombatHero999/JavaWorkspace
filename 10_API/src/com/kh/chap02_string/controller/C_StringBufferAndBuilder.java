package com.kh.chap02_string.controller;

public class C_StringBufferAndBuilder {
	
	/*
	 * String은 불변클래스
	 * StringBuffer와 StringBuilder는 가변클래스 
	 *  - 문자열 연산이 빈번하게 일어나는 알고리즘에서 메모리이슈를 해결하기 위해 나온 클래스
	 * 
	 * 두 클래스는 기본적으로 동일한 메소드를 가지고 있음.
	 * 차이점은 딱 하나인데, "동기화"여부
	 *  
	 *  */
	
	public static void method() {
		String str = "Hello";
		str += "World"; // 메모리공간 2개 잡아먹음
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World,"); // 메모리공간 1개
		
		StringBuilder sb2 = new StringBuilder("Hello");
		sb2.append("World");
		
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.println(sb.toString());
		System.out.println(sb2);
		
		System.out.println("o의 마지막 위치는 ? "+sb.lastIndexOf("o"));
		
		// 문자를 삭제 delete(삭제할 시작인덱스, 종료할 위치의 인덱스)
		System.out.println( sb.delete(5, sb.length()));
	}
	
	
	
	
	
	
	
	
	
	
	
}
