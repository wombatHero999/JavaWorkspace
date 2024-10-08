package com.kh.chap02_absAndInter.part01_basic.run;

import com.kh.chap02_absAndInter.part01_basic.model.vo.Basketball;
import com.kh.chap02_absAndInter.part01_basic.model.vo.Football;
import com.kh.chap02_absAndInter.part01_basic.model.vo.Sports;

public class BasicRun {
	public static void main(String[] args) {
		
		Sports s;
		
		// s  = new Sports(); //추상 클래스는 객체 생성이 불가.
		// s.rule();
		
		// 다형성(업캐스팅)을 적용하여 자식객체를 저장
		s = new Football();
		s.rule();
		
		s = new Basketball();
		s.rule();
		
		/* 
		 * 추상클래스 정리
		 *  - 미완성된 클래스 abstract class
		 *  - 객체생성이 불가(미완성된 메소드가 존재하기 때문)
		 *  - 레퍼런스 변수로는 사용이 가능
		 *  - 추상메소드가 존재하는 순간 해당 클래스는 추상클래스로 정의해야한다.
		 *  - 단, 추상메소드가 없더라도 추상 클래스로 둘 수 있음.
		 * 
		 * 추상메소드 정리
		 *  - 미완성된 메소드로 몸통부({})가 구현되어있지 않은 메소드
		 *  - 자식클래스에서 오버라이딩을 통해 완성됨(오버라이딩이 강제됨)
		 *    => 오버라이딩하지 않을 경우 에러발생
		 *  - 메소드 사용의 통일성을 확보 할수 있고 표준화된 틀을 제공할 수 있다.
		 * 
		 * */
		
		
		
		
	}
	
	
	
	
}
