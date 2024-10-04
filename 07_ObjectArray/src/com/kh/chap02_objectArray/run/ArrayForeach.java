package com.kh.chap02_objectArray.run;

import java.util.Scanner;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ArrayForeach {
	
	public static void main(String[] args) {
		
		int [] arr = {10,20,30};
		
		// 베이직 loop문
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 향상된 for문
		/* 
		 * 
		 * for each문
		 *  - 배열, 컬렉션과 사용됨
		 *  - 배열 또는 컬렉션의 0번인덱스부터 마지막 인덱스까지 순차적으로 접근하고자 할때 자주 사용된다.
		 *  
		 *  초기식 x 조건식 x 증감식 x
		 *  반복횟수? 배열이나 컬렉션의 크기만큼 반복
		 *  
		 *  for ( 각 인덱스에 담긴값을 저장할 변수   :   배열/컬렉션   ) {
		 *    반복하고자 하는 코드
		 *  }
		 * */
		for(int num : arr) {
			System.out.println(num);
		}
		
		Phone[] pArr = new Phone[3];
		
		pArr[0] = new Phone("아이폰","8","애플",450000);
		pArr[1] = new Phone("갤럭시 z플립","4","삼성",1300000);
		pArr[2] = new Phone("아이폰","16","애플",1700000);
		
		int sum = 0;
		for( Phone phone  :  pArr   ) {
			System.out.println(phone.information());
			sum += phone.getPrice();
		}
		
		System.out.println("총 합계 : "+sum);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n구매하고자 하는 폰 : ");
		String buy = sc.nextLine();
		
		// 핸드폰객체 배열에서 내가 구매하고자 하는 폰이 있다면 그 핸드폰의 정보를 출력
		// 향상된 반복문으로 코드 작성.
		for( Phone p : pArr) {
			if(buy.equals(p.getName())) {
				System.out.println(p.information());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
