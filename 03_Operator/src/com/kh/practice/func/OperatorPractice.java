package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {

	Scanner sc = new Scanner(System.in);

	public void method1() {
		System.out.print("인원수 : ");
		int num = sc.nextInt();
		
		System.out.print("사탕개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (candy/num));
		System.out.println("남는 사탕 개수 : " + (candy%num));
	}

	public void method2() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int classes = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		
		sc.nextLine();//개행문자 비워주기
		System.out.print("성별(M/F) : ");
		char ch = sc.nextLine().charAt(0);
		
		String gender = ch == 'M' ? "남학생" : "여학생";
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		float score = sc.nextFloat();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다."
				,grade, classes, num, name, gender,score);
	}

	public void method3() {
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String str = age <= 13 ? "어린이" : (age <= 19 ? "청소년" : "어른");
		// 13세이하 어린이
		// 13초과 19 이하 청소년
		// 그외 어른
		
		System.out.println(str);
	}

	public void method4() {
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int total = kor+eng+math;
		double avg = total / 3.0;

		System.out.println("합계 : "+total);
		System.out.println("평균 : "+avg);
		
		String pass = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격";
		System.out.println(pass);
	}

	public void method5() {
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String resNo = sc.nextLine();
		char gender = resNo.charAt(7); // 주민번호 뒤 첫번째 자리
		String str  = gender == '1' || gender == '3' ? "남자" : "여자";
		//String str2 = gender == 1   || gender == 3 ? "남자" : "여자";
		
		System.out.println(str);
	}
	
	public void method6() {
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean result = (input <= num1 || input > num2) ? true : false;
		System.out.println(result);	
	}
	
	public void method7() {
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		boolean result = num1 == num2 && num2 == num3 ? true : false;
		System.out.println(result);
	}
	
	public void method8() {
		System.out.print("A사원의 연봉 : ");
		int salaryA = sc.nextInt();
		
		System.out.print("B사원의 연봉 : ");
		int salaryB = sc.nextInt();
		
		System.out.print("C사원의 연봉 : ");
		int salaryC = sc.nextInt();
		
		/*
		 * double inA = salaryA * 1.4; System.out.print("A사원 연봉/연봉+a : ");
		 * System.out.println(salaryA+"/"+inA); System.out.println("3000" + (inA >= 3000
		 * ? "이상":"이하"));
		 */
		
		/*
		 * double inB = salaryB * 1.0;
		 * System.out.println("B사원 연봉/연봉+a : "+salaryB+"/"+inB);
		 * System.out.println("3000" + (inB >= 3000 ? "이상":"이하"));
		 */
		/*
		 * double inC = salaryC+ salaryC * 0.15;
		 * System.out.println("C사원 연봉/연봉+a : "+salaryC+"/"+inC);
		 * System.out.println("3000" + (inC >= 3000 ? "이상":"이하"));
		 */
		calc(salaryA, 0.4);
		calc(salaryB, 0);
		calc(salaryC, 0.15);
	}
	
	public void calc(int salary, double ins) {
		double in = salary+ salary * ins;
		System.out.println("사원 연봉/연봉+a : "+salary+"/"+in);
		System.out.println("3000" + (in >= 3000 ? "이상":"이하"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
