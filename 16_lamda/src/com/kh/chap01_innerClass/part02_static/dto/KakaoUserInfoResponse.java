package com.kh.chap01_innerClass.part02_static.dto;

import java.util.Date;

//@Set 
//@Get
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class KakaoUserInfoResponse {
	/* 
	 * VO(Value Object)
	 *  - 어플리케이션을 이루는데 있어서 핵심적인 역할을 하는 클래스들을 정의한 클래스.
	 *  - "객체지향적으로 설계된 클래스"이며 내부적으로 캡슐화 및 상속이 구현되어 있고 필요에 따라 equals나
	 *    hashCode등의 함수를 재정의하여 내부에 기능을 추가하기도 한다.
	 * 
	 * 
	 * DTO(Data Transfer Object)
	 *  - API서버간에 데이터 송수신시 활용되는 클래스.
	 *  - 어플리케이션의 비지니스로직에 사용되는 VO클래스들과는 다르게 데이터 "송수신"목적으로 사용하기 때문에
	 *    불필요한 메서드나 상속이 존재하지 않는다. 오직 데이터 저장 및 조회기능의 메서드만 존재.
	 *  - API서버에서 제공하는 응답데이터를 DTO클래스로 정의하고 사용한다.
	 *  - 거대 API서버 같은 경우 굉장히 만흔 기능(서비스)이 있고 기능마다 요구하는 주소, 및 요청변수, 응답
	 *    데이터가 다양하기 때문에 굉장히 많은 DTO클래스가 나올 수 있다. 
	 *  - 너무 많은 클래스가 있다면 유지보수 및 관리가 힘드므로 하나의 클래스안에 정적내부클래스 여러개를 만드는
	 *    방식이 주로 사용된다. 
	 * */
	private Long id;
	private Boolean has_signed_up;
	private Date connected_at;
	private Date synched_at;
	private String properties; // JSON == String
	private KakaoAccount kakao_account;
	private Partner for_partner;
	
	//@Set @Get
	public static class KakaoAccount {
		private Boolean profile_needs_agreement;
		private Boolean profile_nickname_needs_agreement;
		private Boolean profile_image_needs_agreement;
	}
	
	public static class Partner{
		private String uuid;
	}
	
	public static class Profile{
		//프로필 정보
	}
	
}
