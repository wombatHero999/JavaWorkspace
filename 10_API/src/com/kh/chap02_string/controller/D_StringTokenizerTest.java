package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class D_StringTokenizerTest {

	public static void method() { 
		
		String str = "Java,Oracle,JDBC,HTML,Server";
		
		// 구분자(,)를 제거하여 문자열들을 분리시키는 방법
		// 방법 1. 분리된 문자열들을 String[]에 담아서 관리하고자 할때?
		//        문자열.split(구분자) : String[]
		
		String [] arr = str.split(",");
		
		for(String s   :  arr) {
			System.out.println(s);
		}
		
		// 방법 2. java.util.StringTokenizer클래스를 이용하는 방법
		// StringTokenizer stn = new StringTokenizer(분리시키고자하는 문자열, 구분자);
		StringTokenizer stn = new StringTokenizer(str,",");
		
		System.out.println("분리된 문자열의 갯수 : "+stn.countTokens());
		
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
		//System.out.println(stn.nextToken());
		
//		int tokens = stn.countTokens();
//		for(int i =0; i<tokens; i++) {
//			System.out.println(stn.nextToken());
//		}
		
//		while(stn.countTokens() > 0) {
//			System.out.println(stn.nextToken());
//		}
		
		while(stn.hasMoreTokens()) {
			System.out.println(stn.nextToken());
		}
		
		
	}
	
}
