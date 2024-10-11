package com.kh.exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_CheckedException {
	/*
	 * CheckedException은 반드시 예외처리를 해줘야 되는 예외들.
	 *  => 주로 외부매체와 입출력(IO)시 발생 
	 **/
	
	public void method1() {
		try {
			method2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void method2() throws IOException {
		// Scanner와 같이 키보드로 값을 입력받을수 있는 객체
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아무 문자열을 입력해주세요...");
		//String str = br.readLine(); // br의 readLine메서드 호출시 IOException이 발생할 수 
		// 있음을 에러로 알려줌
		// 1. try~catch문으로 IOException 예외처리 완료. 
//		try {
//			String str = br.readLine();
//		}catch(IOException e) {
//			System.out.println("IO 에러 발생");
//		}
		
		// 2. throws : 발생할 수 있는 에러를 현재 메서드가 아니라, 현재 메서드를 호출한 다른 메세드로 
		//             예외처리를 위임.
		String str = br.readLine();
	}
	
	
	
	
	
	
	
	
	
}
