package com.kh.chap04_data.run;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateRun {
	
	
	public static void main(String[] args) {
		DateRun dr = new DateRun();
		dr.test2();
	}
	
	/* 
	 * Calendar : 날짜와 시간에 관한 데이터를 쉽게 처리 가능한 "추상 클래스" 
	 * */
	public void test1() {
		// 현재시간, 날짜 정보를 조회
		Calendar cal1 = new GregorianCalendar();
		//getInstance() : 현재 컴퓨터시스템상의 지역정보를 바탕으로 해당지역의 시간정보를 가져옴(그레고리력)
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println(cal1);
		
		System.out.println(cal1.get(Calendar.YEAR));
		System.out.println(cal1.get(Calendar.MONTH) +1 );
		System.out.println(cal1.get(Calendar.DATE));
		
		System.out.println(cal1.get(Calendar.HOUR));
		System.out.println(cal1.get(Calendar.MINUTE));
		System.out.println(cal1.get(Calendar.SECOND));
		
		
	}
	
	// 특정일 특정시간을 기준으로 Calendar객체 생성
	public void test2() {
		Calendar cal1 = Calendar.getInstance();// 현재시간
		cal1.set(2025, 0,1,0,0,0); // 2025년 1월 1일
		
		System.out.println(cal1.get(Calendar.MONTH) + 1);
		
		// 2024년 9월 19일
		Calendar cal2 = new GregorianCalendar(2024, 8, 19);
		
		// 날짜 차이 계산하기
		Calendar now = Calendar.getInstance(); // 2024/10/10
		
		// 현재 시간을 밀리초단위로 변환.	
		// 1970년 1월 1일 부터 ~ 현재 시간까지의 밀리초를 반환
		// miills / 1s == 1000ms
		// day 1000(초) * 60(분) * 60(시) * 24(일)
		long num1 = now.getTimeInMillis(); 
		long num2 = cal1.getTimeInMillis(); 
		
		long diff = (num2 - num1) / 24 / 60 / 60 / 1000 ; // 남은 일수
		System.out.println("새해까지 D-"+diff+"일 남았습니다.");
	}
	
	
	
	
	
	
	
	
	
}
