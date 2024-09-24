package com.kh.variable;

public class A_Variable {
	
	//시급과 근무시간, 근무일수를 계산하는 메서드
	public void printVariable() {
		System.out.println("=== 변수 사용 전 ===");
		
		System.out.println("시급 : 8500");
		System.out.println("근무시간 : 6");
		System.out.println("근무일 : 12");
		
		// 월급 = 시급 x 근무시간 x 근무일 
		// 민경민 : 00000원을 받습니다.
		System.out.println("민경민1 : "+(11000 * 6 * 12)+"원을 받습니다." );
		System.out.println("민경민2 : "+(12000 * 6 * 12)+"원을 받습니다." );
		System.out.println("민경민3 : "+(13000 * 6 * 12)+"원을 받습니다." );
		System.out.println("민경민4 : "+(10000 * 6 * 12)+"원을 받습니다." );
		System.out.println("민경민5 : "+(10000 * 6 * 12)+"원을 받습니다." );
		System.out.println("민경민6 : "+(10000 * 6 * 12)+"원을 받습니다." );
		
		System.out.println("=== 변수 사용 후 ===");
		int pay = 11000;
		int time = 6;
		int day = 12;
		
		System.out.println("시급 : "+pay);
		System.out.println("근무시간 : "+time);
		System.out.println("근무일수 : "+day);
		
		//sysout + ctrl+spacebar
		System.out.println("민경민 : "+(pay * time * day)+"원입니다");
		
		/* 
		 * 변수를 사용하는 이유
		 * 1. 변수는 우선적으로 값에 의미를 부여할 목적으로 사용(가독성 확보)
		 * 2. 한번 값을 기록해두고 필요할때 마다 계속 사용할 목적으로 사용(재사용성)
		 * 3. 유지보수를 쉽게 할 수 있다.
		 * */
	}
	
	public void declareVariable() {
		/* 
		 * 변수를 선언(값을 기록하기위해 메모리(RAM)에 공간을 확보해두겠다.)
		 * [표현법]
		 * 자료형 변수명;
		 * 
		 * 자료형 : 어떤값을 담아낼지, 어떤 크기의 값을 담아낼지에 따라
		 *         변수의 크기 및 모양을 지정하는 부분.
		 * 변수명 : 변수의 이름을 정하는 부분.        
		 * 
		 * 주의할점
		 * 1. 변수명은 소문자로 시작하게끔 이름 지어줄것.
		 * 2. 낙타등표기법 지키기(자바) ✨✨
		 *  ex) String userName; (o)
		 *      String username; (x)
		 * 3. 같은 영역안에서는 동일한 변수명 선언 불가.    
		 * 4. 해당 영역안에서 선언된 변수는 해당 영역에서만 사용 가능.
		 * 5. 기본예약어는 변수명으로 선언할 수 없다. 
		 * */
		
		// bit-> 0/1
		// 1. 논리형(1byte == 8bit) -> true/false (기본자료형)
		boolean isTrue;
		
		// 2. 숫자형(기본자료형)
		// 2_1. 정수형
		byte bNum; // 1byte(-128 ~ 127)
		short sNum;// 2byte(-30000~30000)
		int iNum;// 4byte(-21억 ~ 21억) => 대표자료형
		long lNum;// 8byte
		
		// 2_2. 실수형 -> byte크기에 따라 소수점 아래 더 많은 숫자를 담는다
		float fNum; // 4byte => 소숫점아래 7자리까지 표현 가능
		double dNum;// 8byte => 소숫점아래 15짜리까지 표현 가능(대표자료형)
		
		// 3.문자형(기본자료형)
		char ch; // 2byte
		
		// 4.문자열(참조자료형)
		String str;
		
		/* 
		 * 변수에 값 대입
		 * 변수명 = 값;
		 * */
		 isTrue = true;
		 
		 bNum = 127;
		 sNum = 2;
		 iNum = 10;
		 lNum = 8L; //long자료형임을 알려주기 위해 소문자,대문자 L표기
		 
		 fNum = 4.0f;// 반드시 f붙여줘야함.
		 dNum = 8.0;
		 
		 ch = '1';// 반드시 ''(작은따옴표)안에 넣어줘야한다.
		 str = "Hello World";//반드시 ""(큰따옴표)안에 넣어줘야한다.
	}
	
	public void initVariable() {
		/* 
		 * 변수 선언과 동시에 초기화(값 대입)
		 * [표현법]
		 * 자료형 변수명 = 값;
		 * */
		boolean isFalse = false;
		
		byte bNum = 1;
		short sNum = 2;
		int iNum = 4;
		long lNum = 999_999_999_999L;
		
		float fNum = 4.0f;
		double dNum = 8.0;
		
		// ctrl + alt + 방향키
		System.out.println("iNum에 들어간 값 ? "+iNum);
		System.out.println("lNum에 들어간 값 ? "+lNum);
		
		System.out.println("fNum에 들어간 값 ? "+fNum);
		System.out.println("dNum에 들어간 값 ? "+dNum);
	}
	
	public void constant() {
		int age = 20;
		age = 25;
		
		final int AGE_AGE = 20;
		//AGE_AGE = 25;
	}
	
	
	
}
