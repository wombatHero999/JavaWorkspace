package com.kh.chap02_absAndInter.part01_basic.model.vo;

public abstract class Sports {
	
	private int people; // 선수 인원
	
	public Sports() {
		
	}

	public Sports(int people) {
		super();
		this.people = people;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Sports [people=" + people + "]";
	}
	
	
	/*
	 *  몸통부가 존재하지 않는 미완성 메소드 == 추상메소드
	 *  몸통부가 없는 미완성 메소드를 정의하고자 한다면 메소드에 abstract 예약어를 붙이고, 
	 *  
	 *  이렇게 미완성된 메소드가 단 하나라도 포함되는 순간 현재 클래스 또한 abstract예약어를 붙여줘야한다.	 *  
	 *  */
	public abstract void rule();
	
	/* 
	 * 템플릿 메서드 패턴
	 *  - 추상 클래스로 프레임워크 설계시 자주 사용되는 설계패턴중의 하나.
	 *  - 어플리케이션의 전체적인 "실행 흐름"(메소드 호출 순서) 특정 메소드에 모두 기술한 후 
	 *    클래스를 상속받는 자식 클래스마다 다르게 구현되어야 하는 일부 메소드를 추상메소드로 직접 구현하게하는 패턴
	 * */
	
	public void enterPlayer() {
		System.out.println(people+"명의 선수들이 입장합니다.");
	}
	
	public void go() {
		System.out.println("경기 시작");
	}
	
	public void stop() {
		System.out.println("경기 종료");
	}
	
	// 규칙 설명 -> 선수 입장 -> 경기 시작 -> 경기 종료 
	// 템플릿 메서드?
	// 추상 메서드, 구현된 메소드를 모두 활용하여 프로그램의 전체 흐름을 정의하는 메서드
	// 재정의되면 안되기 때문에 final예약어를 사용한다.
	final public void startGame() {
		// 규칙설명
		rule();
		// 선수 입장
		enterPlayer();
		// 경기 시작
		go();
		// 경기 종료
		stop();
	}
	
	
	
	

}
