package com.kh.jdbc.model.vo;

import java.sql.Date;

public class Member {
	/*
	 * VO - DB 데이터를 저장하거나 보관하기 위해 사용하는 클래스 - 어플리케이션을 이루는데 있어서 핵심적인 역할을 하는 클래스 -
	 * 객체지향적으로 설계된 클래스이며, 내부적으로 캡슐화와 상속이 구현되어 있다. - DB테이블의 한 행에 대한 정보를 기록하기위해 사용한다.
	 * 
	 * DTO - Data Transfer Object 어플리케이션간에 데이터를 송수신 하기 위한 용도의 클래스. - API서버간의 데이터
	 * 송수신이 주 목적으로 좀더 많이 활용된다 - 의미상으로는 DTO에 데이터베이스의 행의 정보를 기록하는게 맞다.
	 */

	// 필드부 : DB테이블의 칼럼 정보를 작성
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private int age;
	private java.sql.Date enrollDate;

	public Member(String memberId, String memberPwd, String memberName, String gender, String email, String phone,
			String address, int age, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public Member() {

	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", age=" + age
				+ ", enrollDate=" + enrollDate + "]";
	}

}
