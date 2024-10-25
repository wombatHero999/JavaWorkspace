package com.kh.chap02_lamda.part02_practice;

import com.kh.chap02_lamda.model.functionalInterface.LamdaTest1;
import com.kh.chap02_lamda.model.functionalInterface.LamdaTest2;
import com.kh.chap02_lamda.model.functionalInterface.Practice1;
import com.kh.chap02_lamda.model.functionalInterface.Practice2;
import com.kh.chap02_lamda.model.functionalInterface.Practice3;
import com.kh.chap02_lamda.model.functionalInterface.Practice4;

public class LamdaPractice {
	
	public static void main(String[] args) {
		// 람다의 문법 종류들..
		// 1. 기본형태
		LamdaTest1 lamda1 = (int x , int y) -> {
			return x + y;
		};
		
		// 2. 매개변수의 자료형 생략.
		LamdaTest1 lamda2 = (x , y) -> {
			return x + y;
		};
		
		// 3. 매개변수 괄호 생략. 
		//    단, 매개변수가 "1개"인 경우에만 생략이 가능
		LamdaTest2 lamda3 = x -> {
			System.out.println(x);
		};
		
		// 4. 중괄호 생략하기 
		//    단, 실행할 코드가 "한문장"인 경우 메소드 중괄호 생략 가능.
		LamdaTest2 ladmda4 = x -> System.out.println(x);
		
		// 5. return생략하기 : 실행할 코드가 return값 뿐이라면 생략이 가능.
		// -> 뒤쪽에 코드 실행후 값을 반환시키라는 의미가 담겨있다.
		// 따라서 return 두번들어가는경우 의미가 이상해진다.
		LamdaTest1 lamda5 = (x , y) -> x+y;
		
		/*
		 * 람다식 정리
		 *  - 람다식의 간소화 문법은 필수로 사용해야하는 것은 아니나, 사용자의 취향에 따라 
		 *    모두 자주 사용되는 표현방법들이기 때문에 사용방법에 대한 연습이 필요하다.
		 *  - 람다식을 사용할 수 있는 위치는 return뒤에 반환값 혹은 매개변수에 대입되는 값으로써
		 *    자주 사용된다.
		 *  - 람다식을 사용하면 함수를 마치 값처럼 주고 받는 행위를 할 수 있다. 
		 *  */
		// - 실습문제
		// 람다식을 가장 간결한 형태로 표현하기
		// 1. ((int x) -> { return (x * x); }); 
		// 2. (String str) -> { return (str.length()); };
		// 3. (int x) -> { System.out.println(x); return x; };
		// 4. (String str) -> { return (str.toUpperCase()); };
		// 5. (int x , int y) -> { return (x * y); };
		// 6. ((int x , int y) -> { return (x % y == 0); });
		// 7. (int x , String str1) -> { return (str1 + x); };
		// 8. ((int x , String str1) -> { System.out.println(x + str1); });
		// 9. (int[] arr) -> { return (Math.max(Math.max(arr[0], arr[1]), arr[2])); };
		// 10. ((String str1, String str2) -> { String result =  (str1.conact(str2)); return result; });
		
		/*
		 * - 실습문제 답 -
		 * 6. (x , y) -> x % y == 0;
		 * 7. (x , str1) -> str1 + x; 
		 * 8. (x , str1) -> System.out.println(x + str1);
		 * 9. arr -> Math.max(Math.max(arr[0], arr[1]), arr[2]); 
		 * 10.(str1, str2) -> { String result =  (str1.conact(str2)); return result; }
		 * 10.(str1, str2) -> str1.conact(str2);
		 *  */
		//1. x -> x * x; 
		Practice1 p = x -> x * x; 
		/* new Practice1() {
			public int multi(int x) {
				return x * x;
			}
		}; */
		// 2. str -> str.length(); 
		Practice2 p2 = str -> str.length();
		
		// 3. x -> { System.out.println(x); return x; };
		Practice1 p3 = x -> { System.out.println(x); return x; };
		
		// 4. str -> str.toUpperCase();
		Practice3 p4 = str -> str.toUpperCase();
		
		// 5. (x , y) -> x * y; 
		Practice4 p5 = (x , y) -> x * y;
		
		
		
		
	}
	
}
