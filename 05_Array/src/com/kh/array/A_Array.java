package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {
	/* 
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있음.
	 * 
	 * 배열 : 하나의 공간에 여러개의 값을 담을 수 있음(같은 자료형만.)
	 *      배열의 각 공간에는 인덱스번호가 부여되며 0부터 시작
	 *    ex) int[] a = new int[3];
	 *        // 방 [0] , [1] , [2]  
	 *        // 인덱스는 항상 0부터 시작, 마지막 방번호는 무조건 배열의 길이 -1
	 *        // 크기 = n, 마지막 인덱스 = n -1
	 * */
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		A_Array aa = new A_Array();
		aa.method9();
	}
	
	public void method1() {
		/* 
		 * 1. 배열 선언
		 * [표현법]
		 * 자료형 배열명 [];
		 * 자료형[] 배열명;
		 * 
		 * 2. 배열 할당
		 * 이 배열에 몇개의 값들을 보관할건지 배열의 크기를 지정해주는 과정.
		 * 내가 지정한 갯수만큼의 값이 들어갈 수 있는 방이 생성된다. 
		 * [표현법]
		 * 배열명 = new 자료형[배열크기];
		 * */
		
		int[] arr = new int[5];
		
		//3. 배열의 각 인덱스(방번호) 자리에 값을 대입
		//배열명[0] = 값;
		
		arr[0] = 1111;
		// arr배열의 첫번째 방부터 마지막 방까지 순차적으로 접근.
		for(int i = 0; i < 5; i++) {
			arr[i] = i;
		}
		
		for(int i =0; i< 5;i++) {
			System.out.println("arr의 "+ i +"번째 방에 저장된 값 : "+arr[i]);
		}
		System.out.println(arr);
	}
	
	public void method2() {
		
		int[] iArr= new int[5];
		
		System.out.println("iArr : " + iArr);
		System.out.println("iArr의 해시코드값 : " + iArr.hashCode());
		
		double[] dArr = new double[3];
		
		System.out.println("dArr : "+ dArr);
		System.out.println("dArr의 해시코드값 : " + dArr.hashCode());
	
		String str = "민경민";
		String str2 = "민경민";
		System.out.println("str의 해시코드값 : " + str.hashCode());
		System.out.println("str2의 해시코드값 : " + str2.hashCode());
	}

	public void method3() {
		
		int[] iArr = new int[3];
		double[] dArr = new double[4];
		
		System.out.println(iArr[1]);// 0
		System.out.println(dArr[2]);// 0.0
		
		// 배열의 크기를 아는방법.
		// 배열명.length;
		// 문자열.length();
		System.out.println("iArr의 배열 크기 : " + iArr.length);
		System.out.println("dArr의 배열 크기 : " + dArr.length);
		
		for(int i =0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
	}
	
	public void method4() {
		
		int result = 0;
		
		int[] arr = null;
	
		System.out.println(arr); // null
		//System.out.println(arr.length);
		//System.out.println(arr.hashCode());
	}
	
	public void method5() {
		int[] arr = new int[5];
		/* 
		 * arr[0] = 2;
		 * arr[1] = 4;
		 * arr[2] = 6;
		 * arr[3] = 8;
		 * arr[4] = 10;
		 * 값을 대입 한 후 출력.
		 *  
		 * */
		int value = 2;
		for(int i =0; i < arr.length; i++) {
			arr[i] = value;
			value+=2;
			System.out.println("arr["+i+"] : "+arr[i]);
		}
		
		// arr 변경 전
		System.out.println(arr.hashCode());
		
		arr = new int[5];
		// arr 변경 후
		System.out.println(arr.hashCode());
	}
	
	public void method6() {
		
		// 배열 선언, 할당, 초기화까지 한번에 끝내는 방법
		int[] arr = new int[] {1,2,3,4};
		
		int[] arr2 = {1,2,3,4};
		
		// 주소값이 서로 다르기 때문에
		System.out.println(arr == arr2); // false
	}
	
	public void method7() {
		/* 
		 * 1. 크기 10짜리 정수배열 선언
		 * 2. 반복문을 활용해서 배열의 0번인덱스 ~ 마지막 인덱스까지 값을 대입.
		 *    대입할값 : 1~100사이의 랜덤값
		 * 3. 반복문을 활용해서 배열의 0번인덱스 ~ 마지막 인덱스에 담긴 값을 출력
		 *    출력예시) arr[x] : xx
		 * */
		int[] arr = new int[10];
		
		for(int i =0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100 + 1 );
		}
		
		Arrays.sort(arr);
		
		for(int i =0; i < arr.length; i++) {
			System.out.println("arr["+i+"] : "+arr[i]);
		}
		
	}
	
	public void method8() {
		System.out.print("배열의 길이 : ");
		int size = sc.nextInt();
		
		String[] arr = new String[size];
		
		// 반복문을 활용하여 매번 사용자에게 과일정보를 입력 받은 후 
		// arr배열에 입력받은 과일을 저장
		
		sc.nextLine();
		for(int i = 0; i<arr.length; i++) {
			String fruit = sc.nextLine();
			arr[i] = fruit;
		}
		
		for(int i = 0; i<arr.length; i++ ) {
			System.out.println(arr[i]);
		}
	}
	
	public void method9() {
		/* 
		 * 1. 배열의 길이를 직접 입력한 후 해당 크기만큼의 저장공간을 가진 정수배열을 생성.
		 * 
		 * 2. 반복문을 활용해서 0번 ~ 마지막 인덱스까지 값을 대입
		 *    랜덤값(1~100)
		 * 
		 * 3. 반복문을 활용해서 처음부터 마지막 인덱스까지 배열에 담긴값을 출력함과 동시에 해당 인덱스에 담긴
		 * 값이 짝수인 경우 그 값들의 총 합을 구하기.
		 *    출력예시) arr[x] : xx
		 * 
		 * 4. 짝수값의 합을 출력
		 *    출력예시) 짝수총합 : xx
		 * 
		 * */
		System.out.print("배열의 길이 : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		int sum = 0;
		for(int i =0; i < size; i++) {
			arr[i] = (int)(Math.random() * 100 +1);
			
			System.out.println("arr["+i+"] : "+arr[i]);
			if(arr[i] % 2 == 0) {
				sum += arr[i];
			}
		}
		
		System.out.println("짝수의 총합 : "+sum);
	}
	
	
	
	
	
	
}
