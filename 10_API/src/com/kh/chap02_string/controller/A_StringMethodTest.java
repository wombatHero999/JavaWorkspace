package com.kh.chap02_string.controller;

public class A_StringMethodTest {
	
	//문자열과 관련된 메소드들..
	public static void method() {
		
		String str1 = "Hello World";
		
		// 메소드명(매개변수) : 반환형
		
		// 1. 문자열.charAt(int index) : char
		char ch = str1.charAt(6);
		System.out.println("ch : "+ch);
		
		// 2. 문자열.concat(String str) : String
		//    문자열과 전달받은 문자열을 하나로 합쳐서 반환해주는 함수
		String str2 = str1.concat("!!"); // Hello World + !!
		System.out.println(str2);
		
		// 3. 문자열.length() : int
		System.out.println("str1 길이 : "+ str1.length());
		
		// 4. 문자열.substring(int beginIndex) : String
		//   => 문자열의 beginIndex부터 마지막 인덱스까지 문자열을 추출해서 반환.
		//    문자열.substring(int beginIndex, int endIndex) : String
		//   => 문자열의 beginIndex부터 endIndex -1위치까지 문자열을 추출해서 반환.
		System.out.println(str1.substring(6));
		System.out.println(str1.substring(6, 9));
		
		// 5. 문자열.replace(char old, char new) : String
		//     문자열에서 old문자를 new문자로 변화한 문자열 반환
		String str3 = str1.replace('l', 'c');
		System.out.println("str3 : "+str3);
		
		// 6. String.trim() : String
		//   => 문자열의 앞,뒤 공백을 다듬어줌.(제거)
		String str4 = "           J A V A       ";
		System.out.println(str4);
		System.out.println("trim() : "+str4.trim());

		// 7. 문자열.toUpperCase() : String
		//    문자열.toLowerCase() : String
		//    문자열을 모두 대/소문자로 변경된 문자열을 리턴.
		System.out.println("upper : "+str1.toUpperCase());
		System.out.println("lower : "+str1.toLowerCase());
		// Alsrudals
		// alsrudals
		
		// 8. 문자열.toCharArray() : char[]
		// "apple" -> {'a','p','p','l','e'}
		// 문자열을 char로 변환한후 배열에 옮겨담는 메소드
		char[] arr = str1.toCharArray();
		System.out.println(arr[3]);
		
		char[] arr2 = {'a','p','p','l','e'}; // "apple"
		
		// 9. static valueOf(char[] data) : String
		//   매개변수로 전달된 데이터를 하나의 문자열로 합쳐서 반환
		System.out.println(String.valueOf(arr2));
	}
	
	
	
	
	
	
	
	
	
	
	
}
