package com.kh.chap01_oneVsMany.run;

import com.kh.chap01_oneVsMany.model.vo.Book;

public class ObjectRun {
	
	public static void main(String[] args) {
		Book bk1 = new Book();
		bk1.setTitle("자바의 정석");
		bk1.setAuthor("자바바");
		bk1.setPrice(25000);
		bk1.setPublisher("동아");
		
		Book bk2 = new Book("C언어의 정석" , "CCC", "동아" , 27000);
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		Book bk3 = new Book(title, author, publisher,price);
		
		System.out.print("검색할 책 제목 : ");
		String searchTitle = sc.next();
		
		if(searchTitle.equals(bk1.getTitle())) {
			System.out.println(searchTitle+"의 가격 : "+bk1.getPrice());
		}
		
		if(searchTitle.equals(bk2.getTitle())) {
			System.out.println(searchTitle+"의 가격 : "+bk2.getPrice());
		}
		
		if(searchTitle.equals(bk3.getTitle())) {
			System.out.println(searchTitle+"의 가격 : "+bk3.getPrice());
		}
	}
	
	
	
	
	
	
	
	
	
	
}
