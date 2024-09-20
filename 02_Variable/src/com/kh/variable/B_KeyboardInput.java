package com.kh.variable;

import java.util.Scanner;

// 사용자가 키보드로 입력한 값을 변수에 기록
public class B_KeyboardInput {	
	
	public void inputTest1() {
		//java.util.Scanner를 이용하여 변수에 값을 기록
		Scanner sc = new Scanner(System.in);
		
		// 사용자의 인적사항 입력받기
		System.out.print("당신의 이름은 ? ");
		
		/* 
		 * 입력한 값을 문자열로 받아오는 메서드들 : nextLine(), next()
		 * */
		String name = sc.nextLine();
		//String name = sc.next();
		
		System.out.print("당신의 나이는 ? ");
		int age = sc.nextInt();
		
		sc.nextLine();// \n 삭제시켜줌
		System.out.print("어디살아요 ? ");
		String address = sc.nextLine();// \n(개행문자) 앞까지의 문자를 저장.
		
		System.out.print("당신의 키는 ? ");
		double height = sc.nextDouble();
		
		System.out.print(age+"세의 키는 "+height+"cm인 ");
		System.out.println(name+"님 안녕하세요");
	}
	
	public void inputTest2() {
		
		Scanner sc = new Scanner(System.in);
		
		/* 
		 * 문자열을 뽑을 때 => nextLine, next
		 * 정수값을 뽑을 때 => nextInt, nextByte, nextShort, nextLong
		 * 실수값을 뽑을 때 => nextDouble , nextFloat
		 * 
		 * nextChar => X
		 * */
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);// 문자열을 입력받은 후 
		// 그 문자열의 0번째 문자 추출
		// "apple" 
		//  01234
		
		System.out.println(name+"님의 성별은 "+gender+"입니다.");
	}
}
