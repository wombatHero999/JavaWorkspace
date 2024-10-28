package com.kh.chap01_innerClass.part02_static;

import com.kh.chap01_innerClass.part02_static.builder.Member;

public class Run {
	public static void main(String[] args) {
		// 매개변수 생성자를 통한 Member객체 생성
		//Member m = new Member("alsrudals","경민",32,41213393);
		
		// 기본생성자로 객체 생성 후 setter를 활용한 초기화.
//		Member m2 = new Member();
//		m2.setId("alsrudals");
//		m2.setName("경민");
//		m2.setAge(33);
//		m2.setPhoneNumber(4444);
		// m2.getName();
		
		// 빌더패턴을 통해 객체 생성
		Member member = new Member.Builder("alsrudals")
					.age(25)
					.name("경민")
					.phoneNumber(1111)
					.build();
	}
	
	
	
	
	
	
	
	
	
	
}
