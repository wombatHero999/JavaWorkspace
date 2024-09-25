package com.kh.chap02.loop;

public class B_While {
	/*
	 * while문
	 * [표현법]
	 * [초기식]
	 * while(조건식){ // 조건식의 결과가 true인경우 내부코드 반복 실행.
	 * 	 반복적으로 실행할 내용.
	 *   [증감식]
	 * }
	 *  */
	
	public void method1() {
		
		for(int i =0; i< 5; i++) {
			System.out.println("안녕하쇼");
		}
		
		int j = 0;
		while(j < 5) {
			System.out.println("잘가세요");
			j++;
		}
	}
	
	public void method2() {
		//1 2 3 4 5
		for(int i = 1; i<=5; i++) {
			System.out.print(i+" ");
		}
		
		int j = 1;
		while(j <=5) {
			System.out.print(j++ +" ");
			//j++;
		}
	}
	
	public void method3() {
		// 1 3 5 7 9
		// while문으로 
		// (for문을 가져온후 변경)
//		for(int i =1; i<10; i++) {
//			if(i % 2 == 1) {
//				System.out.print(i+" ");
//			}			
//		}
		int i = 1;
		while(i < 10) {
			if(i % 2 == 1) {
				System.out.print(i+" ");
			}
			i++;
		}
		
//		int i = -1;
//		while(i < 10) {
//			System.out.print((i+=2)+" ");
//		}
		
		
		/*
		 * do-while
		 * [표현법]
		 * do { // 별도의 조건검사 없이 무조건 1번 실행.(즉, 조건의 결과가 false더라도 반드시 한번수행)
		 *  // 반복실행할 코드
		 * } while(조건식);
		 *  */
	}
	
	public void method4() {
		int num = 1;
		
		do {
			System.out.println("안녕하쇼");
		} while(num == -1);
	}	
	
	public void method5() {
		// 1 2 3 4 5
		int i = 1;
		do {
			System.out.print(i+" ");
			i++;
		}while(i <= 5);
	}
	
	
}
