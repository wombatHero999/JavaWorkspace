package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController(); // 초기화 생성
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		// 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
		 // LibraryController의 insertMember() 메소드에 전달
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		lc.insertMember(new Member(name, age, gender));		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 :");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				selectAll(); 
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("프로그램 종료"); return;
			default:
				System.out.println("잘못입력 했습니다. ");
			}
			
		}
		

	}

	public void selectAll() {
		// LibraryController의 selectAll()메소드 호출하여
		Book[] bList = lc.selectAll();
		// 결과 값 ==> return 결과값 Book[] 자료형 bList에 담기
		
		for(int i =0; i<bList.length; i++) {
			Book b = bList[i];
			System.out.printf("%d번도서 : %s / %s / %s / %s%n", i , b.getTitle() , b.getAuthor(), b.getPublisher()
					, b instanceof AniBook ? 
							((AniBook)b).getAccessAge() : 
							((CookBook)b).isCoupon()
					);	
			System.out.println(i+"번도서 : "+b);
		}
		// for문 이용하여 bList의 모든 도서 목록 출력
		// 단, i를 이용하여 인덱스도 같이 출력 → 대여할 때 도서번호를 알기 위해
		// ex ) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
	}

	public void searchBook() {
		// “검색할 제목 키워드 : “ >> 입력 받음 (keyword)
		// LibraryController의 searchBook() 에 전달
		// 그 결과 값을 Book[] 자료형 searchList에 담아 검색 결과인 도서 목록 출력
		
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.next();
		
		Book[] searchList = lc.searchBook(keyword);
		//System.out.println(searchList);
		for(Book b : searchList) {
			//if(b != null)
			System.out.println(b);
		}
	}

	public void rentBook() {
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		
		int result = lc.renBook(index);
		
		if(result == 0) {
			System.out.println("성공적으로 대여되었습니다.");
		}else if (result == 1) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		}else {
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
		}
	}
}
