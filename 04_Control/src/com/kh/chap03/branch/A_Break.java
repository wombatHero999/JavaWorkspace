package com.kh.chap03.branch;

import java.util.Scanner;

public class A_Break {

	/* 
	 * break : break문을 만나는 순간 "현재 속해있는 반복문"을 빠져나감.
	 * 
	 * 주의점 : switch문 안의 break와는 다른 개념. 
	 * */
	
	//매번 반복적으로 새로이 발생되는 랜덤값(1~100)을 출력
	//그 랜덤값이 3의 배수일 경우 반복문을 종료.
	public void method1() {
		while(true) {
			int random = (int)  (Math.random() * 100  + 1) ;
			
			System.out.println(random);
			
			if(random % 3 == 0) break;
		}
	}
	
	Scanner sc = new Scanner(System.in);
	public void method2() {
		
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				break;
			}
		}
		System.out.println("프로그램이 종료됩니다");
	}
	
	public void method3() {
		// 매번 반복적으로 사용자에게 "양수"를 입력받아 1~사용자가 입력한 양수까지를 출력
		// 단, 정상적으로 양수를 입력 했을 경우 반복을 종료.
		// 5 1 2 3 4 5 종료.
		// 0, -1, 양수를 입력하는 코드를 반복
		while(true) {
			System.out.print("양수를 입력해주세요 : ");
			int num = sc.nextInt();
			
			if(num > 0) {
				for(int i = 1; i<=num; i++) {
					System.out.print(i+" ");					
				}
				break;
			} 
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}				
	}
	
	
	
	public static void main(String[] args) {
		A_Break ab = new A_Break();
		ab.method3();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
