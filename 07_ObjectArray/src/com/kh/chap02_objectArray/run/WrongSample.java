package com.kh.chap02_objectArray.run;

import com.kh.chap02_objectArray.model.vo.Phone;

public class WrongSample {
	
	public static void main(String[] args) {
		
		Phone[] arr = new Phone[3];
		for(int i =0; i<= arr.length; i++) {
			System.out.println(arr[i].getName());
		}
		/* 
		 * 문제점 1 : 부등호 -> 마지막 인덱스값이 2인데 i는 최대 3까지 증가.
		 *          부적절한 인덱스가 제시되게 된다.
		 * 해결방법 ? i < arr.length로 수정
		 * 
		 * 문제점 2 : arr배열에 각 인덱스에 값을 초기화 시키지 않아서 null값이 들어간 상태에서
		 *          getName()메서드를 호출하기 때문에 NullPointerException이 발생
		 * 해결방법 ? getName을 사용하지 않음. 각 배열에 값을 초기화 시켜준다.
		 * 
		 * */
	}

	
	
	
	
	
	
	
	
}

