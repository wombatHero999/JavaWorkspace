package com.kh.practice.token.view;

import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();

	public void mainMenu() {
		while(true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열 ");
			System.out.println("3. 프로그램 끝내기");
			System.out.print("메뉴번호 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: tokenMenu(); break;
			case 2: inputMenu(); break;
			case 3: return;
			default: System.out.println("다시 입력.");
			}
		}
	}

	public void tokenMenu() {
		String str = "J a v a P r o g r a m "; 
		// 토큰 처리 전 글자, 토큰 처리 전 개수를 출력
		System.out.println("토큰 처리 전 글자 : "+str);
		System.out.println("토큰 처리 전 개수 : "+str.length());
		
		// TokenController(tc)의 afterToken()의 반환 값을 가지고
		// 토큰 처리 후 글자, 토큰 처리 후 개수, 모두 대문자로 변환 한 것을 출력
		String result = tc.afterToken(str);
		System.out.println("토큰 처리 후 글자 : "+result);
		System.out.println("토큰 처리 후 개수 : "+result.length());
		System.out.println("모두 대문자로 변환 : "+result.toUpperCase());
	}

	public void inputMenu() {
		System.out.print("문자열을 입력하세요 :");
		String str = sc.next();
		String result = tc.firstCap(str);
		System.out.println("첫 글자 대문자 : "+result);
		// tc에 firstCap()로 입력 받은 문자열을 넘기고 반환 값 출력
		
		System.out.print("찾을 문자를 하나 입력하세요 : ");
		char ch = sc.next().charAt(0); // i m c
		int count = tc.findChar(str, ch);
		System.out.println(ch+"문자의 개수 : "+count);
	}
}
