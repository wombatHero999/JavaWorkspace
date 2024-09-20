package com.kh.variable;

public class C_Cast {
	/* 
	 * (자료)형변환 : 값의 자료형을 바꾸는 개념
	 * 
	 * 컴퓨터의 값 처리 규칙
	 * 1. 연산자를 기준으로 왼쪽과 오른쪽은 같은 자료형이어야 함.
	 *    => (=) 값을 대입할때는 같은 자료형에 해당하는 값만 대입이 가능.
	 *    => 서로 다른 자료형의 값을 대입하고자 할때는 "형변환"이 필수
	 * [표현법]
	 * 자료형 변수명 = (바꿀 자료형)값;
	 * 
	 * 2. 같은 자료형끼리만 연산이 가능
	 *   => 다른자료형간에 (+,-,*,/)을 수행하고 싶으면 한 쪽은 반드시 형변환 해줘야함
	 *   값1 + (바꿀 자료형)값2
	 * 
	 * 형변환의 종류
	 * 1. 자동형변환(autoCasting) : 형변환이 자동으로 진행되기 때문에 내가 직접
	 *    수행할 필요가 없음. 
	 *    작은 바이트의 자료형 -> 큰 바이트의 자료형
	 * 
	 * 2. 수동형변환(forceCasting) : 자동형변환이 되지 않아 내가 직접 형변환 해야
	 *    하는 경우
	 *    큰 바이트의 자료형 -> 작은 바이트의 자료형
	 *    (바꿀 자료형)값
 	 * */
	
	// 자동형변환 : 작은 바이트의 자료형이 큰 바이트의 자료형으로 변환되는경우
	public void autoCasting() {
		
		// 1. int(4byte) -> double(8byte)
		int i1 = 10;
		double d1 = i1;// 10.0
		
		System.out.println("d1 : "+d1);
		
		int i2 = 12;
		double d2 = 3.3;
		
		double result = (double)i2 + d2;// 12 + 3.3 => 12.0 + 3.3
		System.out.println("result : "+result);
		
		// 2. int(4byte) -> long (8byte)
		int i3 = 1000;
		long l3 = /* (long) */ i3;
		
		long l4 = 2000L;
		
		// 특이케이스 3. long(8byte) -> float(4byte)
		
		long l5 = 10000000000l;
		float f5 = l5;//100000000.0
		
		// 특이케이스 4. char(2byte) <-> int(4byte)
		char ch = 65; 		
		System.out.println("ch : "+ch);
		
		int num = 'A';
		System.out.println("num : "+num);
		
		char alp = 'A' + 10; // A 뒤 10번째  K
		
		// 특이케이스 5 . byte, short 연산
		byte b1 = 1;//자동형변환
		byte b2 = 10;
		
		// byte, short로 연산시 int로 취급
		byte b3 = (byte)(b1 + b2);// 강제형변환필요
	}
	
	//강제형변환 : 큰 크기의 자료형을 작은 크기의 자료형으로 형변환하는 경우
	public void forceCastring() {
		//1. double(8byte) -> float(4byte)
		float f1 = 4.0f;
		
		double d2 = 8.0;
		float f2 = (float) d2;
		
		//2. double -> int
		double d3 = 10.89;
		int i3 = (int) d3; // 10.89 -> 10
		System.out.println("i3 : "+i3);
		
		int iNum = 10;
		double dNum = 5.89;
		
		int iSum = iNum + (int)dNum; // 10 + 5
		int iSum2 = (int)(iNum + dNum);// 15.89 -> 15
		
		int iNum2 = 290;
		// 0000 0001 0010 0010
		byte bNum2 = (byte) iNum2;
		// xxxxxxxxx 0010 0010
		// 1bit , 1byte == 8bit
		
		System.out.println("bNum2 : "+ bNum2);
	}
	
	
	
	
	
	
	
	
	
	
}


