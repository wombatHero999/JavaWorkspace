package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");

		System.out.print("메뉴번호를 입력하세요 : ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.print("입력");
			break;
		case 2:
			System.out.print("수정");
			break;
		case 3:
			System.out.print("조회");
			break;
		case 4:
			System.out.print("삭제");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			return;
		}
		System.out.println(" 메뉴입니다.");

	}

	public void practice2() {
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();

		// 입력 받은 정수가 양수이면서 짝수일 때만 “짝수다”를
		if (num > 0 && num % 2 == 0) {
			System.out.println("짝수다");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("홀수다");
		} else {
			System.out.println("양수만 입력해 주세요.");
		}
	}

	public void practice3() {
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();

		System.out.print("수학점수 : ");
		int math = sc.nextInt();

		System.out.print("영어점수 : ");
		int eng = sc.nextInt();

		double avg = (kor + math + eng) / 3.0;
		boolean result = kor >= 40 && math >= 40 && eng >= 40 && avg >= 60;

		if (result) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + (kor + math + eng));
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다..");
		}

	}

	public void practice5() {
		String id = "minmin";
		String pwd = "Min1234";

		System.out.print("아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String inputPwd = sc.nextLine();

		if (id.equals(inputId) && pwd.equals(inputPwd)) {
			System.out.println("로그인 성공");
		} else if (id.equals(inputId) && !pwd.equals(inputPwd)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else if (!id.equals(inputId) && pwd.equals(inputPwd)) {
			System.out.println("아이디가 틀렸습니다.");
		} else {
			System.out.println("다 틀렸습니다.");
		}
	}

	public void practice6() {
		System.out.print("권한을 확인하고자 하는 회원 등급 :");
		String role = sc.nextLine();

//		if(role.equals("관리자")) {
//			System.out.println("회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성");
//		}else if(role.equals("회원")) {
//			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");			
//		}else {
//			System.out.println("게시글 조회");
//		}
		switch (role) {
		case "관리자":
			System.out.print("회원관리, 게시글관리,");
		case "회원":
			System.out.print("게시글작성, 댓글작성, ");
		case "비회원":
			System.out.print("게시글 조회");
		}
	}

	public void practice7() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double m = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double kg = sc.nextDouble();

		double bmi = kg / (m * m);

		System.out.println("BMI 지수 : " + bmi);

		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if (bmi < 23) {
			System.out.println("정상체중");
		} else if (bmi < 25) {
			System.out.println("과체중");
		} else if (bmi < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}
	}

	public void practice8() {
		System.out.print("피연산자1 입력 :");
		int num1 = sc.nextInt();

		System.out.print("피연산자2 입력 :");
		int num2 = sc.nextInt();

		System.out.print("연산자를 입력(+,-,*,/,%) :");
		char op = sc.next().charAt(0);

//		double result = 0;
//		switch(op) {
//		case '+' : result = num1+num2; break;
//		case '-' : result = num1-num2; break;
//		case '*' : result = num1*num2; break;
//		case '/' : result = num1/num2; break;
//		case '%' : result = num1%num2; break;
//		} 
//		System.out.printf("%d %c %d = %f", num1, op, num2, result);

		System.out.printf("%d %c %d = ", num1, op, num2);
		switch (op) {
		case '+':
			System.out.print(num1 + num2);
			break;
		case '-':
			System.out.print(num1 - num2);
			break;
		case '*':
			System.out.print(num1 * num2);
			break;
		case '/':
			System.out.print(num1 / (double) num2);
			break;
		case '%':
			System.out.print(num1 % (double) num2);
			break;
		}
	}

	public void practice9() {
		System.out.print("중간 고사 점수 : ");
		int semiScore = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int finalScore = sc.nextInt();

		System.out.print("과제 점수 : ");
		int homeworkScore = sc.nextInt();

		System.out.print("출석 회수 : ");
		int attend = sc.nextInt();

		System.out.println("================= 결과 ==================");

		if (attend > (20 * 0.7)) {
			System.out.println("중간 고사 점수(20) : " + semiScore * 0.2);
			System.out.println("기말 고사 점수(30) : " + finalScore * 0.3);
			System.out.println("과제 점수    (30) : " + homeworkScore * 0.3);
			System.out.println("출석 점수    (20) : " + (double) attend);
			double total = semiScore * 0.2 + finalScore * 0.3 + homeworkScore * 0.3 + attend;
			System.out.println("총점 : " + (total));
			System.out.println(total >= 70 ? "PASS" : "Fail");
		} else {
			System.out.println("Fail [출석 회수 부족(" + attend + "/20)");
		}

	}
}
