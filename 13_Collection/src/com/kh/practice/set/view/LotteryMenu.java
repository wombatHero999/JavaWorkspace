package com.kh.practice.set.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {

	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		System.out.println("========== KH 추첨 프로그램 ==========");
		while(true) {
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

	}

	public void insertObject() {
		// 1. Lottery객체 생성
		// 2. controoler에게 객체 전달
		// 3. 중복여부체크
		System.out.print("추가할 추첨 대상 수 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i =0; i<num; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("핸드폰 번호('-' 빼고) : ");
			String phone = sc.nextLine();
			
			Lottery l = new Lottery(name,phone);
			
			boolean result = lc.insertObject(l);
			if(!result) {
				System.out.println("중복된 대상입니다. 다시 입력해");
				i--;
			}
		}
		System.out.println("추가 완료");
	}

	public void deleteObject() {
		System.out.println("삭제할 이름과 폰번호 입력 ");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
				
		System.out.print("폰 : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name,phone);
		boolean result = lc.deleteObject(l);
		
		if(result) {
			System.out.println("삭제완");
		}else {
			System.out.println("삭제대상이 존재하지 않습니다.");
		}
	}

	public void winObject() {
//		lc에서 받아온 Set객체를 println()메소드를 통해 출력
		Set s = lc.winObject();
		System.out.println(s);
	}

	public void sortedWinObject() {
//		lc에서 받아온 Set객체를 Iterator를 통해 출력
		
		Set<Lottery> s = lc.sortedWinObject();
		Iterator<Lottery> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void searchWinner() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("핸드폰 : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name,phone);
		boolean result = lc.searchWinner(l);
		
		if(result) {
			System.out.println("당첨");
		}else {
			System.out.println("탈락");
		}
	}

}
