package com.kh.chap02_absAndInter.part01_basic.model.vo;

public class Basketball extends Sports {
	
	/* 
	 * 추상클래스를 상속받게 되면 부모클래스에 존재하는 추상 메소드를 반드시 구현해줘야 한다.
	 * */
	
	@Override
	public void rule() {
		System.out.println("손으로 공을 던져 링에 넣어야 한다.");
	}
}
