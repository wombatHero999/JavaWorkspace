package com.kh.chap03_sync.model.vo;

public class Atm implements Runnable{

	private Account acc;
	
	public Atm(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		// 잔고가 바닥날때까지 반복
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100; // 100,200,300
			acc.withdraw(money);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"종료");
	}
	

}
