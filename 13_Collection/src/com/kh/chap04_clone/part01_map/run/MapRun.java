package com.kh.chap04_clone.part01_map.run;

import java.util.Arrays;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {
	
	class Entry {
		String key; // key값을 저장할 필드
		Snack value; // value값을 저장할 필드
		Entry next; // 다음 Entry가 존재할 주소값을 저장하는 필드
		
		public Entry(String key, Snack value, Entry next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "[key=" + key + ", value=" + value + ", next=" + next + "]";
		}
		
	}
	
	private Entry[] table;
	private int capacity;
	private int size;
	
	public MapRun() {
		this(10);
	}
	
	public MapRun(int capacity) {
		this.capacity = capacity;
		table = new Entry[capacity];
		
	}
	
	public static void  main(String[] args) {
		MapRun mr = new MapRun(10);
		
		mr.put("다이제", new Snack("초코",1500));
		mr.put("칸초", new Snack("단맛",600));
		mr.put("새우깡", new Snack("짠맛",500));
		mr.put("포테이토칩", new Snack("짠맛",500));
		
		System.out.println(Arrays.toString(mr.table));
		System.out.println(mr);
		
		System.out.println(mr.containsKey("새우깡")); // 출력 : true
		System.out.println(mr.size()); // 출력 : 4
		mr.remove("포테이토칩");
		System.out.println(mr.containsKey("포테이토칩")); // 출력 : false
		System.out.println(mr.size()); // 출력 : 3
		
	}
	
	int getIndex(String key) {
		// 매개변수로 전달받은 key값을 hashCode()로 변환시킨후
		int hash = key.hashCode();
		// 객체의 총 저장공간 수(capacity)만큼 나눈 나머지 결과값을 반환하는 함수
		// 1111111 10 => 1
		// 1231231 10 => 1
		// 1234569 10 => 9
 		return hash % capacity;
	}
	
	public void put(String key, Snack value) {
		
		// getIndex함수 호출후 반환값으로 table의 index에 접근
		int index = getIndex(key);
		Entry e = table[index];
		if(e == null) {
			table[index] = new Entry(key, value, null);
			size++;// 초기화된 데이터수 추가.
			return;
		}
		
		// key값이 동일한지, 아니면 우연히 hashCode값을 10으로 나눈값이 동일한지 검사
		//if(key.equals(e.key)) {
		//	e.value = value; // 기존의 value 대신 새로운 value값 덮어쓰기
		//}else { // 우연히 hashCode값을 10으로 나눈값이 동일
			Entry newE = new Entry(key, value , null);
			
			while(true) {			
				// 뒤쪽 entry의 key값이 동일한지(이미 추가된데이터인지)
				if(key.equals(e.key)) {
					e.value = value;
					break;
				}
				// 마지막 Entry찾기
				if(e.next == null) { 
					e.next = newE;
					size++;
					break;
				}
				// next Entry를 e에 저장.
				e = e.next;
			}
		//}
	}
	
	public Snack get(String key) {
		// getIndex함수 호출후 반환값으로 table의 index에 접근
		int index = getIndex(key);
		Entry e = table[index];
		if(e == null) {
			return null;
		}
		
		while(true) {
			if(e.key.equals(key)) {
				return e.value;
			}
			
			if(e.next == null) {
				break;
			}
			e = e.next;
		}
		return null;
	}
	
	public boolean containsKey(String key) {
		int index = getIndex(key);
		Entry e = table[index];
		
		if(e == null) {
			return false;
		}
		while(true) {
			if(e.key.equals(key)) {
				return true;
			}
			if(e.next == null) {
				return false;
			}
			
			e = e.next;
		}
	}
	
	public void remove(String key) {
		
		// getIndex함수 호출후 반환값으로 table의 index에 접근
		int index = getIndex(key);
		Entry e = table[index];
		if(e == null) {
			return;
		}
		
		Entry prev = null;
		while(true) {
			if(e.key.equals(key)) {// 삭제처리
				if(prev == null) {
					// 시작 entry인경우 
					table[index] = e.next;					
				}else {
					// 중간 위치의 entry인 경우
					prev.next = e.next;					
				}
				size--;
			}			
			// 마지막 entry인경우
			if(e.next == null) {
				return;
			}			
			prev = e; // 이전 entry저장
			e = e.next; // e에는 다음 entry저장
		}
	}
	
	public int size() {
		return size;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for(Entry e : table) {
			if(e == null) continue;
			sb.append("{").append(e.key).append(" : ").append(e.value).append("}").append(",");	
			
			Entry next = e.next;
			do {
				if(next != null) {
					sb.append("{").append(next.key).append(" : ").append(next.value).append("}").append(",");	
					next = next.next;
				}
			}while(next != null); 
		}
		
		sb.append('}');
		
		return sb.toString();
	}
	
}
