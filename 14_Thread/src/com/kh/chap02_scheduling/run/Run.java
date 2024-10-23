package com.kh.chap02_scheduling.run;

import com.kh.chap02_scheduling.thread.Car;
import com.kh.chap02_scheduling.thread.Plane;
import com.kh.chap02_scheduling.thread.Tank;

public class Run {
	/* 
	 * 스레드 스케쥴링?
	 * 스레드의 작업순서를 조절하는 방법.
	 * 
	 * 1) 우선순위 기반 스케쥴링
	 *   - 스레드마다 우선순위를 부여하는 방식
	 *   - 우선순위가 높은 스레드가 "작업시간"을 더 많이 할당 받는다.
	 *   - 코드로 우선순위 부여 가능.
	 * 
	 * 2) Round Robin 스케쥴링(순환 할당 방식)
	 *   - 각 스레드에게 작업시간을 할당하여 스레드를 정해진 만큼만 순환시켜서 실행 하는 방식
	 *   - 만약 우선순위가 같은 스레드 끼리는 Round Robin이 적용된다.
	 *   - jvm에 의해 정해지므로 코드로써 제어가 불가능
	 *   
	 * */
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Car());
		Thread t2 = new Thread(new Plane());
		Thread t3 = new Thread(new Tank());
		
		t1.setName("Car");
		t2.setName("Plane");
		t3.setName("Tank");
		
		System.out.println("-------- 우선 순위 부여 전 ----------------");
		
		System.out.println("main스레드의 우선순위 : " + Thread.currentThread().getPriority());
		System.out.println("Car의 우선순위 : "+t1.getPriority());
		System.out.println("Plane의 우선순위 : "+t2.getPriority());
		System.out.println("Tank의 우선순위 : "+t3.getPriority());
		
		// 최소값 : 1 , 최대값 10
		t1.setPriority(Thread.MIN_PRIORITY); // 1
		t3.setPriority(Thread.MAX_PRIORITY); // 10
		
		
		System.out.println("-------- 우선 순위 부여 후 ----------------");
		
		System.out.println("main스레드의 우선순위 : " + Thread.currentThread().getPriority());
		System.out.println("Car의 우선순위 : "+t1.getPriority());
		System.out.println("Plane의 우선순위 : "+t2.getPriority());
		System.out.println("Tank의 우선순위 : "+t3.getPriority());
		
		//t1.setDaemon(true);
		//t2.setDaemon(true);
		//t3.setDaemon(true);
		
		t1.start(); 
		t2.start(); 
		t3.start(); 
		
		/* 
		 * 메인스레드가 종료되더라도 실행 중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다.
		 * main스레드가 종료시 다른스레드도 함께 종료되게 하기 위해서는 setDaemon을 통해 "주종관계"설정
		 * 을 해줘야한다.
		 * 
		 * 주의점은 스레드중 한개라도 setDaemon으로 설정시 모든 스레드에 동일하게 setDaemon을 시켜줘야한다.
		 * */
		
//		while(true) {
//			
//		}
		
		
		
	}
}
