package com.kh.chap03_wrapper.run;

public class WrapperRun {
	public static void main(String[] args) {
		/* 
		 * Wrapper클래스
		 *  => 기본자료형을 감싸서 객체로 포장해주는 클래스들 
		 * 
		 * 기본자료형  <----------> 래퍼 클래스  
		 * 
		 * byte                   Byte
		 * short                  Short
		 * int                    Integer  
		 * long                   Long
		 * 
		 * float                  Float
		 * double                 Double
		 * 
		 * char                   Character
		 * boolean                Boolean
		 * */
		
		int num1 = 10;
		int num2 = 15;
		
		//System.out.println(num1.equals(num2));
		// 기본자료형에서 객체의 메소드를 활용하고 싶다면 Wrapper클래스로 변환하여 사용한다.
		
		// 자동형변환이 발생
		// 기본자료형 -> Wrapper자료형 (Boxing)
		Integer i1 = /*(Integer)*/ num1;
		Integer i2 = num2;
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode());
		System.out.println(i1.compareTo(i1));
		// a.compareTo(b) : a와 b를 비교해서 a가 b보다 크면 1을, 같으면 0을 a가 더 작으면 -1을 반환
		
		// Wrapper 클래스 -> 기본자료형 (UnBoxing)
		int num3 = i1;
		int num4 = i2;
		
		System.out.println("===========================================");
		
		// 기본자료형 <---> String 
		String str1 = "10";
		String str2 = "15.3";
				
		System.out.println(str1+str2);
		
		// 1. String -> 기본자료형 
		// 파싱(parse)
		// Wrapper클래스.parseXXX(변경할 문자열)
		int i = Integer.parseInt(str1); // "10" -> 10
		double d = Double.parseDouble(str2); // "15.3" -> 15.3
		System.out.println(i+d);
		
		// 2. 기본자료형 -> String
		String strI = i+"";
		String strD = String.valueOf(d);
	}
}
