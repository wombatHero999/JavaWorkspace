package com.kh.array;

import java.util.Arrays;

public class B_ArrayCopy {
	/* 
	 * 배열 복사
	 * - 얕은 복사 : 주소값만 복사
	 * - 깊은 복사 : 동일한 새로운 배열을 생성해서 실제 "내부"값을 복사
	 * */
	
	public static void main(String[] args) {
		B_ArrayCopy bac = new B_ArrayCopy();
		bac.method5();
	}
	
	//얕은 복사
	public void method1() {
		
		//원본배열 셋팅
		int[] origin = /*new int[]*/{1,2,3,4,5};
		
		System.out.println("== 원본 배열 출력 ==");
		for(int i = 0; i<origin.length; i++) {
			System.out.print(origin[i]+" ");
		}
		
		int[] copy = origin;
		System.out.println("\n== 복사본 배열 출력 ==");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i]+" ");
		}
		
		copy[2] = 99;
		System.out.println("\n 수정 후 ");
		
		System.out.println("== 원본 배열 출력 ==");
		for(int i = 0; i<origin.length; i++) {
			System.out.print(origin[i]+" ");
		}
		
		System.out.println("\n== 복사본 배열 출력 ==");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i]+" ");
		}
	}
	
	public void method2() {
		// 깊은복사
		// 1. for문을 통한 복사
		int[] origin = {1,2,3,4,5};
		
		int[] copy = new int[origin.length];
		
		for(int i = 0; i<copy.length; i++) {
			copy[i] = origin[i];
		}
		System.out.println(Arrays.toString(copy));
	}
	
	public void method3() {
		//2. System에서 제공하는 arraycopy메소드 사용
		int[] origin = {1,2,3,4,5};
		int[] copy = new int[10];
		
		//System.arraycopy( 원본배열 , 
		// 원본배열에서 복사를 시작하고자하는 인덱스, 
		// 복사본 배열, 
		// 복사본 배열의 복사를 시작할 인덱스, 
		// 복사할 갯수);
		System.arraycopy(origin, 3, copy, 4, 2);
		
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
	}
	
	public void method4() {
		// 3. Arrays 클래스에서 제공하는 copyof메소드
		int[] origin = {1,2,3,4,5};
		
		// 복사본 배열 = Arrays.copyof(원본배열, 복사할갯수);
		int[] copy = Arrays.copyOf(origin, origin.length);
		
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
	}
	
	public void method5() {
		// 4. clone메소드를 사용
		
		int[] origin = {1,2,3,4,5};
		
		int[] copy = origin.clone();
		
		copy[2] = 100;
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
		
	}
	
}













