package com.kh.chap03.branch;

public class B_Continue {
	/* 
	 * continue : 반복문 안에서 사용하는 구문, continue를 만나게되면 그 뒤에 어떤 구문이 있든
	 *            "실행하지 않고" 가장 가까운 반복문으로 돌아간다.
	 * */
	
	public static void main(String[] args) {
		B_Continue bc = new B_Continue();
		bc.method2();
	}
	
	public void method1() {
		for(int i = 1; i<10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.print(i+" ");
		}
	}
	
	// 1~100까지의 총 합.
	// 단, 6의 배수는 제외하고 더해보기.
	public void method2() {
		
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			//sum += i;
			if(i % 6 != 0) {
				continue;
			}
			sum += i;			
		}
		
		System.out.println("총 합계 : " + sum);
	}
	
	
	
	
	
	
	
}
