package com.kh.cha1_encaps.model.vo;

//import java.lang.*;

public class Student {
	// 필드
	// 필드 == 멤버변수 == 인스턴스변수
	private String name;
	private int age;
	private double height;
	
	// 메소드부
	// 메소드의 구조
	// 접근제한자 반환형 메소드명([매개변수]){
	//   //기능구현
	// }
	
	// setter메소드
	// 모든 set/get메소드는 접근이 가능하도록 public 접근제한자를 사용함.
	
	// 이름에 적힌 값을 수정할 수 있는 메소드
	public void setName(String name) {		
		// 인스턴스변수 = 매개변수 ? 
		this.name = name;
		// this는 생성된 객체의 주소값을 보관하는
		// 보이지 않는 필드
	}
	
	// 이름에 저장된 값을 "반환"해주는 메소드
	public String getName() {
		return name;
	}
	
	// age필드에 값을 저장(set) / 조회(get)하는 함수 작성
	public void setAge(int age) {
		this.age = age;
		System.out.println(getName());
	}
	
	public int getAge() {
		return age;
	}
	
	//height필드에 값을 저장/조회하는 함수 작성
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	// 현재 객체에 초기화된 인스턴스변수들을 문자열로 합쳐서 반환해주는 메서드
	public String information() {
		return name+"님의 나이는 "+age+"이고, 키는 "+height+"입니다."; 
	}
}








