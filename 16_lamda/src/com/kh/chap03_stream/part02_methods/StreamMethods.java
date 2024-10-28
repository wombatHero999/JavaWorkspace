package com.kh.chap03_stream.part02_methods;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
	/* 
	 * 스트림의 중간연산 메서드들
	 * 
	 * 중간연산 메서드들은 매개변수로 람다식을 받은 후 처리.
	 * 1) distinct : 중복값 제거.
	 * 2) filter   : 내부요소 필터링
	 * 3) map      : a값을 매개변수로 받아 b값으로 반환해주는 메소드.
	 * 4) peek     : 중간확인 메서드. 현재 요소를 가져와서 원하는 작업처리를 함.
	 * 5) sort     : 정렬메서드
	 * ...
	 * 
	 * 최종연산 메서드들
	 * 1) Iterating : forEach -> 요소를 단순 반복시키는 함수
	 * 2) Collecting : collect(Collectors.?) -> Collectors에서 제공하는 정적 메소드를 매개변
	 *  수로 받아 스트림의 요소를 "내가 원하는 자료구조로 모아서 반환"해준다 
	 * 3) Calculating : min, max, sum, average 
	 * 4) Matching : anyMatch, allMatch, noneMatch ... -> 스트림의 요소에서 특정 조건을
	 *    만족하는지 검사하는 메서드들.
	 * 5) Reduction : reduce라는 메소드를 사용하여 요소의 값들을 내가 원하는 방법으로 연산 한 후 
	 *   결과를 알려주는 메소드. 
	 * */
	
	public static void main(String[] args) {
		// 중간처리 메서드들 + forEach
		// 1) distinct, filter : 중복값 제거 및 필터링기능
		List<Integer> list = Arrays.asList(5,1,2,3,2,4,3,2,1,2,2,4);
		
		list.stream()
			.distinct()			
			.filter( i -> i % 2==0)
			
			.forEach( i -> System.out.println(i));
		
		String[] names = {"강감찬","홍길동","강형욱","뉴진스", "강원래"};
		// 이름이 강으로 시작하는 문자열만 남기기.
		// name.charAt(0) , name.startwith()
		Arrays
			.stream(names)
			//.filter(name -> name.startsWith("강"))
			.filter(name -> name.charAt(0) == '강')
			//.sorted()
			.forEach(System.out::println);
		
		// 2) map : 현재 요소를 다른 요소로 변환시켜주는 메소드
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		list2.stream()
			.map( i -> i * 0.1) // 1 -> 0.1, 2 -> 0.2
			.forEach(System.out::println);
		
		List<Integer> another = list2.stream()
									.map(i -> i*10)
									.collect(Collectors.toList());
		System.out.println("원본 : "+list2);
		System.out.println(another);
		
		// mapToInt : Stream<참조자료형> -> IntStream
		Stream.
			of("홍길동","세종대왕","신사임당")
			.map(name -> name.length()) // Stream<String> -> Stream<Integer>
			//.mapToInt(name -> name.length()) // Stream<String> -> IntStream
			.forEach(System.out::println);
		
		// 최종연산메서드들
		// Collecting계열
		// 1) collect(Collectors.toList()) : 스트림의 결과값을 List로 반환
		List<Integer> list4 = Arrays.asList(1,2,3,4,5,6,7,6,5,4);
		List result1= list4.stream()
			.map( num -> Math.pow(num, 2))
			.collect(Collectors.toList());
		
		System.out.println(result1);
		// 2) collect(Collectros.toSet()) : 스트림의 결과값을 Set으로 반환
		Set result2 = list4.stream()
							.filter(n -> n % 2 == 0)
							.collect(Collectors.toSet());
		System.out.println(result2);
		// 3) collect(Collectors.toMap(Function, Function))
		Map<String, Integer> result3 = list4.stream()
											.distinct()
											.collect(Collectors.toMap(
													num -> num+""
													, num -> num));
		System.out.println(result3);
		
		// Calculating계열 -> 산술연산시 자주 사용. IntStream에서 자주 활용.
		
		// 1) sum
		int sum = IntStream.rangeClosed(10,100).sum();
		System.out.println(sum);
		
		// 2) average
		double avg = IntStream
					.rangeClosed(1,100)
					.average()
					.getAsDouble(); // OptionalDouble에 값이 있다면 double반환, 없다면 
					//.orElse(0.0); // 에러발생.
		System.out.println(avg); 
		
		// 3) summaryStatistics : 스트림 요소에 대한 통계값을 가진 객체를 반환.
		//    통계? 총 개수,  합, 최소, 최대, 평균값
		IntSummaryStatistics summary = IntStream.of(32, 50 , 80 , 77, 100 ,27 , 88)
				 								.summaryStatistics();
		System.out.println(summary);
		
		// Reduction
		// reduce(초기값, 연산로직)
		Arrays.asList(1,2,3,4,5,6,7,8,9,10)
			  .stream()
			  .reduce( 0 , (eSum, num) -> {
				 System.out.println("eSum = "+eSum+", num = "+num);
				 return eSum + num; // 반환되는 값이 곧 다음 초기값.
			  });
		
		class Member {
			String name;
			int age;
			
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			
			public Member(String name, int age) {
				super();
				this.name = name;
				this.age = age;
			}
			
			@Override
			public String toString() {
				return "Member [name=" + name + ", age=" + age + "]";
			}
		}
		
		List<Member> arr = Arrays.asList(
				new Member("홍길동", 35) ,
				new Member("신사임당", 80) ,
				new Member("세종대왕", 45) ,
				new Member("백종원", 50) ,
				new Member("이순신", 65) 
				);
		
		// Member객체에서 최고령자는 누구인가?
		// reduce함수를 통해 최고령자 구하기.
		// 초기값 미지정시 스트림의 첫번재 요소가 초기값으로 자동지정된다.
		Member maxAgePerson =  arr.stream()
			.reduce((p1, p2) -> {
				System.out.println(p1+":::"+p2);
				return p1.age > p2.age ? p1 : p2;
			})
			.get(); 
		System.out.println(maxAgePerson);
		
		// Member 객체에서 나이값의 총합 구하기
		int ageSum = arr.stream() // Stream<Member>
						.map( member -> member.age) // Stream<Member> -> Stream<Integer>
						.reduce(0 , (init, age) -> init+age);
		System.out.println(ageSum);
		
		// Matching 계열
		// 1) anyMatch 스트림의 요소들중 predicate결과가 "하나라도" true이면 true반환
		boolean bool = 
				Arrays.asList("a1" ,"b2","c","d4","5")
				.stream() 
				.anyMatch(s -> {
					System.out.println(s);
					return s.startsWith("a");
				});
		System.out.println(bool);
		
		// 2) noneMatch 스트림의 요소 모두가 예측결과 false 경우 true리턴.
		bool = Arrays.asList("홍길동","123","가나다")
				.stream()
				.noneMatch( s -> s.length() > 4);
		System.out.println("noneMatch 결과 "+ bool);
		
		// 3) allMatch 스트림의 모든 요소가 true여야 true반환
		bool = Arrays.asList("홍길동","123","가나다")
				.stream()
				.allMatch( s -> s.length() <= 3);		
		System.out.println("allMatch : "+ bool);
		
		// 4) findFirst : 스트림의 요소에서 첫번째 요소를 찾아주는 메소드
		
		String str = Arrays
		.asList("홍길동","123","가나다")
		.stream()
		//.sorted()
		.findFirst()
		.get();
		System.out.println("first item : "+str);
		
		// 5) findAny : 스트림 요소가 하나라도 존재한다면 해당 요소를 반환.
		str = Arrays
		.asList("홍길동","123","가나다")
		.stream()
		.filter( s -> s.length() == 3)
		.findAny()		
		.get();
		System.out.println("findAny = " + str);
	}
	
	
	
	
	
	
}
