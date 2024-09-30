package com.kh.cha1_encaps.run;

import com.kh.cha1_encaps.model.vo.Student;

public class Run {
	
	public static void main(String[] args) {
		/*
		 * 캡슐화 ?
		 *  추상화를 통해 정의된 속성과 기능들을 하나로 묶어서 관리하는 기법중 하나.
		 *  클래스에서 가장 중요한 목적중 하나인 "데이터의 접근제한"을 원칙으로 외부로 부터 "데이터의 접근"을 막고
		 *  대신 "데이터에 간접적으로"접근하여 값을 처리하는 메소드를 클래스 내부에 작성하는 관리방법.
		 *  
		 * 
		 * 1) 정보은닉 ? private
		 *    필드들을 외부로부터 직접 접근을 막기 위해 public대신 private접근제한자를 사용
		 *    
		 * 2) setter / getter 메소드 사용
		 *    간접적으로나마 접근하여 값을 담거나 그 값을 가져올 수 있는 메소드.
		 *  */
		Student hong = new Student();		
		hong.setName("홍길동");		
		hong.setAge(15);
		hong.setHeight(175.5);
		
		System.out.println(hong.getName());
		String info = hong.information();
		
		//System.out.println(info);
		System.out.println(hong.information());
		
		
		
		
	}
}




