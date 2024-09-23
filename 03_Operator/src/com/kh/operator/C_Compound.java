package com.kh.operator;

public class C_Compound {

	/* 
	 * 복합대입연산자
	 * += , -= , *=  
	 * */
	
	public void method() {
		
		int num = 12;
		
		System.out.println("현재 num : "+num);
		
		//num = num +3;
		num += 3;
		System.out.println("3증가시킨 num : "+num);//15
		
		//num에서 -5시키기
		//num = num -5;
		num -= 5;
		System.out.println("5감소 num : "+num);
		// num에서 6배 증가
		num *= 6; // num = num*6;
		System.out.println("6배 증가 num : "+num);
		
		// num을 2배 감소
		//num = num/2;
		num /= 2;
		System.out.println("2배 감소 num : "+num);
		
		// num을 4로 나눴을때의 나머지값을 num에 대입
		//num = num % 4;
		num %= 4;
		System.out.println("최종 num : "+num);
		
		String str = "Hello";
		str += "World";
		
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		C_Compound cc = new C_Compound();
		cc.method();
	}
	
	
	
	
}
