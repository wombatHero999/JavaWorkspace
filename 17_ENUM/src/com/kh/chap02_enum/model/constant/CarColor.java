package com.kh.chap02_enum.model.constant;

import java.util.Arrays;

// enum -> Enumeration(열거)의 약자형. 클래스 내부에 상수값들을 열거했다고 하여 enum이라고 명칭함.
// enum도 동일한 class이며, 상수 열거형 데이터들을 간결한 문법으로 다루기위해 자바에서 제공하는 클래스.
public enum CarColor {
	
	BLACK(0,"black") , RED(1,"red") , BLUE(2,"blue");
	
	private int color;
	private String lowerColor;
	
	private CarColor(int color , String lowerColor) {
		this.color = color;
		this.lowerColor = lowerColor;
		System.out.println("객체 생성됨 ㅋ");		
	}

	public int getColor() {
		return color;
	}

	public String getLowerColor() {
		return lowerColor;
	}
	
	public static CarColor valueOf(int color) {
		// CarColor의 필드값을 통해 원하는 Enum객체 찾기.
		
		// enum만의 독특한 메서드
		CarColor[] enums =values(); // 현재 Enum클래스 내부의 상수값들을 모아서 배열로 반환해주는 메소드
		// [BLACK, RED, BLUE]
		return Arrays.stream(enums)
			.filter( enu -> enu.color  == color)
			.findAny() // 찾고자하는 값이 있다면 그값을 반환
			.orElse(null); // 없다면 null반환.
	}
	
	// enum을 통해 각 상수값이 고유한 기능을 가질수 있도록 구현 가능.
	
	
	
	
	
	
	
}
