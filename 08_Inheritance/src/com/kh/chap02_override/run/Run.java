package com.kh.chap02_override.run;

import com.kh.chap02_override.model.vo.Book;

public class Run {
	public static void main(String[] args) {
		Book b1 = new Book("수학의 정석","나수학",15000);
		
		System.out.println(b1);
		//System.out.println(b1.toString());		
	}
}
