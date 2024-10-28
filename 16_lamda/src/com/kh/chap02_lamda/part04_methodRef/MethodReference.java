package com.kh.chap02_lamda.part04_methodRef;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {
	
	/* 
	 * 람다식의 메소드참조(Method Reference)
	 *  - 기존 람다식 구문중 자바의 메소드를 사용시 이를 더욱 간결하게 표현할 수 있도록 제공하는 문법.
	 *  - 람다식을 통해 이미 구현된적이 있는 다른 메소드의 기능을 호출하고 , 사용시 전체 코드를 다 작성하지
	 *    않고 사용하고자 하는 메소드의 이름만 작성하는 형태의 문법이다.
	 *  ex) str -> str.length();
	 *      String::length;
	 *      
	 * - 메소드 참조 사용방법 및 종류
	 * 1. static 메소드 참조
	 * 2. 일반 메소드 참조
	 * 3. 객체 메소드 참조
	 * 4. 생성자 참조
	 * */
	
	// 메소드 참조	
	public static void main(String[] args) {
		//Consumer<String> printer = str -> System.out.println(str);
		Consumer<String> printer = System.out::println;		
		printer.accept("Java is Fun");
		
		// 1. static메소드 참조
		//Function<String, Integer> intParser = str -> Integer.parseInt(str);
		Function<String, Integer> intParser = Integer::parseInt;
		int num = intParser.apply("111222");
		System.out.println(num+100);
		
		// 2. 일반 메소드 참조
		// 1) String.length()
		Function<String, Integer> strLength = s -> s.length();
		strLength = String::length;
		System.out.println(strLength.apply("ja va"));
		
		// 2) String equals() : str.equals(str2)
		BiFunction<String, String, Boolean> strEquals = (s1, s2) -> s1.equals(s2);
		strEquals = String::equals;
		System.out.println(strEquals.apply("Java", "java"));
		System.out.println(strEquals.apply("Java", "Java"));
		
		// 3. 객체 메소드 참조
		String title = "소나기";
		Predicate<String> equalsTitle = s -> title.equals(s);
		equalsTitle = title::equals;
		System.out.println(equalsTitle.test("소나기"));
		
		// 4. 생성자 메소드 참조
		class Person {
			private String name;
			private int age;
			
			public Person() {
				
			}
			
			public Person(String name) {
				this.name = name;
			}
			
			public Person(String name, int age) {
				this.name = name;
				this.age = age;
			}
		}
		
		Supplier<Person> personConstr = () -> new Person();
		personConstr = Person::new; // new Person();
		
		Function<String, Person> personConstr2 = name -> new Person(name);
		personConstr2 =  Person::new; // new Person(name);
		
		BiFunction<String , Integer , Person> personConstr3 = (name, age) -> new Person(name, age);
		personConstr3 = Person::new; // new Person(name, age);
			
	}
	
	
	
	
	
	
}
