package com.kh.chap02_set.part01_hashSet.run;

import java.util.HashSet;

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
		
		
	}
	
	
	
	

}
