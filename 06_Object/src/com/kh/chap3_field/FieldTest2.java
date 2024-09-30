package com.kh.chap3_field;

public class FieldTest2 {
	
	/* 
	 * (+) public    => 어디서든(같은 패키지, 다른 패키지) 접근 가능하게 하고싶다
	 * (#) protected => 같은패키지면 접근가능하게, 다른패키지인경우 상속구조라면 접근하게 하고싶다. 
	 * (~) default   => 같은패키지면 접근가능.
	 * (-) private   => 오직 해당 클래스 내부에서만 접근하게 하고싶다.
	 * */
	
	public String pub = "public";
	protected String pro = "protected";
	String def = "default";
	private String pri = "private";
	
}






