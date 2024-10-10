package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	
	public TokenController() {
		
	}
	
	public String afterToken(String str) {
		String [] arr = str.split(" ");
		
		String result = "";
		for(String s : arr) {
			result += s;
		}		
		
		StringTokenizer stn = new StringTokenizer(str," ");// "J","v","a"
		
		// "" , "J" , "Ja" , "Jav",...
		StringBuilder sb = new StringBuilder();
		
		//String result = "";
		while(stn.hasMoreTokens()) {
			//result += stn.nextToken();
			sb.append(stn.nextToken());
		}
		
		//return sb.toString();
		return str.replace(" ", "");
	}
	
	public String firstCap(String input) {
		// 매개변수로 받아온 input의 첫 번째 글자만 대문자로 바꾼 문자열 반환
		char first = input.toUpperCase().charAt(0);
		// application
		// A
		// pplication
		return first + input.substring(1 , input.length());
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		
		// application
//		char [] arr = input.toCharArray(); // ['a','p','p', ...]
//		
//		for(char ch : arr) {
//			if(ch == one) count++;
//		}
		
		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i) == one) count++;
		}
		
		return count;
	}
	
}
