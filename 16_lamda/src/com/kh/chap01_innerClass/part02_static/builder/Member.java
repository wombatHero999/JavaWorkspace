package com.kh.chap01_innerClass.part02_static.builder;

public class Member {

	/* 
	 * 빌더패턴? 
	 *  - 자바에서 setter메서드나, 매개변수 생성자를 통해 생성하는 객체생성방식의 단점을 보완해주는 객체생성
	 *    설계패턴.
	 *  - 정적내부클래스를 이용하였는데, 외부클래스 객체를 정적내부클래스에서 반환해주는 방식으로 설계되어 있다.
	 *  - 빌더패턴은 항상 사용하는게 아니라, 초기화할 필드가 많은 경우 사용을 고려하는게 좋다.
	 *  - 롬복이라는 프레임워크에서 @Builder으로 손쉽게 자동구현이 가능하다.
	 *  
	 *  기존 객체생성 방식 
	 *  1) 매개변수 생성자를 이용한 객체 생성 및 초기화
	 *     - 객체를 생성할 때 매개변수에 객체가 필요로 하는 데이터를 넣어준 후 객체를 생성.
	 *     
	 *     단점 ?
	 *      1. 필드가 많을 수록 필요한 생성자의 갯수가 많아질 수 있다.
	 *      2. 매개변수의 정보를 설명할 수 없기 때문에 잘못된 위치에 데이터가 추가될 위험이 있다.
	 *         즉 가독성이 나쁨.
	 *     
	 *  2) 객체 생성후 setter를 활용한 초기화
	 *     매개변수 생성자를 이용한 방법과 비교했을 때 가독성은 확보가 되나, 코드의 길이가 증가하게 된다.
	 *  
	 *  빌더패턴은 위 생성방식들의 단점을 보완하였다.
	 * */
	
	private String id; // 필수
	private String name; // 필수
	private int age; // 옵션
	private int phoneNumber;//옵션
	
	private Member() {
		
	}
	
	public static class Builder {
		private String id;
		private String name;
		private int age;
		private int phoneNumber;
		
		public Builder(String id) { // 필수변수는 생성자로 대입
			this.id = id;
		}
		
		public Builder age(int age) { // set함수의 역할
			this.age = age;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder phoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		// 빌드메소드.
		// 초기화된 내부의 값들을 외부클래스의 객체에 전달후 반환하는 메서드
		public Member build() {
			Member member = new Member();
			if(this.id == null) {
				return null; 
			}
			member.id = this.id;
			member.name = this.name;
			member.age = this.age;
			member.phoneNumber = this.phoneNumber;
			
			return member;
		}
	}
	
//	public Member(String id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//
//	public Member(String id, String name, int age) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
	
//	public Member(String id, String name, int phoneNumber) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//	}

//	public Member(String id, String name, int age, int phoneNumber) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.phoneNumber = phoneNumber;
//	}

//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public void setPhoneNumber(int phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	
	
}











