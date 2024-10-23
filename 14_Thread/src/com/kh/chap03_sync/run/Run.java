package com.kh.chap03_sync.run;

import com.kh.chap03_sync.model.vo.Account;
import com.kh.chap03_sync.model.vo.Atm;

public class Run {
	/* 
	 * 동기화
	 *  - 멀티 쓰레드 프로그램에서 스레드간에 경쟁상태에 있는 공유자원에 대한 임계영역을 지정해주는 것.
	 *  
	 *  - 멀티쓰레드 프로그램에서 여러 쓰레드가 동시에 하나의 공유자원(객체)에 접근하는 것을 "경쟁상태"라고 부름
	 *    이를 방지하기 위해서는 공유자원(객체)에 접근할때 한번에 한개의 쓰레드만 접근할수 있도록 통제해야하는데,
	 *    통제하기 위에 해당 자원을 임계영역(통제영역)으로 지정을하고 통제를 위해서는 "동기화(synchronized)"
	 *    키워드가 필요하다.
	 * */	
	public static void main(String[] args) {
		Account acc = new Account();// 공유자원
		Runnable run1 = new Atm(acc);
		Runnable run2 = new Atm(acc);
		
		Thread atm1 = new Thread(run1,"1번 Atm기");
		Thread atm2 = new Thread(run2,"2번 Atm기");
		
		atm1.start();
		atm2.start();
		
		
	}
	
	
	
	
	
	
	
	
	
}
