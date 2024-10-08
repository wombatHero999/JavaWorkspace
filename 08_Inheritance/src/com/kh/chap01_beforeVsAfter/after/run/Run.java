package com.kh.chap01_beforeVsAfter.after.run;

import com.kh.chap01_beforeVsAfter.after.model.vo.*;

public class Run {
	
	public static void main(String[] args) {
		Desktop d = new Desktop("삼성","d-02","삼성데스크탑",1500000,true);
		SmartPhone sp = new SmartPhone("삼성","s-02","z플립 4" , 500000,"KT");
		Tv t = new Tv("LG", "T-02", "슬림TV",3500000,60);
		
		System.out.println(d.information());
		System.out.println(sp.information());
		System.out.println(t.information());
		
		/* 
		 * 상속의 장점
		 *  - 적은양의 소스코드로 새로운 클래스들을 작성 가능
		 *  - 중복된 코드를 공통으로 관리하기 때문에 새로운 코드를 추가, 수정시 용이
		 *  - 정의해둔 부모클래스를 통해 더 쉽게 다른클래스로 확장이 가능해짐.
		 * 
		 * 
		 * 상속의 특징
		 *  - 클래스간의 상속은 다중상속이 불가능하다.
		 *  - 명시되어있지 않지만 모든 클래스는 Object클래스의 후손이다.
		 * */
		
	}

	
	
	
	
	
}
