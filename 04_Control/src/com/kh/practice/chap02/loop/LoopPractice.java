package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 :");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}

		if (num < 1) {
			practice1();
		}
	}

	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요 :");
		int num = sc.nextInt();

		//
		if (num < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			practice2();
		}

		for (int i = num; i > 0; i--) {
			System.out.print(i + " ");
		}
	}

	public void practice3() {
		System.out.print("정수를 하나 입력하세요 :");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
			System.out.print(i + (i == num ? " = " : " + "));
		}
		System.out.println(sum);

	}

	public void practice4() {
		System.out.print("첫 번째 숫자 :");
		int num1 = sc.nextInt(); //4
		
		System.out.print("두 번째 숫자 :");
		int num2 = sc.nextInt(); //8
		
		int start = num1 > num2 ? num2 : num1;
		int end = num1 > num2 ? num1 : num2;
		
		if(start < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			practice4();
			return;
		}
		
		//4 5 6 7 8
		for(int i = start; i<= end; i++) {
			System.out.print(i+" ");
		}		
	}

	public void practice5() {
		System.out.print("숫자 :");
		int dan = sc.nextInt();
		
		if(dan > 9) {
			System.out.println("9이하의 숫자만 입력해주세요.");
			practice5();
			return;
		}
		
		for(int i = dan; i<=9; i++) {
			System.out.println("===== "+i+"단 =====");
			//구구단을 출력한느 함수
			for(int j = 1; j<10; j++) {
				System.out.printf("%d X %d = %d\n", i, j , i*j);
			}
		}
	}

	public void practice6() {
		System.out.print("시작 숫자 :");
		int start = sc.nextInt();
		
		System.out.print("공차 :");
		int gong = sc.nextInt();
		
		for(int i =0; i<10; i++) {
			// 방법1)
			// 4 + 3 * 0
			// 4 + 3 * 1
			// 4 + 3 * 2
			//..
			// 4 + 3 * 9
			//System.out.print( ( start + gong * i)  +" ");
			
			// 방법2)
			System.out.print(start+" ");
			start += gong;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
