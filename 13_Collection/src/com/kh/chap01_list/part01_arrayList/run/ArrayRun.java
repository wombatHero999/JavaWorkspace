package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;

public class ArrayRun {
	
	/* 
	 * 컬렉션(Collection)
	 *  자료구조가 내장되어 있는 클래스로 자바에서 제공하는 자료구조를 담당하는 프레임워크이다.
	 * 
	 *  자료구조 
	 *   방대한 데이터들을 효율적으로 다루기 위한 개념
	 *   
	 *  프레임워크
	 *   효율적인 기능들이 정의되어있는 틀
	 *   
	 *  데이터들이 새로 추가되거나, 삭제되거나, 수정이되는 기능들이 이미 정의된 틀이다.
	 *  
	 *  배열과 컬렉션의 차이점
	 *  - 배열의 단점
	 *  1. 배열을 쓰고자 할 때 먼저 크기를 지정해줘야 함.
	 *  2. 한번 지정된 크기는 변경이 불가능하다.
	 *  3. 배열의 중간위치에 새로운 데이터를 추가하거나, 삭제하고자 하는 경우 그 값들을 땡겨오기위한 코드를 직접
	 *     짜야함
	 *  4. 한 타입의 데이터만 저장가능하다.
	 *  
	 *  - 컬렉션의 장점
	 *  1. 크기에 제약이 없다.
	 *  2. 중간위치쯤의 값을 추가,삭제시 뒤쪽의 값들을 밀어내거나, 앞으로 땡겨오는 코드가 구현이 되어있음.
	 *  3. 여러타입의 데이터를 저장할 수 있다.(단, "제네릭" 설정을 통해 하나의 타입의 데이터만 들어가게 설정이 가능)
	 * 
	 * 컬렉션의 3가지 분류
	 * List계열 : 담고자하는 값(value)만 저장 / 값 저장시 저장순서를 유지(index 관리) / 중복값 허용
	 *  ex) ArrayList , Vector , LinkedList 
	 * Set계열 : 담고자하는 값(value)만 저장 / 값 저장시 순서를 유지하지 않는다(index x) / 중복값 x
	 *  ex) HashSet, TreeSet
	 * Map계열 : 담고자 하는 값(value)과 이값을 저장하는 키(key)를 함께 저장 / 저장순서 x / 중복값 허용
	 *         단 key를 제외하고 value값만 중복 허용
	 *  ex) HashMap, HashTable, Properties , TreeMap
	 * */
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // 크기 10짜리 객체배열이 생성
		Object [] arr = new Object[2];
		
		arr[0] = 1;
		arr[1] = "안녕";
		
		list.add(1);
		list.add("안녕");
		
		System.out.println(list);
		System.out.println(arr);
		
	}
	
	
	
	
}
