package com.kh.chap_01math;

//import java.lang.*;

public class MathRun {
	
	public static void main(String[] args) {
		
		// 수학과 관련된 기능을 제공하는 클래스 Math
		
		// 1. 파이
		System.out.println("1. 파이 "+Math.PI);
		
		// 2. 올림 double -> double
		double num1 = 4.349;
		System.out.println("올림 : "+Math.ceil(num1));
		
		// 3. 반올림 double -> long
		System.out.println("반올림 : "+Math.round(num1));
		
		// 4. 버림 => double -> double
		System.out.println("버림 : "+Math.floor(num1));
		
		// 5. rint -> 가장 가까운 정수값을 알아낸 후 실수형으로 반환
		System.out.println("가까운 정수값 : "+Math.rint(num1));
		
		// 6. 절대값 양수
		int num2 = -10;
		System.out.println("절대값 : "+Math.abs(num2));
		
		// 7. 최소값
		System.out.println("최소값 : "+Math.min(5, 10));
		
		// 8. 최대값
		System.out.println("최대값 : "+Math.max(5, 19));
		
		// 9. 제곱근(루트)
		System.out.println("4의 제곱근 :" + Math.sqrt(4));
		
		// 10. 제곱
		System.out.println("2의 10제곱 : "+Math.pow(2, 10));
		
		/*
		 *  java.lang.Math
		 *   - 모든 필드가 상수필드
		 *   - 모든 메소드가 static 메소드
		 *   
		 *  모든 필드, 메소드가 static이기 때문에 Math. 으로 모든 메소드 및 필드에 접근이 가능
		 *  즉 객체생성할 필요가 없다.
		 *  
		 *  Math클래스의 생성자가 private이다.
		 *  */
		
		
		
		
		
		
	}

}
