package com.kh.practice.map.view;

import java.util.Scanner;

import com.kh.practice.map.controller.MemberController;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {
		while (true) {
			System.out.println("========== KH 사이트 ==========");
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				joinMembership();
				break;
			case 2:
				logIn();
				memberMenu();
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("### 종료 ###");
				return;
			default:
				System.out.println("### 제대로 치세요 ###");
			}

		}
	}

	public void memberMenu() {
		******* 회원 메뉴 *******
		1. 비밀번호 바꾸기 // changePassword() 실행
		2. 이름 바꾸기 // changeName()
		3. 로그아웃 // “로그아웃 되었습니다.” 출력 후 mainMenu()로 리턴
		메뉴 번호 선택 : >> 입력 받음
		// 메뉴 화면 반복 실행 처리
		// 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
	}

	public void joinMembership() {
		회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은
		Member객체에 담고 id와 객체는 MemberController(mc)의 joinMembership()로 보냄.
		받은 결과에 따라 true면 “성공적으로 회원가입 완료하였습니다.”,
		false면 “중복된 아이디입니다. 다시 입력해주세요.” 출력
	}

	public void logIn() {
		아이디와 비밀번호를 사용자에게 받아 mc의 logIn()메소드로 넘겨 줌
		반환 값 있으면 “OOO님, 환영합니다!” 출력 후 로그인 된 화면으로(memberMenu()),
		없으면 “틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.” 출력 후 반복
	}

	public void changePassword() {
		아이디와 비밀번호, 변경할 비밀번호를 받아 mc의 chagePassword()로 보냄.
		받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”, 
		false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복

	}

	public void changeName() {
		아이디와 비밀번호를 받아 mc의 logIn()으로 넘겨 현재 저장되어 있는 이름을 받고
		사용자에게 현재 저장되어 있는 이름을 출력하여 보여줌. 
		변경할 이름을 받아 mc의 chageName()로 id와 함께 넘기고
		“이름 변경에 성공하였습니다.” 출력
		만일 logIn()로부터 저장되어 있는 이름을 받지 못 했다면
		“이름 변경에 실패했습니다. 다시 입력해주세요” 출력 후 반복

	}

	public void sameName() {
		검색할 이름을 받고 mc의 sameName()메소드로 넘김.
		반환 값을 가지고 entrySet()을 이용하여 ‘이름-아이디’ 형식으로 출력
	}

}
