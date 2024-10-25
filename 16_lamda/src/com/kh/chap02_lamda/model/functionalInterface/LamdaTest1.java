package com.kh.chap02_lamda.model.functionalInterface;

/* 
 * 람다식은 반환형, 메서드명, 매개변수의 자료형, return등의 정보를 생략할 수 있지만,
 * 그 생략하고자하는 원형의 메서드가 어딘가에 존재해야한다.
 * 
 * 생략되는 정보는 원형 메소드에서 얻어오고, 실제 실행시킬 코드는 람다식을 통해 재정의 하므로
 * 원형메소드는 몸통부분이 없는 추상메소드로 구현한다.
 * 
 * 람다식으로 활용되는 인터페이스들은 모두 1개의 메소드만 가질 수 잇따.
 * 람다식을 통해 구현될 메소드가 무었인지 판단하게 하기 위함.
 * */
@FunctionalInterface // 인터페이스가 1개의 추상메소드만 가지고 있는지 검사하는 주석.
public interface LamdaTest1 {

	int add(int x, int y);// 코드구현은 람다식으로.
	//int add2(int x, int y, int z);
}






