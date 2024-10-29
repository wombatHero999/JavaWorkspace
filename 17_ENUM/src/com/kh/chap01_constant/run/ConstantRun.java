package com.kh.chap01_constant.run;

import java.util.Calendar;

import com.kh.chap01_constant.model.constant.CarColor;
import com.kh.chap01_constant.model.vo.Car;

public class ConstantRun {
	/*
	 * 상수?
	 *  - 값이 바뀌지 않는 변수.
	 *  - 저장하고 있는 값에 대한 전달력을 높이기 위해 사용한다.
	 *  - static final 키워드를 붙여서 프로그램 시작과 동시에 static의 상수메모리에 올려두고 공유하면서 
	 *   사용하였다.
	 *  - 상수명은 항상 대문자로 작성한다.
	 * 
	 * 상수의 단점
	 *  - 비슷한 의미를 가진 값들 여러개를 저장하고자 할때 하나의 상수에 담을수 없다.
	 *  - 담긴 값에 대한 검증기능이 없다.
	 *  */
	
	// 자동차의 색깔을 관리할 상수값
	
	
	// 옷의 색깔도 추가로 관리해야 한다면? 변수명 중복으로, 다른 변수명을 써야한다.
	public static final int ITEM_BLACK = 5;
	public static final int ITEM_RED = 10;
	
	public static void main(String[] args) {
		
		Car tesla = new Car();
		tesla.setName("테슬라");
		//tesla.setColor(CarColor.BLACK); // 0 == 검은색, 1== 빨간, 2== 파랑
		tesla.setColor(Calendar.YEAR); // 0 == 검은색, 1== 빨간, 2== 파랑
		// 값에 대한 검증기능이 부재.
		// 제대로 쓴다면 상관 없지만, 복잡한 프로그래밍 도중 이상한 상수값을 사용하는 경우 실제 동작시 문제가 생길
		// 수도 있다. 
		
		// 위 검증기능을 추가하기 위해 상수값으로 "객체"를 이용하기 시작.(Enum 등장 전)
		tesla.setCarColor(CarColor.BLACK);
		// setCarColor에는 오직 CarColor에만 존재하는 상수값만 대입이 가능하므로, 값에 대한 검증기능이 생겼다.
	}
	
	
}


