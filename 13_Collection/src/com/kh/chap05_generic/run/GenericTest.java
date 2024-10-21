package com.kh.chap05_generic.run;

import java.util.ArrayList;
import java.util.List;

/* 
 * 3. 제네릭의 extends 
 * 제네릭의 extends는 "상속의 개념"이 아니라 제네릭으로 지정할 자료형을 "제한"시키는데 목적이 있다.
 * */
public class GenericTest<T extends Parent> {
	
	private T generic;
	
	public void print() {
		generic.doPrinting();
	}
	
	public T getGeneric() {
		return generic;
	}
	
	public void setGeneric(T generic) {
		this.generic = generic;
	}
	
	
	public static void main(String[] args) {
		GenericTest<Parent> parent = new GenericTest<>();
		GenericTest<Child1> child1 = new GenericTest<>();
		GenericTest<Child2> child2 = new GenericTest<>();
		
		//GenericTest<String> etc = new GenericTest<>();
		
		
		// 4. 와일드 카드 사용
		// GenericTest에 들어갈 자료형을 모르는 경우 ?(와일드카드)로 대체
		GenericTest<?> unknwon = new GenericTest<>();
		// unknwon.setGeneric(new Parent()); 
		// ?(와일드카드)는 자료형의 범위가 정해져 있지 않은 상태이기 때문에 , 제네릭에 올바른 값이
		// 들어갔는지 논리적인 검사가 불가능하다.
		
		// 문제해결을 위해서는 ?가 가지는 자료형의 범위를 제한시켜두면 된다.
		// 5-1. 와일드카드 extends (상향 경계 설정)
		//      ?가 가지는 "최대클래스" 설정
		GenericTest<? extends Parent> unknwon2 = new GenericTest<>();
		// - 와일드카드의 범위를 Parent로 제한. ?는 Parent이거나, Parent의 자식클래스중 하나.
		// - unknwon2.setGeneric(new Parent());// ?는 Parent, Child1, Child2중에 하나.
		// - ?가 Parent인 경우 Parent변수 = Parent객체이므로 문제 x. 
		// - ?가 자식클래스인 경우 자식클래스 변수 = Parent객체 이므로 "다운캐스팅"이 필요.
		
		//unknwon2.setGeneric(new Child1());
		// 다 좋은데 ?가 Child2와 같은 자료형이라면 Child2 변수 = Child1객체 x
		
		//unknwon2.setGeneric(new Child2());
		// 상향경계설정은 제네릭에 값을 대입할때는 좋은 방법이 아님.
		
		System.out.println((Parent) unknwon2.getGeneric()); 
		// ?가 어떤 자료형이든 Parent를 상속받으므로 업캐스팅하여 "사용"
		
		
		// 5-2. 와일드카드 super (하향 경계 설정)
		//      ?가 가질수 잇는 "최소 클래스" 설정
		//      ?의 범위는 Parent나 Parent의 super들로 제한 
		GenericTest<? super Parent> unknwon3 = new GenericTest<>();
		unknwon3.setGeneric(new Parent());// ?는 Parent든, Object든 자동형변환되기때문에 문제x
		unknwon3.setGeneric(new Child1());// ?가 Parent든, Object든 자동형변환되기때문에 문제x
		unknwon3.setGeneric(new Child2()); // 자동형변환을 이용하여 저장.
		
		// 하향경계설정은 값을 꺼낼때 문제가 된다.
		List<? super Parent> list =new ArrayList<>();
		list.add(new Parent());
		list.add(new Child1());
		list.add(new Child2());
		//list.add(new Object());
		
		System.out.println(list);
		for(Object o : list) {
			// list안에 어떤 데이터가 들어가든 최소한 Object의 자식이기때문에 upCasting이 가능
			System.out.println(o);
		}
		
		List<? extends Parent> list2 = new ArrayList<>();
		for(Parent p  : list2) {
			// list안에 어떤 데이터가 들어가든 최소 Parent의 자식이기 때문에 upCasting으로
			// 변수 설정 가능.
		}
	}
}

class Parent{
	public void doPrinting() {
		System.out.println("부모클래스 메서드");
	}
	
	public String toString() {
		return "부모클래스";
	}
}

class Child1 extends Parent{
	public void doPrinting() {
		System.out.println("자식클래스1 메서드");
	}
	
	public String toString() {
		return "자식클래스1";
	}
}

class Child2 extends Parent{
	public void doPrinting() {
		System.out.println("자식클래스2 메서드");
	}
	
	public String toString() {
		return "자식클래스2";
	}
}

