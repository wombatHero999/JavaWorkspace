package com.kh.chap03_MVC.view;

import java.util.List;
import java.util.Scanner;

import com.kh.chap03_MVC.controller.MemberController;
import com.kh.jdbc.model.vo.Member;

/* 
 * View : 사용자가 보게될 시각적인 요소를 담당.(화면 => 입력, 출력)
 * */
public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("#### 회원 프로그램 ####");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴 기능");
			System.out.print("이용할 메뉴 선택 : " );
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: insertMember(); break;
			case 2: selectAll(); break;
			case 3: selectByUserId(); break;
			case 4: selectByUserName(); break;
			case 5: updateMember(); break;
			case 6: deleteMember(); break;
			case 9: return;			
			}
		}
		
		
	}
	
	/**
	 * 사용자에게 탈퇴할 회원의 아이디를 입력받은 후 삭제 요청하는 메소드
	 *  */
	private void deleteMember() {
		
	}
	
	/**
	 * 사용자에게 변경할 회원의 아이디, 변경할 정보들(비번, 이메일, 휴대폰번호, 주소)를
	 * 입력 받은 후 변경요청하는 메소드
	 *  */
	private void updateMember() {
		
	}
	
	/** 
	 * 사용자에게 검색할 회원의 "이름"을 입력 받은 후 조회 요청하는 메소드
	 * */
	private void selectByUserName() {
		
	}
	
	/** 
	 * 사용자에게 검색할 회원의 아이디를 입력 받은 후 조회 요청하는 메소드.
	 * */
	private void selectByUserId() {
		// view -> controller -> service -> dao -> sql
	}

	private void selectAll() {
		System.out.println("----- 회원 전체 조회 -----");
		
		// 회원 정보 조회 요청
		List<Member> list = mc.selectAll();
		list.stream()
			.forEach( m -> System.out.println(m) );
	}
	
	/**
	 * 회원 추가용 화면(view)
	 * 추가하고자 하는 회원의 정보를 입력받아 controller에 회원 추가 요청을 할 수 있는 화면.
	 *  */
	private void insertMember() {
		
		System.out.println("---- 회원 추가 ----");
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		// 입력받은 정보를 통해 회원가입을 할 수 있도록, controller에게 넘긴다.
		mc.insertMember(memberId, memberPwd, memberName);
	}

	public void displaySuccess(String string) {
		System.out.println("서비스 요청 결과 : "+string);
	}

	public void displayFail(String string) {
		System.out.println("서비스 요청 결과 : "+string);
	}
	
	
	
	
	
	
	
	

}
