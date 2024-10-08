package com.kh.chap02_absAndInter.part02_family.run;

import com.kh.chap02_absAndInter.part02_family.model.vo.Baby;
import com.kh.chap02_absAndInter.part02_family.model.vo.Basic;
import com.kh.chap02_absAndInter.part02_family.model.vo.Mother;
import com.kh.chap02_absAndInter.part02_family.model.vo.Person;

public class FamilyRun {
	public static void main(String[] args) {
		// 인터페이스 적용 전
//		Person p1 = new Mother("민경민", 87, 30);
//		Person p2 = new Baby("코코", 5, 70);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		
//		p1.eat();
//		p2.eat();
//		p1.sleep();
//		p2.sleep();
//		
//		System.out.println("======= 다음날 ==========");
//		System.out.println(p1);
//		System.out.println(p2);
		
		Basic p1 = new Mother("민경민", 87, 30);
		Basic p2 = new Baby("코코", 5, 70);
		
		System.out.println(p1);
		System.out.println(p2);
		
		p1.eat();
		p2.eat();
		p1.sleep();
		p2.sleep();
		
		System.out.println("======= 다음날 ==========");
		System.out.println(p1);
		System.out.println(p2);
		
		
		
		
		
	}
}
