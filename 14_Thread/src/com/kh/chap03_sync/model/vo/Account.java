package com.kh.chap03_sync.model.vo;

// 공유자원
// 2개의 ATM기 쓰레드가 동시에 Account에 접근하는 상황을 만들예정
public class Account {

	private int balance = 2000;
	
	public int getBalance() {
		return balance;
	}
	/* 
	 * 동기화 처리
	 * 1. 메소드에 synchronized 예약어 추가. 메소드 전체에 잠금을 걸고, 메소드 종료시 잠금을 해제한다.
	 * 2. synchronized block 사용하기. 동기화가 필요한 특정 부분만 잠금을 건다. 임계영역(통제영역)이 아닌
	 *    지역까지는 모든 스레드가 접근 가능하기 때문에 좀더 효율이 좋다.
	 * */	
	public /* synchronized */ void withdraw(int money) {
		String thName = Thread.currentThread().getName();
		
		synchronized(this) {
			System.out.println("현재 잔액은 ? "+balance);
			// 출금할 돈이 충분하다면
			if(money <= balance) {
				balance -= money;
				System.out.printf("[%s] %d원 출금 >>> 잔액 : %d\n", thName, money, balance);
			}else {
				System.out.printf("[%s] %d원 출금시도 >>> 잔액이 부족합니다. \n", thName, money);
			}
		}
	}
	
	
	
	
	
	
}

