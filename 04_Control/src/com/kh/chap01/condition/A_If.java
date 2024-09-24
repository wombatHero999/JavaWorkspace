package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {
	/* 
	 * 조건문
	 * 조건식을 통해 참/거짓을 판단하여 그에 해당하는 코드를 실행
	 * 
	 * 조건식의 결과는 항상 true/false여야함. 따라서 true/false값을 반환해주는 &&,||, ==, >= 등이 함께
	 * 자주 사용된다.
	 * 
	 * 조건문은 크게 if문과 switch문으로 나뉨.
	 * if
	 * - 단독 if
	 * - if ~ else
	 * - if ~ else if 등이 존재
	 * */
	Scanner sc = new Scanner(System.in);
	
	//사용자에게 정수값을 입력 받은 후 양수다, 양수가 아니다를 출력
	public void method1() {
		/* 
		 * [표현법]
		 * if(조건식){
		 * 	  조건식의 결과가 true인 경우에만 실행
		 * }
		 * */
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
		}
		
		if(num < 0) {
			System.out.println("양수아니다");
		}
	}
	
	public void method2() {
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		/* 
		 * if ~ else문
		 * if(조건식) {
		 * 	 .. 조건식이 true라면 실행할 코드 ..
		 * }else{
		 *   .. 조건식이 false라면 실행할 코드 ..
		 * }
		 * */
		if(num > 0) System.out.println("양수다");
		else System.out.println("양수아니다");
		
		String result = num > 0 ? "양수다" : "양수아니다";
	}
	
	public void method3() {
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		/* 
		 * if ~ else if문
		 * 
		 * 언제 ? 같은 비교대상(num)으로 여러개의 조건을 제시해야하는 경우
		 * if(조건식1) {
		 * 	 .. 조건식1이 참일경우 실행할 코드..		 * 
		 * }else if(조건식2){
		 *   .. 조건식2가 참일경우 실행할 코드..
		 * }else if(조건식n){
		 *   .. 조건식n이 참일경우 실행할 코드..
		 * }[else{ // 생략가능
		 *   .. 모든 조건이 false일 경우 실행할 코드..
		 * }]
		 * */
		if(num > 0) {
			System.out.println("양수다");
		} else if (num == 0) {
			System.out.println("0이다");
		} else if (num < 0) {
			System.out.println("음수다");
		} else {
			System.out.println("이상한 수다");
		}
		
		if(num > 0) {
			System.out.println("양수다");
		} else {
			if (num == 0) {
				System.out.println("0이다");
			}else {
				if (num < 0) {
					System.out.println("음수다");
				}else {
					System.out.println("이상한 수다");	
				}
			}
		}
	}
	
	public void method4() {
		// 사용자가 입력한 나이값을 가지고 어린이/청소년/성인 출력
		// if ~ else if문을통해 학습
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		// 어린이(13세이하), 청소년(13세초과 19세이하), 성인(19세 초과), 노인(70세)
		
		if(age <= 13) {
			System.out.println("어린이");
		}else if(age <= 19) {
			System.out.println("청소년");
		}else if(age <= 70) {
			System.out.println("성인");
		}else {
			System.out.println("노인");
		}
	}
	
	public void method5() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		if(name.equals("민경민")) {
			System.out.println("민경민님 안녕하세요.");
			return;
		}
		
		System.out.println("민경민님이 아니시네요. 누구신가요?");
		
//		else {
//			System.out.println("민경민님이 아니시네요. 누구신가요?");
//		}
	}
	
	public void method6() {
		
		System.out.print("정수(양수) 입력 : ");
		int num = sc.nextInt();
		
		if(num <= 0) {
			System.out.println("제대로 입력하세요..");
			return;
		}
		
		if(num % 2 == 0) {
			// 짝수입니다.
			System.out.println("짝수");
		}else {
			// 홀수입니다.		
			System.out.println("홀수");
		}
		
//		if(num > 0) {
//			if(num % 2 == 0) {
//				// 짝수입니다.
//				System.out.println("짝수");
//			}else {
//				// 홀수입니다.		
//				System.out.println("홀수");
//			}
//		} else {
//			// 양수가 아닙니다. 잘못입력하셨습니다.
//			System.out.println("양수x");
//		}
//		
//		if(num > 0 && num % 2 == 0) {
//			System.out.println("짝수");
//		}
//		else if (num > 0 && num % 2 == 1) {
//			System.out.println("홀수");
//		}else {
//			System.out.println("양수x");
//		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
