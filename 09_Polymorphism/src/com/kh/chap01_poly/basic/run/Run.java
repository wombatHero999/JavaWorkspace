package com.kh.chap01_poly.basic.run;

import com.kh.chap01_poly.basic.model.vo.Child1;
import com.kh.chap01_poly.basic.model.vo.Child2;
import com.kh.chap01_poly.basic.model.vo.Parent;

public class Run {
	public static void main(String[] args) {
		
		// 1. 부모타입 변수로 부모타입 객체를 생성후 저장.
		Parent p1 = new Parent();
		p1.printParent();
		
		System.out.println("===========================================");
		// 2. 자식타입 변수로 자식타입 객체를 생성후 저장
		Child1 c1 = new Child1();
		//((Parent)c1).printParent();
		c1.printParent(); // 업캐스팅 -> 자식에서 부모클래스의 메소드를 호출하는 경우 발생.
		c1.printChild1();
		
		System.out.println(p1);
		
		System.out.println("===========================================");
		Parent p2 = /*(Parent)*/ new Child1(); // 다형성이 적용된 개념
		// = 기준 양쪽의 자료형이 다름에도 불구하고 에러가 x
		// ? Child1객체가 Parent자료형으로 자동형변환(업캐스팅)이 발생하고 있기 때문에.
		// 업캐스팅은 상속구조에서만 발생.
		
		p2.printParent();
		//(Child2) p2;
		((Child1) p2).printChild1(); // 강제형변환(다운캐스팅)
		
		/* 
		 * 클래스간에서도 형변환 가능(단, 상속구조일때만)
		 * 
		 * 1. UpCasting
		 *      자식타입 -> 부모타입으로 형변환 
		 *      - 생략가능(자동형변환)
		 *      ex) 부모자료형 변수 = 자식객체
		 *          자식객체.부모메서드();
		 * 
		 * 2. DownCasting
		 *      부모타입 -> 자식타입으로 형변환
		 *      - 생략 불가능(강제 형변환 해야함)
		 *      ex)  (자식) 부모변수
		 * 
		 * 다형성을 쓰는 이유 ? 
		 *  - 효율적으로 사용하기위해
		 *  - 부모타입으로부터 파생된 여러가지 타입의 자식 객체들을 하나의 부모클래스로 다루기 위해서.
		 * */
		
		// Chil1 객체, child2객체를 동시에 다루는 상황
		Child1[] arr = new Child1[2];
		arr[0] = new Child1(1);
		arr[1] = new Child1(2);		
		
		Child2[] arr2 = new Child2[2];
		arr2[0] = new Child2(3);
		arr2[1] = new Child2(4);
		// 다형성 개념이 적용되지 않았다면 관리해야하는 자식 객체의 수만큼 많은 배열을 선언해줘야한다.
		
		// 다형성 개념이 적용된다면, 부모타입의 변수하나로 모든 자식 객체를 관리할 수 있다.
		System.out.println("========================================");
		Parent[] arr3 = new Parent[4];
		arr3[0] = new Child1(5);
		arr3[1] = new Child2(10);
		arr3[2] = new Child1(15);
		arr3[3] = new Child2(20);
		
		
//		((Child1)arr3[0]).printChild1();
//		((Child2)arr3[1]).printChild2();
//		((Child1)arr3[2]).printChild1();
//		((Child2)arr3[3]).printChild2();
		
		System.out.println("==== 반복문 ====");
		
		for(Parent p : arr3 ) {
//			if(p instanceof Child1) { // p가 Child1클래스로부터 생성된 객체라면				 
//				((Child1) p).printChild1();
//			}else if(p instanceof Child2) {
//				((Child2) p).printChild2();
//			}else {
//				System.out.println("Child1도 아니고 Child2도 아닙니다.");
//			}
			
			p.print();
			
			/* 
			 * * 동적바인딩 : 프로그램이 실행되기전에 자동으로 컴파일되면서 정적바인딩이 발생.
			 *   단, 실질적으로 참조하고 있는 자식클래스에 정적으로 바인된 메소드가 "오버라이딩"되어 있다면
			 *   프로그램 실행시 동적으로 오버라이딩된 메소드를 찾아서 실행.
			 *   (적혀있기로는 Parent의 print를 실행한다고 했지만, 실제 실행은 자식의 print()메소드가
			 *    실행됨)
			 * */
		}
	}
}
