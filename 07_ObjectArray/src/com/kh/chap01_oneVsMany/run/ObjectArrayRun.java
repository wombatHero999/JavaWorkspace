package com.kh.chap01_oneVsMany.run;

import java.util.Scanner;

import com.kh.chap01_oneVsMany.model.vo.Book;
import com.kh.chap02_objectArray.model.vo.Phone;
import com.kh.chap02_objectArray.model.vo.Phone;

public class ObjectArrayRun {
	public static void main(String[] args) {
		Book[] arr = new Book[3];
		int [] iArr= {1,2,3,4,5};
		Book[] bArr = {new Book()};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<arr.length; i++) {
			
			System.out.print("제목 : ");
			String title = sc.nextLine();
			
			System.out.print("저자 : ");
			String author = sc.nextLine();
			
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			arr[i] = new Book(title, author, publisher, price );
			//arr[i].setPrice(price);
		}
		
		for(int i =0; i <arr.length; i++) {
			System.out.println(arr[i].information());
		}
		
		System.out.print("검색할 책 제목 : ");
		String searchTitle = sc.next();
		
		//"반복문"을 활용하여 내가 검색한 책의 제목과 일치하는 도서의 가격정보를 출력
		//만약 일치하는 도서를 찾지 못한 경우 "검색된 도서가 없습니다" 출력
		for(int i =0; i<arr.length;i++) {
			if(searchTitle.equals(arr[i].getTitle())) {
				System.out.println(searchTitle+"의 가격 : "+arr[i].getPrice());
				return;
			}
		}
		System.out.println("검색된 도서가 없습니다.");
		
		
		
		
	}
}
