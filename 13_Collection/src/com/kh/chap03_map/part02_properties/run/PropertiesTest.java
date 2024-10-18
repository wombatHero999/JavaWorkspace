package com.kh.chap03_map.part02_properties.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class PropertiesTest {
	public static void main(String[] args) {
		/* 
		 * Properties : Map계열 => key, value세트로 데이터를 관리
		 *  - key, value모두 String으로만 저장시키도록 제한할 수 있다.
		 *  - 파일 입출력(io)메소드를 지원하여 설정정보를 표현하는데 효율적인 형태를 가지고 있다.
//		 * */
		Properties prop = new Properties();
//		
//		// 기본 map인터페이스메소드 사용시 모든 자료형 사용가능
//		prop.put("다이제", new Snack("초코",1200));
//		
//		System.out.println(prop);
//		System.out.println(prop.get("다이제"));
		
		// Properties에 값 추가시 setProperty(String key, String value)
		// Properties에서 값 가져올 때 getProperty(String key)함수를 사용
		
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap"); // hashMap저장 x
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop); // 저장 순서 유지 x, key값 중복 x
		System.out.println(prop.getProperty("Set"));
		System.out.println(prop.getProperty("ArrayList","default"));
//		try {
//			//prop.store(new FileOutputStream("test.properties"), "Properties Test");
//		} catch (IOException e) {
// 			e.printStackTrace();
//		}
		
		System.out.println("======================================================");
		Properties prop2 = new Properties();
		
		System.out.println(prop2);// {}
		
		try {
			prop2.load(new FileInputStream("test.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop2);
		
		/* 
		 * properties파일을 사용하는 경우
		 * 프로그램이 기본적으로 가져야할 설정정보들을 문서로 저장시켜 두고 싶을때 사용한다.
		 * key, value모두 문자열이기 때문에 개발자가 아닌 일반 관리자도 사용하기에 용이하다.
		 * */
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
