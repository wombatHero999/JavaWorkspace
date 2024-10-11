package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UncheckedException;
import com.kh.exception.controller.B_CheckedException;
import com.kh.exception.controller.C_CustomException;

public class Run {
	public static void main(String[] args)  {
		A_UncheckedException aue = new A_UncheckedException();
		//aue.method3();
		
		B_CheckedException bce = new B_CheckedException();
		
		//bce.method1();
		
		// 사용자 정의 에러 발생
		// 1. Exception을 상속받은 에러 객체 생성 + throw
		try {
			throw new C_CustomException("사용자 정의 에러 발생");
		}catch(C_CustomException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
