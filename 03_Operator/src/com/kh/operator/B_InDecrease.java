package com.kh.operator;

public class B_InDecrease {

	public static void main(String[] args) {
		B_InDecrease bid = new B_InDecrease();
		bid.method4();
	}

	/*
	 * 증감연산자(단항연산자) ++ -- ++ : 변수에 담긴값을 1 증가 ++변수값 , 변수값++
	 * 
	 * -- : 변수에 담긴값을 1 감소 --변수값, 변수값--
	 * 
	 * (증감연산자)값 : 전위연산 -> 선증감 후처리 값(증감연산자) : 후위연산 -> 선처리 후증감
	 */
	public void method1() {
		// 전위연산
		int num = 10;
		System.out.println("전위연산 전 num : " + num);
		System.out.println("1회 수행후 결과 : " + ++num);// 11
		System.out.println("2회 수행후 결과 : " + ++num);// 12
		System.out.println("3회 수행후 결과 : " + ++num);// 13

		System.out.println("최종 결과 : " + num);// 13

		System.out.println("===========================================================");

		// 후위연산
		int num2 = 10;
		System.out.println("후위연산 전 num2 : " + num2); // 10
		System.out.println("1회 수행후 결과 : " + num2++); // 10
		System.out.println("2회 수행후 결과 : " + num2++); // 11
		System.out.println("3회 수행후 결과 : " + num2++); // 12

		System.out.println("최종 결과 : " + num2);// 13
	}

	public void method2() {
		
		int a = 10;
		int b = ++a;
		
		// a = 10, 11
		// b = 11
		System.out.println("a = " + a + " b = "+ b);
		
		int c = 10;
		int d = c++;
		// c = 11
		// d = 10
		System.out.println("c = "+ c + " d = "+ d);
		
	}
	
	
	public void method3() {
		
		int num1 = 20;
		int result1 = num1++ * 3; // 20(21) * 3
		
		// num1 ? 21 
		// result1 ? 60 , 63
		
		int num2 = 20;
		int result2 = --num2 * 3;
		
		// num2 ? 20 , 19 
		// result2 ? 57
	}
	
	public void method4() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);// 출력 : 10(11)
		System.out.println((++a) + (b++));// 출력 : 32 , a : 12, b : 20(21)
		System.out.println((a++) + (--b) + (--c) );
		// 출력 : 61
		// 12(13) + 20 + 29
		// a, b, c
		
		System.out.println(a+" "+b+" "+c);// 13 20 29
	}
	
	
	
	
	
	

}
