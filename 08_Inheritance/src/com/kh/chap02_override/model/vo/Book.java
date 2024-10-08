package com.kh.chap02_override.model.vo;

public class Book /* extends Object */ {
	
	private String title;
	private String author;
	private int price;
	
	public Book() {
		
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * 오버라이딩
	 *  - 상속받고 있는 부모클래스의 메서드를 자식클래스에서 "재정의"하는 것
	 *  - 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미.
	 *  
	 * 오버라이딩 성립조건
	 *  - 부모메소드의 메소드명과 동일
	 *  - 매개변수 자료형,갯수,순서가 동일
	 *  - 반환형도 동일 
	 *  - 부모메소드의 접근제한자보다 같거나, 공유범위가 더 커야한다.
	 * 
	 * @Override 어노테이션
	 * - 생략가능
	 * - 붙이는 이유?
	 *   > 잘못 기술한 경우 오류를 알려줌으로써 수정이 가능.
	 *   > 혹시라도 한번 재정의된 부모메소드가 수정되는 경우 오류를 통해 검토가 가능하도록 유도한다.
	 *   > 현재 메소드가 오버라이딩된 메소드임을 알리기 위한 목적.
	 *  */
	
	@Override
	public String toString()  {
		return "title : "+title+", author : "+author+", price : "+price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
