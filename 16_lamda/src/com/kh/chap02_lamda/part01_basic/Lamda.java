package com.kh.chap02_lamda.part01_basic;

import com.kh.chap02_lamda.model.functionalInterface.LamdaTest1;

public class Lamda {
	/* 
	 * 함수형 프로그래밍 && 람다식
	 * 
	 * 객체지향 프로그래밍(OOP) ? 객체를 통해 상호작용하는 프로그래밍 방식
	 *  OOP에서는 내가 만들고자하느 기능이 있는경우 반드시 클래스를 먼저 만들고, 기능을 구현해야하며
	 *  기능 호출시에도 객체를 먼저 만들고 호출해야한다. 
	 *  
	 * 함수형 프로그래밍(FP) ? 함수를 기반으로 코드를 작성하고 함수만 호출하여 동작하는 프로그램을 만드는
	 *   프로그래밍 방식. OOP보다 작성해야하는 코드의 수가 줄어들어 빠른 개발이 가능
	 *   
	 * 자바에서는 함수형 프로그래밍도 추가로 지원하기 위해 JDK8버전 이후 추가되었다.
	 * 자바에서 함수형 프로그래밍을 지원하기 위해 제공한 문법을 람다식(Lamda Expression)이라고 부름. 
	 * 
	 * 람다식?
	 *  - 자바에서 FP을 위해 함수를 간결하게 표현하는 방법.
	 *  - 함수이지만 함수이름이 없는 "익명함수"의 구조를 가지고 있다.
	 *  - 1회용으로 사용할 함수에서 불필요한 부분(메소드명 , 접근제한자 등)을 걸러낸 후 간결하게 표현.
	 *  - 사용방법이 많아 연습이 필요한 문법. 
	 *  
	 *  [표현법]
	 *  (매개변수) -> {구현코드}
	 *  
	 *  [적용예시]
	 *  1. 일반 메서드
	 *  int add(int x , int y){
	 *  	return x+y;
	 *  }
	 *  
	 *  2. 람다식 메세드
	 *  // 메소드명 생략, 반환형생략 , return예약어 + {},  , 매개변수의 자료형
	 *  (int x , int y) -> x + y;
	 *  (int x , int y) -> {return x + y};
	 *  (x, y) -> x+y;
	 * */	
	int add(int x , int y) {
		return x+y;
	}
	
	//(x, y) -> x+y;
	public static void main(String[] args) {
		// 익명 내부클래스로 함수 구현.
		LamdaTest1 lamda1 = new LamdaTest1() {
			@Override
			public int add(int x, int y) {
				return x+y;
			}
		};
		int result = lamda1.add(1, 5);
		System.out.println(result);
		
		// 람다식은 익명내부클래스를 더욱 간결화시킨 문법.
		// 익명클래스 구현과정에서 함수형프로그래밍에 필요한 "함수"부분만 제외하고 모두 제거한것.
		// 즉 람다식은 익명클래스 생성과 추상메소드 구현을 동시에 하면서
		// 메소드의 불필요한 부분은 제거한 것. 
		// 따라서 람다식은 사실 익명클래스 이지만 구현시에는 함수의 몸통부분만 표시하는것 처럼 보이므로
		// "익명함수"라고 부름
		LamdaTest1 lamda2 = (x , y) -> {return x+y;}; // 익명내부클래스 -> 람다식
	}
	
	
	
}
