package com.kh.chap2_constructor.run;

import com.kh.chap2_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		
		// 1. 기본생성자 호출
		User u1 = new User();
		u1.setUserId("user01");
		u1.setUserPwd("pass01");
		u1.setUserName("김갑생");
		
		//String info = u1.information();
		System.out.println(u1.information());
		
		// 2. 매개변수 있는 생성자 호출(3개짜리)
		User u2 = new User("user02","pass02","홍길동");
		u2.setAge(40);
		u2.setGender('남');
		System.out.println(u2.information());
		
		// 3. 매개변수 5개 있는 생성자로 객체 생성
		User u3 = new User("user03","pass03","민경민",35,'남');
		System.out.println(u3.information());
	}
	
	
	
	
	
}
