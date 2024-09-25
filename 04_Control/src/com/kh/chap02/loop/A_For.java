package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {
	
	/*
	 * 반복문의 종류
	 * For / While
	 *
	 * [표현법]
	 * for(초기식;조건식;증감식){
	 * 	 반복적으로 실행할 코드
	 * }
	 * - 초기식 : 반복문을 실행할때 최초 1번만 초기에 실행되는 구문
	 *          (반복문에서 사용할 "변수"를 선언 및 초기화 하는데 사용)
	 *          ex) int i = 0;
	 * - 조건식 : 반복이 실행될 조건을 작성하는 구문.
	 *          조건식의 결과가 true여야 구문이 실행되고, false라면 for문 종료.
	 *          (보통 초기식에 제시된 변수를 조건식에 자주 활용)
	 *          ex) i < 10;
	 * - 증감식 : 반복문을 제어하는 변수(i)값을 증감시키는 구문
	 *          (보통 초기식에 제시된 변수를 증감)
	 *          ex) i++ , i-- , i+=1, i+=2
	 *
	 *  for문 실행 순서
	 *  초기식 -> 조건식(조건검사) -> true일 경우 중괄호블럭의 내용이 실행 -> 증감식
	 *       -> 조건식 -> ...
	 *       매 조건검사의 결과가 false가 나올때 까지 무한 반복.
	 * */
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		for(int i = 0; i < 5; i++) {
			System.out.println("안녕하세요.");
		}
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("안녕하세요.");
		}
		
		for(int i = 11; i < 16; i++) {
			System.out.println("안녕하세요.");
		}
		
		for(int i = 5; i > 0; i--) {
			System.out.println("안녕하세요.");
		}
	}
	
	public void method2() {
		// 1 ~ 5 까지 출력
		// 1 2 3 4 5
		for(int i =1; i<=5; i++) {
			System.out.print(i+" ");// 1 2 3 4 5 
		}
	}
	
	public void method3() {
		//5 4 3 2 1
		for(int i=5; i > 0; i-=1) {
			System.out.print(i+" ");
		}
	}
	
	public void method4() {
		//i값이 1에서부터 10까지의 정수중 홀수만 출력.
		//1 3 5 7 9
		
		for(int i = 1; i < 10 ; i++ ) {
			switch(i) {
			case 1 : case 3: case 5: case 7: case 9:
				System.out.print(i+" ");
			}
			//?
		}
		for(int i = 1; i < 10 ; i+=2 ) {
			System.out.print(i+" ");
		}
		
		for(int i = 1; i< 10; i++) {
			if(i % 2 == 1) System.out.print(i+" ");
		}		
	}
	
	// 1부터 10까지의 총 합
	public void method5() {
		//int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 +8 +9 +10;
		
		int sum = 0;
		for(int i = 1; i<=10; i++) {
			sum += i ;
		}
		System.out.println("총합 : "+sum);
	}
	
	// 산술연산+반복문 +스캐너
	public void method6() {
		//1부터 사용자가 입력한 수까지의 모든 합을 출력 -> 1에서부터 n까지의 총 합계 : n
		// 단, 입력받은 수가 양수가 아닌경우 "잘못입력하셨습니다" 출력
		
		System.out.print("양수 입력 : ");
		int num = sc.nextInt();
		
		if(num <= 0) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1에서부터 "+num+"까지의 총 합계 : "+sum);
	}
	
	//랜덤값 추출
	public void method7() {
		// java.lang.Math의 random()메서드 활용

		//System.out.println((int)(Math.random() * 10 + 1));
		/* 
		 * 1 ~ 10사이의 랜덤한 정수를 구하려면?
		 * 
		 * 0.0 <= 랜던값 <= 0.9999999999999999;
		 * 0.0 <= 랜덤값 < 1.0; 
		 * 0.0 <= 랜덤값 < 10.0
		 * 1.0 <= 랜덤값 < 11.0
		 * 
		 * [표현법]
		 * Math.random() * 출력하고자하는 갯수 + 시작하고자는 수
		 * 시작수 ~ (시작수+출력하고자하는 갯수)
		 * */
		for(int i = 0; i<6; i++) {
			int random = (int)(Math.random() * 45 + 1);
			System.out.println(random);			
		}
	}
	
	public void method8() {
		String word = "HE   LLO";
		//H -> System.out.println(word.charAt(0));
		//  -> System.out.println(word.charAt(1));
		//E -> System.out.println(word.charAt(2));
		//  -> System.out.println(word.charAt(3));
		//L...
		for(int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
	}
	
	public void method9() {
		// 사용자에게 문자열을 입력받은 후
		// 각 위치별로 문자를 뽑아서 출력.
		System.out.print("문자열 입력 : ");
		String word = sc.nextLine();
		// 문자열 입력 : apple
		
		System.out.println(word+" 길이 : "+word.length());
		
		for(int i = 0; i<word.length(); i++) {
			System.out.print(word.charAt(i)+" ");
		}
		// apple 길이 : 5
		// 01234
		// a p p l e
	}
	
	//구구단 출력(2단)
	public void method10() {
		/* 
		 * 
		 * 2 X 1 = 2
		 * 2 X 2 = 4 
		 * 2 X 3 = 6
		 * 2 X 4 = 8
		 * ...
		 * 2 X 9 = 18
		 * */
//		int dan = 2;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(dan+" X "+i+"= "+i*dan);
//		}
//		System.out.println();
//		dan = 3;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(dan+" X "+i+"= "+i*dan);
//		}
//		System.out.println();
//		dan = 4;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(dan+" X "+i+"= "+i*dan);
//		}
//		System.out.println();
//		dan = 9;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(dan+" X "+i+"= "+i*dan);
//		}
		
		//구구단코드 실행
		for(int dan = 2; dan <=9; dan++) {
			gugudan(dan);
			System.out.println();
		}
	}
	
	public void method11() {
		// 2단부터 9단 사이의 랜덤한 단을 출력
		int randomDan = (int) (Math.random() * 8 + 2);
		
		//gugudan(randomDan);
		for(int i = 1; i<10; i++) {
			System.out.printf("%d X %d = %d%n", randomDan, i , randomDan * i);
		}
	}
	
	public void method12() {
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
		//출력할 코드
//		for(int i = 1; i<6; i++) {
//			System.out.print(i+" ");
//		}
		for(int i = 0; i<3; i++) {
			//출력할 코드
			for(int j = 1; j<6; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public void method13() {
		//****\n
		//****\n
		//****\n
		//****\n
		//중첩 반복문구조로 위 출력결과를 만들기
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				System.out.print("*"); // ****	
			}
			System.out.println();//****\n
		}
	}
	
	public void method14() {
		//1***\n
		//*2**\n		
		//**3*\n		
		//***4\n
		for(int j = 1; j <5; j++) {
			for(int i = 1; i<5; i++) {
				if(i == j) {
					System.out.print(i);				
				}else {
					System.out.print("*");				
				}			
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	public void gugudan(int dan) {
		for(int i = 1; i < 10; i++) {
			System.out.println(dan+" X "+i+"= "+i*dan);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}