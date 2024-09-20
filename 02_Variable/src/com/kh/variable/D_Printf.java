package com.kh.variable;

public class D_Printf {

	public void printfTest() {
		/* 
		 * System.out.println(출력하고자하는값); => 출력후 개행(줄바꿈)
		 * System.out.print(출력하고자하는값); => 출력하고 끝
		 * 
		 * System.out.printf("출력하고자하는 형식",형식에 맞는 값);
		 * => f는 format(형식)을 의미
		 * => 형식에 맞춰서 값들이 출력되고 끝.(개행x)
		 * => 문자열 안에는 들어갈 값과 형식을 다음과 같이 제시
		 *    %d : 정수
		 *    %f : 실수
		 *    %c : 문자
		 *    %s : 문자열 
		 * */
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 1. println과 printf 비교
		System.out.println("iNum1 : "+iNum1+", iNum2 : "+iNum2);
		System.out.printf("iNum1 : %d, iNum2 : %d%n", iNum1 , iNum2);
		
		//2. printf를 활용하여 10 + 20 = 30
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1+iNum2);
		
		System.out.printf("%5d \n", iNum1);
		System.out.printf("%-5d\n", iNum1);
		
		// 실수테스트
		double dNum = 4.27546789;
		System.out.printf("dNum : %.2f", dNum);
		
		
		char ch = 'a';
		String str = "Hello";
		
		System.out.printf("%c %s \n", ch,str);
		System.out.printf("%C %S %% \n", ch,str);
	}
	
	
	
	
	
	
	
}
