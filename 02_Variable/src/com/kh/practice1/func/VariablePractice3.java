package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {

	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : "); 
		double width = sc.nextDouble();
		
		System.out.print("세로 : "); 
		double height = sc.nextDouble();
		
		double result1 = width * height;
		System.out.printf("면적 : %f",result1);
		
		System.out.println("둘레 : " + ( (width + height) * 2  ));
		
	}
}
