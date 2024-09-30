package com.kh.example.practice4.run;

import com.kh.example.practice4.model.vo.Book;

public class Run {
	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();
		
		Book b2 = new Book("자바의 정석","모름","김영한");
		b2.inform();
		
		Book b3 = new Book("자바의 정석","모름","김영한",13000, 0.5);
		b3.inform();
	}
	
	
	
	
}
