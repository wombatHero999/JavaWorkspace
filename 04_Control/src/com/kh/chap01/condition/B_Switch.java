package com.kh.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	/* 
	 * switch 조건식x 확실한 값만 기술
	 * 
	 * [표현법]
	 * switch(동등비교를 수행할 값) {
	 * case 값1 : 실행할 코드; break;
	 * case 값2 : 실행할 코드; break;
	 * ....
	 * case 값n : 실행할 코드; break;
	 * [default : 실행할 코드;]
	 * }
	 * */
	
	Scanner sc = new Scanner(System.in);
	
	// 입력값이 1인경우 빨간불, 2인경우 주황불, 3인경우 초록불을 출력
	// 잘못입력한 경우 잘못입력했습니다.
	public void method1() {
		System.out.print("1~3사이의 정수 입력 : ");
		int num = sc.nextInt();
		
//		if(num == 1) {
//			System.out.println("빨간불입니다.");
//		} else if(num == 2) {
//			System.out.println("주황불입니다.");
//		} else if(num == 3) {
//			System.out.println("초록불입니다.");
//		} else {
//			System.out.println("잘못 입력했습니다.");
//		}
		
		switch(num) {
		case 1 : System.out.println("빨"); break;
		case 2 : System.out.println("주"); break;
		case 3 : System.out.println("초"); break;
		default : System.out.println("잘못 입력했습니다..");
		}
	}
	
	public void method2() {
		System.out.println("--- Welcome 과일가게 ---");
		System.out.println("구매할 과일을 입력하세요.");
		System.out.println("사과, 바나나, 복숭아 입력 : ");
		String fruit = sc.nextLine();
		
		int price = 0;
		
		switch(fruit) {
		case "사과" : price = 1000; break;
		case "바나나": price = 2000; break;
		case "복숭아": price = 5000; break;
		default : System.out.println("저희가게에서 판매하는 과일이 아닙니다."); return;
		}
		
		System.out.printf("%s의 가격은 %d원입니다.", fruit, price);
	}
	
	public void method3() {
		
		System.out.print("1월 ~ 12월 사이의 월 입력 : ");
		int month = sc.nextInt();
		
		// 1,3,5,7,8,10,12 -> 31일
		// 4,6,9,11 -> 30일
		// 2 -> 28, 29
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10:case 12: 
			System.out.println("해당 달은 31일 까지 입니다."); break;
		case 2: System.out.println("해당 달은 28일 까지 입니다."); break;
		case 4: case 6: case 9: case 11:
			System.out.println("해당 달은 30일 까지 입니다."); break;
		}
	}
	
	

	
	
	
	
}
