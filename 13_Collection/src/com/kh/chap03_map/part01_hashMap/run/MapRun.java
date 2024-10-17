package com.kh.chap03_map.part01_hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {
	
	public static void main(String[] args) {
		
		Map<String, Snack> hm= new HashMap<>();
		/*
		 *  HashMap?
		 *   - 많은 양의 데이터를 "빠르게 저장하고 관리"하기 위하여 Key, Value값을 함께 묶어서 관리하는 자료구조
		 *   - 계층구조상 List나 Set계열과 달리 Collection인터페이스를 상속받지 않았다. 
		 *   
		 *  특징
		 *   - key, value 한쌍으로 데이터를 관리
		 *   - key값을 통해서 value가 저장된 위치에 접근한다.
		 *   - key는 중복을 허용하지 않는다. 단, value는 중복되어도 좋다
		 *   - 만약 동일한 key값으로 데이터를 저장시 마지막에 추가된 value로 기존값이 변경된다.
		 *   - key값이 동일한지 여부는 hashCode()로 판단한다.
		 *   
		 *  hashCode함수
		 *   - Hash기반 자료구조에서 객체를 "저장"하거나 "검색"할때 사용된다. 
		 *   - 배열에 저장시킬 각 요소들에대해 hashCode함수를 호출 후 저장시킬 인덱스값을 계산
		 *    => 일반적인 계산공식 [hashCode() % 배열의 길이]
		 *   
		 *   - 두 객체간의 hashCode값이 같다면 같은 저장공간을 할당받기 때문에 데이터 중복을 피할수 있다.
		 *     데이터 조회시에도 hashCode값이 곧 HashMap 내부 배열의 index값이기 때문에 반복문 없이 빠르
		 *     게 데이터를 조회할 수 있다.
		 *  */
		
		// 1. put(K key, V value) -> map에 key,value를 세트로 추가하는 메소드
		hm.put("다이제", new Snack("초코맛",1000));
		hm.put("칸초", new Snack("초코맛",500));
		hm.put("새우깡", new Snack("짠맛",700));
		hm.put("포테이토칩", new Snack("짠맛",400));
		
		System.out.println(hm.toString());
		
		hm.put("새우깡", new Snack("매운맛", 800));
		System.out.println(hm.toString());
		
		// 2. get(Object key) : Value => 맵에서 key값과 일치하는 값을 돌려주는 메소드.
		Snack s = hm.get("포테이토칩");
		System.out.println(s);
		
		// 3. size() : 컬렉션에 담겨있는 개수
		System.out.println(hm.size());
		
		// 4. replace(K key, V value) => 컬렉션에 key값과 일치하는 데이터를 value로 변경해주는 메소드
		hm.replace("포테이토칩", new Snack("양파맛", 800));
		System.out.println(hm);
		
		// 5. remove(Ojbect key) => 컬렉션에 key값과 일치하는 데이터를 삭제
		hm.remove("포테이토칩");
		System.out.println(hm);
		
		System.out.println("=========================================================");
		
		/* 
		 * 반복문으로 HashMap에 담겨있는 데이터를 가져오기위한 방법
		 * 1. keySet함수 이용 : key값을 set에 담아서 반환
		 * 2. entrySet함수 이용 : key,value값을 한쌍에 담아서 Set으로 반환
		 * */
		
		// 1. keySet()을 이용
		// 1) hm에 있는 key값들만 set에 담아서 반환
		Set<String> keySet = hm.keySet();
		
		// 2) 1번과정에서 얻어온 set을 반복시킨다.
		for( String key  : keySet ) {
			// 3) key값을 통해 hm내부의 데이터를 추출
			System.out.println("key : " + key);
			System.out.println("value : " + hm.get(key));
		}
		
		// 2. entrySet()을 이용
		// 1) hm내부의 key,value이 담긴 Entry Set을 반환
		Set<Entry<String, Snack>> entrySet =hm.entrySet();
		
		// 2) Set을 통한 반복문 호출
		Iterator<Entry<String, Snack>> it = entrySet.iterator();
		
		// 3) 반복문을 활용
		while(it.hasNext()) { 
			Entry<String,Snack> e = it.next();
			System.out.println("key : "+ e.getKey());
			System.out.println("value : "+ e.getValue());
		}
	}
	
	
	
	
	
	
	
}
