package com.kh.practice.set.view;

import java.util.Scanner;

import com.kh.practice.set.controller.LotteryController;

public class LotteryMenu {

	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		System.out.println("========== KH 추첨 프로그램 ==========");
		System.out.println("******* 메인 메뉴 *******");
		System.out.println("1. 추첨 대상 추가 ");
		System.out.println("2. 추첨 대상 삭제");
		System.out.println("3. 당첨 대상 확인");
		System.out.println("4. 정렬된 당첨 대상 확인");
		System.out.println("5. 당첨 대상 검색");
		System.out.println("9. 종료");
		System.out.print("메뉴번호 : ");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			insertObject();
			break;
		case 2:
			deleteObject();
			break;
		case 3:
			winObject();
			break;
		case 4:
			sortedWinObject();
			break;
		case 5:
			searchWinner();
			break;
		case 9:
			System.out.println("끌게");
			return;
		default:
			System.out.println("똑바로쳐");
		}

	}

	public void insertObject() {
//		추가할 추첨 대상 수를 입력 받아 입력한 수만큼
//		추첨자 이름(String name)과 추첨자 핸드폰 번호(String phone)를 받고,
//		매개변수 생성자를 이용해 Lottery 객체에 추첨자 정보 저장.
//		Lottery 객체를 lc(LotteryController)의 insertObject로 전달하는데
//		단, 중복된 추첨 대상 입력했거나 또는 이미 추첨 Set에 대상이 있는 경우
//		“중복된 대상입니다. 다시 입력하세요.” 출력 후 이어서 다시 객체 입력.
//		모든 입력이 완료되면 “추가 완료되었습니다” 출력
	}

	public void deleteObject() {
//		삭제할 대상의 이름과 핸드폰 번호를 받고 매개변수 있는 Lottery 생성자를 이용해
//		객체에 정보를 담아 lc에 객체를 보냄.
//		받은 결과에 따라 true면 “삭제 완료 되었습니다.”,
//		false면 “존재하지 않는 대상입니다.” 출력
	}

	public void winObject() {
//		lc에서 받아온 Set객체를 println()메소드를 통해 출력
	}

	public void sortedWinObject() {
//		lc에서 받아온 Set객체를 Iterator를 통해 출력
	}

	public void searchWinner() {
//		검색할 대상의 이름과 핸드폰 번호를 받고 매개변수 있는 Lottery 생성자를 이용해
//		객체에 정보를 담아 lc에 객체를 보냄.
//		받은 결과에 따라 true면 “축하합니다. 당첨 목록에 존재합니다.”,
//		false면 “안타깝지만 당첨 목록에 존재하지 않습니다.” 출력

	}

}
