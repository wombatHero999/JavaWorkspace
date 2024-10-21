package com.kh.chap05_generic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class GenericRun <T> {
	// 매서드(매개변수)
	// 클래스<매개변수>
	
	/* 
	 * 1. Generic ? 
	 *  데이터의 자료형을 "일반화" 시키는 방법.
	 *  변수의 선언, 메서드의 매개변수를 "하나"의 자료형이 아닌 "여러" 자료형으로 변환 될 수 있게 프로그래밍이가능.
	 *  실제 사용되는 참조자료형으로의 변환을 "컴파일러"가 검증하는 안정적인 프로그래밍 방식이다.
	 *  
	 * 2. Generic 사용 & 설정방법
	 *  여러 참조자료형으로 대체될 수 있는 부분을 "하나의 문자"로 일반화시켜 표현다. 
	 *  ex) <T, G, K , V, E ....>
	 *  여러 참조자료형 값을 저장할수 있기 때문에 자료형 매개변수, 타입변수라고도 불린다.
	 * */	
	T t;
	
	public static void main(String[] args) {
		GenericRun<String> s = new GenericRun<>(); // 컴파일 시점에 T == String
		s.t = "문자열만 가능";
		//s.t = 1000;
		
		GenericRun<Integer> s2 = new GenericRun<>();// 컴파일 시점에 T == Integer로 변환
		s2.t = 1000;// 정수만 가능
		//s2.t = "문자열 저장";
		
		// 제네릭 등장 이전
		List l = new ArrayList(); // Object[]이므로 어떤 데이터든 추가 가능(업캐스팅)
		
		for(Object o : l){
			System.out.println(o); // 해당 데이터를 꺼낼때 어떤 자료형의 데이터 담겨있는지 판단 불가.
			
			// Music객체가 담겨있다고 가정한다면
			Music m = (Music) o; // 제네릭을 사용하지 않는다면 하나하나 직접 형변환을 해줘야 하며
			// 담긴 데이터가 Music임을 보장할 수 없다.
			System.out.println(m.getArtist());
		}
		
	}

	public T method1(T t) {
		return t;
	}
	
	
	
}
