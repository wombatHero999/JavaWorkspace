package com.kh.chap2_constructor.model.vo;

public class User {
	// 필드부
	private String userId ="user01";
	private String userPwd;
	private String userName;
	
	{
		userId = "user01";
		if(true) {
			userPwd = "user02";
		}
		
	}
	private static int age;
	
	static {
		age = 1;
	}
	
	private char gender;
	
	// 생성자부
	/* 
	 * [표현법]
	 * [public/접근제한자] 클래스명(매개변수){
	 * 	// 실행할 코드
	 * }
	 * 
	 * 생성자를 작성하는 목적
	 * 1. 객체를 생성해주기 위한 목적
	 * 2. 생성자를 통해 필드값을 초기화 하기위한 목적
	 * 
	 * 생성자 작성시 주의사항
	 * 1. 생성자의 이름은 반드시 클래스명과 동일
	 * 2. 반환형이 존재하지 않는다
	 * 3. 여러개 생성이 가능하지만, "매개변수"가 중복되명 안된다. => 생성자 오버로딩
	 * 4. 매개변수가 존재하는 생성자를 작성하게 되면 기본생성자를 JVM이 자동으로 만들어주지 않는다.
	 * */
	// NoArgsConstrouctr
	public User() {
		// 기본생성자(매개변수 없는 생성자)
		// 객체 생성을 위해 사용
		// 기본생성자를 생략하는 경우 JVM이 자동으로 기본생성자를 만들어줌
		// 단, 매개변수 있는 생성자를 만든경우에는 자동으로 만들어주지 않는다.
		this.age = 1;
		System.out.println("현재 객체의 나이는 ? "+age);
	}
	
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName= userName;
	}
	
	// AllArgsConstructor
	public User(String userId, String userPwd, String userName, int age, char gender) {
		/*
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
		*/
		this(userId, userPwd , userName);
		
		this.age = age;
		this.gender = gender;
	}
	// 메서드부
	// 각 필드값을 초기화할수 있는 setter 메서드 작성
	// 현재 객체의 모든 필드값을 문자열로 반환해주는 information 메서드 작성
	// 각 필드값을 공백으로 구분 
	// ex) "user01 pass01 mkm"
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getUserName () {
		return userName;
	}
	
	public String information() {
		return userId+" "+userPwd+" "+userName+" "+age+" "+gender;
	}
	
	
	
	
	
	
	
	
	
	
	
}
