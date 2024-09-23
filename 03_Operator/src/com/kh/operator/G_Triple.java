package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	/* 
	 * 삼항연산자
	 * [표현법]
	 * 조건식 ? true인경우 실행할 결과값 : false일경우 실행할 결과값
	 * */
	
	public void method1() {
		int num = 10; // 사용자가 입력한 값이라고 가정.
		
		String result = num > 0 ? "양수" : "음수";
		
		System.out.println(num+"은 "+result+"입니다.");
		
		System.out.println(num + "은 " + (num > 0 ? "양수입니다" : "음수입니다"));
	}
	
	//삼항연산자 중첩
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		//사용자가 입력한 값이 "양수", "0", "음수"
		String result = num > 0 ? "양수입니다" : (num == 0 ? "0입니다" : "음수입니다");
		System.out.println(result);
	}
	
	public void method3() {
		/* 
		 * 두 개의 정수값과 +,- 문자를 하나 입력받아
		 * +일 경우 두 정수값을 더한 결과를,
		 * -일 경우 두 정수값을 뺄셈한 결과를 반환.
		 * 둘다 아닌 문자를 입력한 경우 "잘못입력했습니다"를 반환 
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt(); // 1
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt(); // 5
		
		String s = ""+6; // "6"
		
		sc.nextLine();//개행문자 비워주기
		System.out.print("연산자 입력(+ or -) : ");
		char op = sc.nextLine().charAt(0); // + 
		// 1, 5 , + ==> 6
		// 1, 5 , - ==> -4
		// 1, 5 , x ==> 잘못입력하셨습니다.
		
		//결과값 출력
		String result = 
				op == '+' ? 
					(num1 + num2)+"" : ( op == '-' ?(num1-num2)+"" : "잘못입력하셨습니다." );
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {
		G_Triple gt = new G_Triple();
		gt.method3();
	}
	
	
	
	
	
	
}
