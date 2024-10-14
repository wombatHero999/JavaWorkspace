package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {

	public int countAlpha(String str) throws CharCheckException {
		// 1. 매개변수로 들어온 값에 있는 영문자를 세어 반환
		// 2. 문자열에 공백이 있다면 CharCheckException발생, 에러 메시지는 출력 값 참고
		
		char [] arr = str.toUpperCase().toCharArray();// Exception -> E x c e p t
		
//		if(str.split(" ").length > 1) {
//			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
//		}
		
		int count = 0;
		for(char ch : arr) {
			// 영문자인지 아닌지 검사
			if(ch >= 'A' && ch <= 'Z') {
				//숫자세기
				count++;
			}
			if(ch == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
			
		}
		
		return count;
		
	}
}
