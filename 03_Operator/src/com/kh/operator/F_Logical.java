package com.kh.operator;

import java.util.Scanner;

public class F_Logical {
	
	Scanner sc = new Scanner(System.in);
	/* 
	 * 논리 연산자 : 논리값 2개를 비교하는 연산자
	 * 
	 * AND && : A && B A와 B가 모두 true인 경우에만 true반환. 둘중 하나라도 false인 경우 false값 반환
	 * 
	 * OR ||  : A || B A와 B가 모두 false인 경우에만 false반환. 둘중 하나라도 true인경우 true반환
	 * */
	
	public static void main(String[] args) {
		F_Logical fl = new F_Logical();
		fl.method4();
	}
	
	public void method1() {
		System.out.print("정수값을 1개만 입력 : ");
		int num = sc.nextInt();
		//정수값이 0초과"이면서" 짝수인지 확인
		boolean result = num > 0 && num % 2 == 0;
		System.out.println("정수가 0 초과이면서 짝수입니까 ? "+result);
	}
	
	public void method2() {
		// 사용자가 입력한 값이 1이상 100 이하인 경우 true, 그외라면 false값이 나오도록
		
		System.out.print("정수 1개 입력 : ");
		int num = sc.nextInt();
		
		boolean result =  num <= 100 && num >= 1;
		
		System.out.println("사용자가 입력한 값이 1이상 100이하 입니까?" + result);
	}
	
	public void method3() {
		System.out.print("계속 하시려면 Y를 입력하세요 ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = ch == 'Y' || ch == 'y';
		System.out.println(result);
	}
	
	public void method4() {
		
		int num1 = 10;
		
		boolean result1 = num1 < 5 && ++num1 > 0;
		System.out.println(result1);// false
		System.out.println(num1);//10
		
		int num2 = 10;
		boolean result2 = (num2 < 20) || (++num2 > 0) ;
		System.out.println(result2);// true
		System.out.println(num2);//10
	}
	
	
	
	
	
	
}
