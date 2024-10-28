package com.kh.chap02_lamda.part03_FuntionalInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntaionlInterface {
	/* 
	 * 함수형 인터페이스 
	 *  - 람다식을 통해 구현되는 추상메소드를 가지고 있는 인터페이스.
	 *  - 내부적으로 오직 1개의 추상메소드만 가지고 있다.
	 *  - 람다식을 작성하고 호출하기 위해서 작성해야하는 람다식의 틀이다.
	 *  
	 * 자바 대표 함수형인터페이스들
	 *      인터페이스            |        추상메소드
	 * 1.  Runnable			   |  run() : void
	 * 2.  Supplier<R>         |  get() : R
	 * 3.  Consumer<T>         |  accept(T) : void 
	 * 4.  Function<T, R>      |  apply(T) : R     
	 * 5.  Predicate<T>        |  test(T) : boolean 
	 * */
	
	public static void main(String[] args) {
		//1. Runnable
		Runnable r = () -> {
			for(int i =0; i<10; i++) {
				System.out.println(new Date());
			}
		};
		r.run();
		
		// 2. Supplier : 매개변수 없고, 리턴값이 존재하는 람다식 구현시 사용권장.
		Supplier<Long> supplier = () -> new Date().getTime();
		System.out.println(supplier.get());
		
		// 3. Consumer : 매개변수가 있고, 리턴값이 없는 람다식 구현시 사용.
		Consumer<String> consumer = str -> System.out.println(str+"님 안녕하세요");
		consumer.accept("경민");
		
		// 4. Function : 매개변수도 있고 , 리턴값도 있음.
		Function<String, Integer> function = str -> str.length();
		
		System.out.println(function.apply("안녕하쇼"));
		System.out.println(function.apply("hello"));
		
		// 5. Predicate : 매개변수 있고, 반환형은 boolean (람다식으로 조건식을 짤대 자주 사용)
		Predicate<Integer> predicate = n -> n % 2 == 0;
		System.out.println(predicate.test(123131));
		
		/* 
		 * - 실습문제 - 
		 * 위에서 배운 함수형 인터페이스를 활용하여 람다식을 구현하시오.
		 * 단, 불필요한 매개변수나 사용되지 않는 반환값이 없게 할것.
		 * */
		
		// 1. 현재시각을 출력 람다식.
		// 출력예시 : 2024-04-19 12:50:00
		Runnable displayCurrentTime = () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(new Date()));			
		};
		displayCurrentTime.run();
		
		// 2. 오름차순 정렬이 되는 TreeSet객체를 활용하여 6자리 로또번호(1~45)를 생성후 반환해주는 람다식 작성
		//    생성후 반환받은 로또번호를 출력하시오.
		// 출력예시 : [1, 11, 13, 23, 29, 44]
		Supplier<Set<Integer>> lottoPublisher = () -> {
			Set<Integer> lotto = new TreeSet<>();
			while(lotto.size() < 6) {
				lotto.add((int) (Math.random() * 45 + 1));
			}
			return lotto;
		};
		System.out.println(lottoPublisher.get());
		// 3. 환율계산기 : 원화값(정수)을 입력시 달러값(실수)를 리턴해주는 함수
		//    현재환율 : 1달러 == 1400원
		//    출력예시 : xxxx원은 달러로 xxxx.x$입니다.
		
//		Function<Integer, Double> wonDollar = won -> {
//			double dollar = won / 1400.0;
//			return dollar;
//		};
		int won2 = 1000000;
		Function<Integer, Double> wonDollar = won -> won / 1400.0;
		System.out.println(won2+"원은 달러로 "+wonDollar.apply(won2)+"$ 입니다.");
	}
	
	
	
	
	
	
}
