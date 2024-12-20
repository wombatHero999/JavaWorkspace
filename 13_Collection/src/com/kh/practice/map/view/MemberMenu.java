package com.kh.practice.map.view;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

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
		while(true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 선택 :");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: changePassword(); break;
			case 2: changeName(); break;
			case 3: System.out.println("로그아웃 되었습니다.");  return;
			default: System.out.println("다시 입력");
			}
		}
	}

	public void joinMembership() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Member m = new Member(pw,name);
		boolean result = mc.joinMembership(id, m);
		
		if(result) {
			System.out.println("성공적으로 회원가입 완료하였습니다.");
		}else {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
	}

	public void logIn() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			
			String name = mc.logIn(id, pw);
			
			if(name == null) {
				System.out.println("틀린 아이디 또는 비번임");
			}else {
				System.out.println(name+"님 환영합니다!");
				
				break;
			}
		}
	}

	public void changePassword() {
		
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			
			System.out.print("변경할 비밀번호 : ");
			String chPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, pw, chPw);
			if(result) {
				System.out.println("비밀번호 변경에 성공했습니다.");
				break;
			}
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
		}

	}

	public void changeName() {
		while(true) {
			// 1. login함수 호출
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비번 : ");
			String pw = sc.nextLine();
			
			String name = mc.logIn(id, pw);
			if(name == null) {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
				continue;
			}
			// 2. changeName 함수 호출
			System.out.println("현재 설정된 이름 : "+name);
			System.out.print("변경할 이름 : ");
			String changeName = sc.nextLine();
			mc.changeName(id, changeName);
			
			System.out.println("이름 변경에 성공하였습니다.");
			break;
		}
	}

	public void sameName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		TreeMap<String, String> tm = mc.sameName(name);
		
		Set<Entry<String,String>> entSet =tm.entrySet();
		for(Entry<String, String> e : entSet) {
			String name2 = e.getValue();
			String id = e.getKey();
			System.out.println(name2+"-"+id);
		}
	}
	
}
