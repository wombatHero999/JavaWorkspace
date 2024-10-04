package com.kh.chap02_objectArray.run;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ObjectArrayRun {
	
	public static void main(String[] args) {
		
		Phone[] arr = new Phone[3];// [0], [1], [2]
		
		System.out.println(arr);//배열주소값
		System.out.println(arr.length); // 
		System.out.println(arr[0]); //null
		
		arr[0] = new Phone("아이폰","8","애플",450000);
		arr[1] = new Phone("갤럭시 z플립","4","삼성",1300000);
		arr[2] = new Phone("아이폰","16","애플",1700000);
		
		int sum = 0;
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i].information());
			sum += arr[i].getPrice();
		}
		System.out.println("총 가격 : "+sum+"원");
		System.out.println("평균가 : "+ ( sum / arr.length ) +"원");
		
	}
	
	
	
	
	
	
	
	
	
}
