package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.kh.chap01_list.part01_arrayList.model.compare.MusicComparator;
import com.kh.chap01_list.part01_arrayList.model.vo.Music;

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
		/* 
		 * 제네릭<E>
		 * 별도의 제네릭 없이 컬렉션객체를 생성하면 기본값으로 Object 객체를 담을 수 있는 ArrayList가
		 * 생성됨.
		 * 
		 * 제네릭을 제시하여 컬렉션 객체를 생성하면 해당 제네릭 타입에 맞는 데이터만 ArrayList에 담을 수 있음
		 * 
		 * 제네릭을 설정 하는 이유
		 * 1. 명시한 타입의 데이터만 저장 가능하도록 제한하기 위해서.
		 * 2. 제네릭을 제시하지 않는 경우 저장된 데이터를 꺼내서 사용할때 번거로운 형변환 절차를 거쳐야
		 *    하기 때문에.
		 * */
//		ArrayList<String> list = new ArrayList<String>(); // 크기 10짜리 객체배열이 생성
//		Object [] arr = new Object[2];
//		
//		arr[0] = 1;
//		arr[1] = "안녕";
//		
//		list.add("1");
//		list.add("안녕");
//		
//		System.out.println(list);
//		System.out.println(arr);
		
//		ArrayList<Music> list = new ArrayList<Music>();
		ArrayList<Music> list = new ArrayList();
		
		// 1. add(E e) : 해당 리스트의 "끝"에 전달된 e를 추가 시켜주는 메소드
		list.add(new Music("바다의 왕자","박명수"));
		list.add(new Music("흔들리는 꽃","장범준"));
		list.add(new Music("노래방에서","장범준"));
		System.out.println(list);
		
		// 2. add(int index, E e) : 리스트에 전달되는 index값 위치에 e를 추가시켜주는 메소드
		list.add(0, new Music("고백","장범준"));
		// 중간에 값 추가시 기존의 값들이 사라지지않고 뒤로 밀려난다.
		System.out.println(list);
		
		// 3. set(int index, E e) : 리스트에 index위치의 값을 전달되는 e로 변경시켜주는 메소드
		list.set(1, new Music("일산으로","장범준"));
		System.out.println(list);
		
		// 4. remove(int index) : 리스트에 index위치의 값을 삭제시켜주는 메소드
		list.remove(1);
		System.out.println(list);
		
		// 5. size() : 리스트에 담겨있는 "초기화된" 데이터의 수를 반환해주는 메소드
		System.out.println("리스트에 담긴 데이터 수 : " + list.size());
		System.out.println("리스트의 마지막 인덱스 : " + (list.size() - 1));
		
		// 6. get(int index) : 리스트에 index위치에 담겨잇는 데이터를 반환해주는 메소드
		//제네릭 미 설정시
		//Music m = (Music) list.get(0); // 다운캐스팅이 필수
		//System.out.println("0번 위치의 값 : "+m.getTitle());
		//System.out.println("1번 위치의 값 : "+ ((Music)list.get(1)).getArtist() );
		
		System.out.println("2번 위치의 값 "+list.get(2));
		
		// 7. contains(E e) : list안에 e값이 포함되어있는지 확인.
		// 두 객체의 주소값 비교시 항상 false
		System.out.println(list.contains(new Music("고백","장범준")));
		
		// 8. indexOf(E e) : list안에 e값이 몇번째 index에 있는지 확인
		// 일치하는 값이 없을경우 -1반환
		System.out.println(list.indexOf(new Music("고백","장범준")));
		
		System.out.println("=====================================================");
		
		// 0번 ~ 마지막 인덱스의 값까지 출력
		// 1. basic for
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 2. for each문
		for( Music m2    :  list   ) {
			//m2.equals("1234");
			System.out.println(m2);
		}
		
		// 3. Iterator 반복자 : 내부 값들을 Iterator를 통해 관리
		Iterator<Music> iter = list.iterator();
		while(iter.hasNext()) {
			Music mu = iter.next();
			System.out.println(mu);
		}
		System.out.println("=========================================");
		// 9. subList(int index1, int index2) : 리스트에서 index1부터 index2까지의
		//    데이터를 추출하여 새로운 List를 반환시켜주는 메소드
		
		List<Music> sub = list.subList(0, 2); // [0 , 1] 
		System.out.println("sub 리스트 : "+sub);
		
		// 10. addAll(Collection c) : 리스트에 다른 컬렉션에 있는 데이터들을 통째로 추가해주는 메소드.
		list.addAll(sub);
		System.out.println(list);
		
		// 11 .isEmpty() : 리스트가 비어있는지 묻는 메소드(비어있다면 true/ 아니라면 false)
		System.out.println("리스트가 비어있습니까? "+list.isEmpty());
		
		// 12. Collections.sort(List list) : 정렬메서드
		List<String> list2 = new ArrayList<>();
		list2.add("가경민");
		list2.add("다경민");
		list2.add("라경민");
		list2.add("나경민");
		
		System.out.println(list2);
		
		//Collections.sort(list2); 
		//System.out.println(list2); 
		
		// 13. 내림차순 정렬
		Collections.reverseOrder(); // 역정렬 기준을 가진 객체
		Collections.sort(list2 , Collections.reverseOrder());
		System.out.println(list2);
		
		/* 
		 * 내가 정의한 객체를 정렬하기 위해서는 각 객체별 "정렬기준"을 새롭게 메서드로 만들어 줘야 한다.
		 * 
		 * 객체 정렬방법
		 * 
		 * 1. Comparable 인터페이스 
		 *  각 클래스의 "기본정렬방법"을 구현.
		 *  객체를 정렬시킬때 내부적으로 활용되는 compareTo 메소드를 오버라이딩
		 *  compareTo(Object other) ? 
		 *  매개변수로 들어온 객체와, 자기자신(this)을 비교하는 메서드
		 * 
		 * 2. Comparator 인터페이스 
		 *  기본정렬외에 추가로 정렬기준을 제시하고 싶은 경우 사용.
		 *  많은 정렬기준을 만들고 싶을때 사용하며, 별도의 Comparator인터페이스를 구현한 클래스를 작성해야함.
		 *  compare메소드 오버라이딩 
		 *  compare(Object o1 , Object o2) ?
		 *  매개변수로 전달된 두 객체를 비교함.
		 * */
		
		// Comparable 인터페이스를 활용한 클래스의 "기본정렬" 구현
