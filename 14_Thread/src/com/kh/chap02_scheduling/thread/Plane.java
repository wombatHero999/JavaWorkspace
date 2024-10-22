package com.kh.chap02_scheduling.thread;

public class Plane implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i< 20; i++) {
			
			System.out.println("Plane fly...");
			
			try {
				// 현재 스레드를 지정된 시간만큼 지연(일시정지)시키는 코드
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}
		
	}

}
