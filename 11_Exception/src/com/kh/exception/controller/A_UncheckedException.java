package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_UncheckedException {
	/*
	 * RuntimeException - 프로그림 실행 시 발행하는 예외들
	 * 
	 * RuntimeException의 자식클래스들 - NullPointerException : 참조변수가 아직 null인 상태에서 특정 메서드,
	 * 필드에 접근하려고할때 - ArrayIndexOutOfBoundsException : 배열의 부적절한 인덱스로 접근할 때 발생하는 에러 -
	 * ClassCastException : 잘못된 자료형으로 형변환이 진행될 경우 발생하는 예외 - ArithmeticException :
	 * 나누기 연산시 0으로 나눌 때 발생하는 예외 ... => 이러한 RuntimeException들은 코드상으로 충분히 예측이 가능한
	 * 상황들이기 때문에 애초에 예외가 발생하지 않게끔 조건문으로 처리하는 것을 권장.
	 */

	Scanner sc = new Scanner(System.in);

	public void method1() {

		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();

		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();

		// 예외처리 방법 1. 조건문으로 처리
//		if(num2 != 0) {
//			System.out.println("나눗셈 연산 결과 : " + (num1 / num2) );			
//		}else {
//			System.err.println("0으로 나눌 수 없습니다.");
//		}

		// 예외처리 방법 2. 예외처리구문으로 해결
		// 예외가 발생했을 경우를 대비해서 실행할 내용을 정의해 두는 것
		/*
		 * try ~ catch 문 [표현법] try { // 예외가 발생될수 있는 코드 } catch(발생될 예외 클래스 변수명) { // 예외가
		 * 발생했을 경우 실행할 구문 }
		 */
		try {
			System.out.println("나눗셈 연산 : " + (num1 / num2)); // 제대로 출력될 수도 있고, 예외가 발생할수도 있음.
		} catch (ArithmeticException e) {
			// 예외가 발생하는 경우 에러대신 실행할 코드를 작성하는 영역
			System.err.println("0으로 나눌수 없습니다.");
			e.printStackTrace(); // 오류 추적 가능
		}

		System.out.println("프로그램 종료");
	}

	public void method2() {

		System.out.print("정수 입력(0 빼고) : ");

		try {
			int num = sc.nextInt(); // InputMismatchException

			System.out.println("나눗셈 연산 : " + (10 / num));// ArithmeticException발생
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (InputMismatchException e) {
			System.out.println("정수를 똑바로 입력하세요.");
		}

		System.out.println("프로그램 종료");
	}

	public void method3() {

		System.out.print("배열의 크기 : ");

		// if(size > 0) {
		// }
//		try {
//			int size = sc.nextInt();
//			int[] arr = new int[size];
//			System.out.println("100번째 인덱스의 값 : " + arr[100]);
//		} catch (NegativeArraySizeException e) {
//			System.out.println("배열의 크기는 양수여야 합니다.");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("부적절한 인덱스로 접근하였습니다.");
//		}

		try {
			int size = sc.nextInt();
			int[] arr = new int[size];
			System.out.println("100번째 인덱스의 값 : " + arr[100]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 인덱스입니다.");
		} catch (RuntimeException e) {
			System.out.println("에러가 발생했습니다.");
			e.printStackTrace();
		} 
	}
	
	/* 
	 * RuntimeException관련된 예외는
	 *  - 조건문으로 처리 가능 => 애초에 예외가 발생하지 않게끔 소스코드로 핸들링 
	 *  - 예외 처리 구문(try~catch)으로 해결 가능 => 예외가 발생했을 때 에러 대신 실행할 구문을 미리 정의해두는 것
	 * 
	 * 코드로 에러를 예측이 가능한 상황에서는 "조건문"으로 해결하는 것을 권장.
	 * 예측이 불가능한 상황 => 예외 처리 구문으로 해결. 
	 * 
	 * RuntimeException계열은 충분히 예측이 가능한 상황이기 때문에 조건문으로 해결하는 것을 권장하며,
	 * "예외처리가 필수가 아니다" => UncheckedException
	 * */
	
	
	
	
	
	
	
	
	

}
