package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.*;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone [] arr = new Phone[2];
		arr[0] = new GalaxyNote9();
		arr[1] = new V40();
		
		int index = 0;
		for(Phone p : arr) {
			if( p instanceof GalaxyNote9 ) {
				result[index] = ((GalaxyNote9)p).printInformation();				
			} else if (p instanceof V40) {
				result[index] = ((V40) p).printInformation();				
			}
			index++;
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
