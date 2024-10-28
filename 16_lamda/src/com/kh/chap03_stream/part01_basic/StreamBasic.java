package com.kh.chap03_stream.part01_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasic {
	/*
	 * 스트림 ? 
	 * - 데이터의 흐름이라는 뜻으로 스트림 내부의 데이터를 다른 스트림으로 보내고, 또보내고 또 보내는 무한한
	 *   흐름을 만들수 있는 클래스
	 * - 반복문과 조건문을 사용하여 처리했던 작업들을 "람다식"을 통해 제어할 수 있도록 다양한 메소드를 정의해둔
	 *   클래스 
	 * ex) forEach : 스트림(배열과비슷한데이터)의 데이터를 단순히 반복하고자 할때 사용하는 메서드.
	 *     filter  : 스트림의 데이터를 "조건"에 맞춰서 필터링하고자 할때 사용하는 메서드
	 *     count   : 스트림의 데이터갯수를 샐때 사용하는 메서드. 
	 *     add, min ,max : 스트림에 값을 더하거나, 최소값, 최대값을 구하는 메소드 등.
	 * - 주로 "컬렉션"의 요소들에 대한 데이터 처리시 많이 사용되며, 컬렉션뿐만 아니라 배열, i/o로 읽어들인 file
	 *   에서 읽어들인 데이터 등 각종 데이터를 처리할때 사용할 수 있다.
	 * - 각종 자료구조(배열,컬렉션,기본자료형,file...)들을 스트림을 통해 일관성 있게 제어할 수 있도록 메서드를 정의해 두었다.
	 * 
	 * - 데이터를 처리하기위한 "중간연산"과 "최종연산"과정이 존재한다.
	 *  
	 * * 스트림의 처리과정
	 *  1) 스트림 생성 및 초기화
	 *  2) 중간연산 n회 수행
	 *  3) 최종연산으로 결과값 도출
	 * 
	 * * 스트림의 특징
	 * - 스트림은 "재사용이 불가능"하다. 스트림은 소모의 개념.
	 * - 스트림은 최종연산 메서드가 호출되기 전까지 연산이 수행되지 않는다.
	 * - 배열이나 컬렉션을 통해 스트림으로 변환 후 연산시, 배열,컬렉션의 원본데이터는 변경되지 않는다.
	 *   즉, 배열이나 컬렉션 내부의 값만 깊은 복사하여 가져온다.
	 *  */
	
	/* 
	 * 스트림 객체 생성 방법
	 * 1) 배열을 통한 생성
	 * [표현법]
	 * 자료형[] 배열명 = new 자료형[크기];
	 * Arrays.stream(배열명);
	 * 
	 * 2) 컬렉션을 통한 생성
	 * 컬렉션<자료형> = new 컬렉션();
	 * 컬렉션.stream(); 
	 * 
	 *  // 그 밖에
	 * Stream클래스를 통한 생성 
	 * File데이터를 통한 생성.
	 * */
	
	public static void main(String[] args) {
		
		// 1. 배열을 통한 생성
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = Arrays.stream(arr);
		
		String [] sArr = {"java","is","fun"};
		Stream<String> stream = Arrays.stream(sArr);
		
		// 2. 컬렉션을 통한 생성
		ArrayList<Integer> list = new ArrayList( Arrays.asList(arr) );
		Stream<Integer> iStream = list.stream();
		
		Set<Integer> set = new HashSet<>();
		set.stream();
		
		HashMap<String, Integer> map = new HashMap();
		map.keySet().stream(); // keySet, entrySet둘다 가능.
		
		// 3. 그 밖에 
		// Stream 클래스를 통한 생성
		// 1) empty() -> 빈스트림 생성
		Stream emptyStream = Stream.empty();
		
		// 2) builder : 직접원하는 값을 넣어주고자 할때 사용.
		Stream<String> sStream = Stream.<String>builder().add("A").add("B").add("C").build();
		
		// 3) of(T... E) : 매개변수로 주어진 요소들을 가지고 Stream을 생성
		Stream.<String>of("d","ee","f");
		
		// 4) generate(Supplier<T> s) : 람다식으로 작성한 리턴값을 요소로 가지는 Stream을 생성
		Stream.<String>generate( () -> "a").limit(5);
		
		// 5) iterate(초기값, UnaryOperator) : 초기값과 초기값을 다루는 람다식(UnaryOperator)을 작성하여 
		//                                   스트림에 들어갈 요소를 추가하는 메소드. (T) -> T
		Stream.iterate(1, i -> i + 1).limit(10); // 1,2,3,4,..10의 값이 담긴 스트림 반환
		
		// 6) range, rangeClosed()
		IntStream.range(1, 5); // [1,2,3,4] 
		IntStream.rangeClosed(1, 5); // [1,2,3,4,5] 종료값 포함.
		
		// 4. 그 외 파일을 통한 스트림생성등 많은 방법이 있다.
		// 생략
		
		// 일반 반복문 vs 스트림의 반복문 비교
		// 1) 배열을 통한 반복문
		for(String str : sArr) {
			System.out.println(str);
		}
		System.out.println("-----------------------------------");
		
		stream.forEach((str) -> {
			System.out.println(str);			
		});
		
		// 배열을 통해 2와 4의 배수인 값들의 합 구하기
		// arr
		int sum = 0;
		for(int i : arr) {
			if(i % 4 == 0) {
				sum += i;
			}
		}
		System.out.println("arr배열의 2와 4의 배수 총합 : "+sum);
		
		// ## 위 코드를 스트림을 통해 구현하기. ##
		// 데이터들중 2의 배수 및 4의 배수인 값들만 필터링 한 후 그값들의 합을 구한다.
		IntStream stream1 = intStream.filter( i -> i % 2 == 0);
		// filter? 중간연산메소드 중 하나로 조건식의 결과가 true인 요소만 남겨둔다.
		IntStream stream2 = stream1.peek( i -> System.out.println("현재 i 값"+i));
		// peek ? 중간연산메소드 중 하나로 현재 요소의 값을 뽑아서 테스트할 때 사용.
		IntStream stream3 = stream2.filter(i -> i % 4 == 0);
		IntStream stream4 = stream3.peek( i -> System.out.println("최총 i의 값"+i));
		
		//최종연산 메서드
		int sSum = stream4.sum(); // 중간연산을 실행시키는 트리거의 역할을 함.
		//int sSum2= stream4.sum(); // 스트림은 재사용이 불가능하다.
		System.out.println("스트림을 통한 연산결과 : "+sSum);
		
		// 스트림 메서드체인(파이프라인)
		Arrays.stream(arr)
		.filter(i -> i % 2 == 0)
		.filter(i -> i % 4 == 0)
		.forEach(System.out::println);
		
	}
	
	
	
	
	
	
	
	
	
	
}
