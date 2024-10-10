package com.kh.chap02_string.controller;

public class B_StringPoolTest {
	
	/* 
	 * String은 불변클래스(값이 변하지 않는 클래스)
	 *  - 값을 수정할때 기존의 값이 담겨있는 저장공간에서 수정되지 않는다.
	 * 
	 * 문자열 상수풀(String constant pool)
	 *  - 문자열 데이터가 담기는 영역으로 static영역안에 항상 고정된 저장공간이 준비되어 있다.
	 * */
	
	// 1. String 생성자를 통한 문자열 생성
	public static void method1() {
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1 == str2); // false
		
		System.out.println(str1);
		System.out.println(str2.toString());
		// String 크래스의 toString()은 실제 담겨있는 문자열을 반환하도록 오버라이딩 되어 있음
		
		System.out.println(str1.equals(str2));
		// String 클래스의 equals()메소드의 경우 주소값 비교가 아닌, 실제 담긴값을
		// 비교하도록 오버라이딩 되어 있음.
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		/* 
		 * Object hashCode()의 경우 16진수의 "메모리 주소"값을 10진수 형태로 변환한 값을 반환
		 * 
		 * String hashCode()의 경우 주소값 기반이 아닌, 실제 담긴 "문자열"을 기반으로 해시코드값을
		 * 만들어 반환하도록 오버라이딩 되어 있음.
		 * 
		 * */
		
		// 변수의 진짜 주소값을 알고 싶다면 ? System.identifyHashCode(변수)
		System.out.println( System.identityHashCode(str1)  );
		System.out.println( System.identityHashCode(str2)  );
	}
	
	//2. 문자열 리터럴로 문자열 객체 생성
	public static void method2() {
		String str = new String("hello");
		
		String str1 = "hello"; // == new String("hello");
		//str1 = "zz";
		String str2 = "hello";
		String str3 = "world";
		
		System.out.println(str == str1); // false
		System.out.println(str1 == str2);// true
		
		/* 
		 * JVM이 클래스 안의 정보를 읽어들이면서 "문자열 리터럴"을 만나면
		 * new String()메소드를 호출. 
		 * 이때 문자열 상수풀 안에 내가 생성한 문자열이
		 * 존재하는지 체크하고 존재한다면 그 문자열의 주소값을 반환한다.
		 * 만약 처음 생성한 문자열이라면 상수풀에 해당 문자열을 등록한 후 주소값을 반환한다.
		 * 
		 * 동일한 문자열 리터럴을 사용하는 경우 저장공간이 새롭게 할당되지 않고 이미 저장된 주소값을
		 * 공유해서 사용할 수 있다
		 * */
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		// 1651191114
	}
	
	public static void method3() {
		
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str = "goodbye"; // new String("goodbye");
		System.out.println(System.identityHashCode(str));
		
		str += "abc"; // new String("goodbyeabc")
		System.out.println(System.identityHashCode(str));
		
		/* 
		 * 자바에서 가장 많이 사용되는 객체가 바로 String
		 * String이 메모리영역에서 사라지지 않는다면 메모리 부족 이슈가 발생.
		 * 이러한 메모리를 효율적으로 사용하기 위해 상수풀이 개발되었고, 상수풀 내부에 사용중이지
		 * 않는 문자열들은 시간이 지나면 가비지 컬렉터가 알아서 정리해줌
		 * 
		 * 불변클래스라고해서 final처럼 값 수정이 안되는게 아니라, 수정이 될때 원래 저장된
		 * 위치에서 수정되지 않고 항상 새로운 주소값을 생성하기 때문에 불변이다.
		 * 
		 * 문자열은 자주사용되는 데이터인 만큼 상수풀안에 있는 데이터를 공유해서 사용하는게 메모리
		 * 효율이 더 좋으므로 new String보다 리터럴로 문자열을 만드는 것이 좀더 권장된다.
		 * */
	}
	
	
	
	
	
	
	
	
	
}