//		Collections.sort(list);
//		System.out.println(list);
		
		// Comparator 인터페이스를 활용한 정렬
		// Comparator mc = new MusicComparator();
		Collections.sort(list, new MusicComparator().reversed() ); // reversed : 정렬기준을 반대로
		System.out.println(list);
		
		// 14. sort(Comparator c) : Comparator의 정렬기준에 맞춰 리스트를 정렬시켜주는 메소드
		list.sort(new MusicComparator());
		
		System.out.println(list);
		
		// 15. Collections.shuffle(list, Random e) : list내부의 데이터를 섞어주는 메서드
		Collections.shuffle(list, new Random());
		System.out.println(list);
		
		// 향상된 반복문을 사용하는 도중 Collection의 index순서가 변경되면 에러가 발생.
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		
		// 반복문을통해 컬렉션에담긴 요소가 1이라면 삭제하시오
//		int count = 0;
//		for(int i : list3) {
//			if( i == 1) { // 현재 반복중인 인덱스의 값(i)이 1과 같다면
//				//삭제
//				list3.remove(count);
//			}
//			count++;
//		}
//		System.out.println(list3); // [1, 1, 2, 3, 4]
//								   // [1, 2, 3, 4]
//		for(int i =0; i<list3.size(); i++) {
//			if(list3.get(i) == 1) { // i번째 인덱스의 값이 1과 같다면
//				list3.remove(i);
//				i--;
//			}
//		}
//		
//		System.out.println(list3);
		
		Iterator<Integer> iter2 = list3.iterator();
		while(iter2.hasNext()) {
			int s = iter2.next();
			if(s == 1) {
				iter2.remove(); // 현재 Collection의 요소를 제거
			}
		}
		
		System.out.println(list3);
	}
	
	
	
	
}
