package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		Member m = new Member();
		m.changeName("민경민");
		m.printName();
		
		Member m2 = new Member();
		m2.changeName("임세윤");
		m2.printName();
	}
}
