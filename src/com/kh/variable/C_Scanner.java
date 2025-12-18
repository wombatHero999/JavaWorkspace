package com.kh.variable;

import java.util.Scanner;

public class C_Scanner {
	// 사용자가 키보드로 직접 입력한 값을 변수에 저장할 수 있게 도와주는 클래스 
	
	public void inputTest1() {
		Scanner sc = new Scanner(System.in);
		
		//사용자의 인적사항정보 입력받기
		System.out.print("당신의 이름을 입력해 주세요..");
		// 사용자가 입력한 값을 "문자열"로 받아오는 메서드
		// 1. nextLine() : 사용자가 입력한 값을 "엔터"를 기준으로
		// 모두 가져오는 메서드. 값을 가져온 후 개행문자(엔터)는 비워준다.
		// 2. next() : 사용자가 입력한 값을 공백 기준으로 가져오는 메서드.
		// 민 경민
		
		//String name = sc.nextLine();
		String firstname = sc.next();//민\n
		sc.nextLine();// 개행문자 비워주기 작업 필요
		String lastname = sc.nextLine();//경민
		
		System.out.println(firstname + lastname);
		
		System.out.println("당신의 나이는 몇살 입니까?");
		int age = sc.nextInt();
		
		System.out.println("당신의 키는 몇 cm입니까?");
		double height = sc.nextDouble();
		
		// 입력한 데이터를 문자형으로 뽑기
		// String의 charAt(0) => 문자열의 첫번째 글자를 문자로 뽑는 메서드
		System.out.println("당신의 성별은?(M/F)");
		//char gender = sc.next().charAt(0);
		String gender = sc.next();
		char gender2 = gender.charAt(0);
		
	}
	
	
	
		
}
