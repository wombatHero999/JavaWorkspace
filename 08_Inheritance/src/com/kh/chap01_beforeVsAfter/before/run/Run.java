package com.kh.chap01_beforeVsAfter.before.run;

import com.kh.chap01_beforeVsAfter.before.model.vo.Desktop;
import com.kh.chap01_beforeVsAfter.before.model.vo.SmartPhone;
import com.kh.chap01_beforeVsAfter.before.model.vo.Tv;

public class Run {
	public static void main(String[] args) {
		// Desktop
		Desktop d = new Desktop("삼성","d-01","데탑1",150000,true);
		
		// SmartPhone
		SmartPhone sp = new SmartPhone("애플","s-01","아이폰 16",1700000,"KT");
		
		// Tv
		Tv t = new Tv("LG", "t-01","slim티비",3500000,60);
		
		
		System.out.println(d.information());
		System.out.println(sp.information());
		System.out.println(t.information());
	}
	
	
	
	
	
	
	
}
