package com.kh.chap01_innerClass.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kh.chap01_innerClass.part04_anonymous.OuterClass;

//import com.kh.chap01_innerClass.part03_local.OuterClass;

//import com.kh.chap01_innerClass.part01_instance.OuterClass;

public class Run {
	public static void main(String[] args) {
		/* 
		 * 내부클래스?
		 * 클래스 "내부"에 선언한 클래스
		 * 내부클래스는 외부클래스와 밀접한 관련이 있으면서, 그 밖에 다른 클래스들과는 서로 사용할 일이 없는 경우
		 * 내부클래스로 선언하여 사용한다.
		 * 
		 * 내부클래스의 종류?
		 * 1) 인스턴스 내부 클래스
		 * 2) 정적 내부 클래스
		 * 3) 지역 내부 클래스
		 * 4) 익명 내부 클래스
		 * 
		 * */
		//OuterClass oc = new OuterClass();
		//OuterClass.Inner oci  = oc.new Inner(); 
		//oc.outerMethod();
		
//		OuterClass oc3 = new OuterClass();
//		Runnable r3 = oc3.getRunnable(0);
//		Thread t1 = new Thread(r3);
//		t1.start();
		
		OuterClass oc4 = new OuterClass();
		Thread th1 = new Thread(oc4.runner, "필드");
		Thread th2 = new Thread(oc4.getRunnable("메서드"));
		
		th1.start();
		th2.start();
		
		// ArrayList 생성 및 초기화.?
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<10; i++) {
			list.add(i);
		}
		
		// ArrayList를 상속받은 익명 클래스 만들기
		List<Integer> list2 = new ArrayList<Integer>() {
			{ // 초기화 블럭
				for(int i =0; i<10; i++) {
					add(i);
				}
			}
			// 메서드 재정의 가능
			public boolean add(Integer e) {
				return true;
			}
		};
		
		// 3) 앞으로 자주 사용할 메서드들..
		//  - Arrays.asList(T ...a) : ArrayList -> 크기가고정된 arrayList
		// ...? 가변인자
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		List<Integer> list3 = Arrays.asList(arr);
		//List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//list3.add(11); 기존 ArrayList와 달리 값의 추가를 막아둠.
		//list3.remove(0); 삭제 불가.
		list3.set(0, 190); // 데이터 수정은 가능. 크기만 고정
		System.out.println(list3);
		
		// 4) List.of(E ...elements) : List -> 값이 추가,수정,삭제되지 않는 ArrayList
		List<Integer> list4 = new ArrayList<>(  List.of(1,2,3,4,5) ); // 데이터 수정,삭제가능
		List<Integer> list5 = List.of(1,2,3,4,5);
		
		//list5.add(1);
		//list5.remove(0);
		//list5.set(0, 11);
		
		/* 
		 * 내부클래스의 종류별 특징
		 * 
		 * 1) 인스턴스 내부 클래스
		 *     구현위치 : 필드와 동일한 위치에 구현
		 *     생성시기 : 외부 클래스의 객체가 생성되는 순간 생성 
		 *     사용가능한 변수 : 외부클래스의 필드 및 static 모두 사용가능.
		 * 2) 정적 내부 클래스
		 *     구현위치 : 필드와 동일한 위치에 구현
		 *     생성시기 : 프로그램시 즉, 외부클래스와 무관하게 생성
		 *     사용가능한 변수 : 외부클래스의 static변수만 사용가능.
		 * 3) 지역 내부 클래스
		 *     구현위치 : 메서드내부에 구현
		 *     생성시기 : 메서드실행시 생성
		 *     사용가능변수 : 외부클래스의 필드 및 static변수
		 * 4) 익명 내부 클래스
		 *     구현위치 : 메서드 내부 혹은 변수에 직접 대입하여 구현
		 *     생성시기 : 메서드 호출혹은 변수에 값이 대입될때 생성
		 *     사용가능한변수 : 외부클래스의 필드 및 static변수
		 * */
	}
	
	
	
}
