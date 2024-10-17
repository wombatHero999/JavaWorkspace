package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.kh.chap01_list.part01_arrayList.model.compare.MusicComparator;
import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {
	
	/* 
	 * Set : 중복을 허용하지 않는다. 단, 저장된 순서를 보장하지 않는다.
	 *  
	 * LinkedHashSet : 중복을 허용하지 않는다. 저장된 순서를 유지
	 * TreeSet : 중복을 허용하지 않는다. 내부의 값들을 오름차순 정렬시킨다.
	 * */
	
	public static void main(String[] args) {
		
		HashSet<String> hs1 = new HashSet<>();
		
		hs1.add("반갑습니다.");
		hs1.add("반갑습니다.");
		hs1.add("여러분");
		hs1.add("맛저하세요");
		hs1.add("맛저하세요");
		
		System.out.println(hs1); // 저장순서유지 x, 중복값 x
		
		//크기 구하기 : size()
		System.out.println("hs1의 크기 : "+hs1.size());
		
		//삭제 : remove(삭제할 값)
		hs1.remove("여러분");
		
		System.out.println(hs1);
		
		//모든 값 삭제 : clear()
		hs1.clear();
		
		System.out.println(hs1);
		System.out.println("==================================================");
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("공유",40,100));
		hs2.add(new Student("김갑생",27,80));
		hs2.add(new Student("홍길동",24,88));
		hs2.add(new Student("공유",40,100));
		
		System.out.println(hs2);
		// 저장순서유지 x 중복저장 O?
		// 동일한 객체로 판단이 되지 않기 때문. 
		// 값이 추가 될때 equals(), hashCode()로 비교후 두 결과가 모두 true면 동일객체로 판단.
		
		/* 
		 * HashSet에 객체를 담을 때 내부적으로 equals()와 hashCode()를 사용하여 값이 일치하는지 비교.
		 * equals()결과가 true고 hashCode()값이 일치한다면 동일객체로 판단
		 * 
		 * Object의 equals() : 두 객체의 주소값을 비교
		 * Object의 hashCode() : 두 객체의 주소값을 기반으로 10진수를 만들어주는 함수
		 * 
		 * 주소값 기반이 아닌 객체의 초기화된 "필드"값 기반으로 동일여부를 판단하게 하고 싶다면?
		 * 위 두 메소드를 오버라이딩한다.
		 * 
		 * Student클래스의 equals() : 세 필드값이 모두 일치하면 true/ 하나라도 다르다면 false 반환
		 * Student클래스의 hashCode() : 세 필드값을 모두합쳐서 hashcode()를 만들어서 반환.
		 * */
		
		System.out.println("------------------------------------------------");
		
		// Set => 무작위로 객체가 저장이 되어있고 index개념이 없다.
		// 그럼 담겨있는 데이터는 뭐로 꺼내나?
		
		// 1. 반복문 for each으로 추출
		for(Student s : hs2) {
			System.out.println(s);
		}
		
		System.out.println("----------------------------------------");
		
		// 2. HashSet의 Iterator반복자를 이용
		Iterator<Student> it = hs2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 3. ArrayList에 값을 담아준 후 ArrayList로 대신 반복
		ArrayList<Student> list = new ArrayList<>(hs2);
		System.out.println(list);
		
		// 4. ArrayList의 addAll함수
		ArrayList<Student> list2 = new ArrayList<>();
		list2.addAll(hs2);
		System.out.println(list2);
		
		// LinkedHashSet : 순서가 유지되는 Set
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(12345); // 12345 , null, 100의주소값
		set1.add(100); // 100 , 12345주소값, 125의 주소값
		set1.add(125); // 125 , 100의 주소값, null
		set1.add(1);
		System.out.println(set1);
		
		// TreeSet : 오름차순 정렬을 지원하는 Set
		//           정렬기준은 vo클래스에 생성 가능하고, Comparator로 구현해도 상관없음
		//           Comparator로 정렬기준을 만들면 Comparator구현객체를 TreeSet()생성자의 매개변수에
		//           추가해줘야한다.
		Set<Student> set2 = new TreeSet<>( /* new StudentComparator() */);
		
		set2.add(new Student("둘리",5,80));
		set2.add(new Student("공유",40,100));
		set2.add(new Student("김길동",20,100));
		set2.add(new Student("김길동",45,100));
		System.out.println(set2);
	}
	
	

}
