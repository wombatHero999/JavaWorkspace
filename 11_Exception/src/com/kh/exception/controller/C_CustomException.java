package com.kh.exception.controller;

public class C_CustomException extends Exception{
	/*
	 *  특정상황에서 발생하는 에러를 내가 직접 만드는 방법
	 *  1. Exception클래스를 상속받음
	 *  2. super키워드를 통해 부모생성자에 에러메세지를 전달한다.  
	 *  */
	public C_CustomException() {
		
	}
	
	public C_CustomException(String msg) {
		super(msg);
	}
	
	
}
