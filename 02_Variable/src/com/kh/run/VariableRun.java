package com.kh.run;

import com.kh.variable.A_Variable;
import com.kh.variable.B_KeyboardInput;
import com.kh.variable.C_Cast;
import com.kh.variable.D_Printf;

public class VariableRun {
	
	//자바 프로그램의 진입점
	/*
	 * ㅋㅋ
	 *  */
	public static void main(String[] args) {
		A_Variable av = new A_Variable();
		//av.printVariable();
		//av.initVariable();
		
		B_KeyboardInput bki = new B_KeyboardInput();
		//bki.inputTest2();
		
		C_Cast cc = new C_Cast();
		//cc.autoCasting();
		//cc.forceCastring();
		
		D_Printf df = new D_Printf();
		df.printfTest();
	}
	
}
