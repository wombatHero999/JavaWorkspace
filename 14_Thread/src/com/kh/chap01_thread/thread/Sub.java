package com.kh.chap01_thread.thread;

// 1. Thread 상속받기
public class Sub extends Thread {
	
	//2. 현재 쓰레드가 해야할 작업을 run()안에 기술하기.
	@Override
	public void run() {
		
		//작업할 코드
		for(int i =1; i<=100; i++) {
			System.out.println(getName()+" ["+i+"]");
		}
		
	}
}
