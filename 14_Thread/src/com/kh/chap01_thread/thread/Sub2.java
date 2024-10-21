package com.kh.chap01_thread.thread;

// 1. Runnable 인터페이스 구현
public class Sub2 implements Runnable{

	@Override
	public void run() {
		//2. 작업할 코드 기술
		for(int i = 1; i<= 100; i++) {
			System.out.println(Thread.currentThread().getName()+" ["+i+"]"  );
		}
		
	}
}
