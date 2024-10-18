package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m ) {
		
		boolean result = map.containsKey(id);
		
		if(result) {
			// 이미 사용중인 ID
			return false;
		}
		
		map.put(id, m);
		return true;
	}
	
	public String logIn(String id, String password) {
		
		boolean result = map.containsKey(id);
		if(result) {
			// 아이디가 존재한다면 
			Member m = map.get(id);
			String realPw = m.getPassword();
			
			if(realPw.equals(password)) {
				return m.getName();
			}
		}
		return null;
	}
	
	public boolean changePassword(String id ,String oldPw, String newPw ) {
		String result = logIn(id,oldPw);
		if(result == null) {
			return false;
		}
		Member m = map.get(id);
		m.setPassword(newPw);
		
		return true;
	}
	
	public void changeName(String id, String newName) {
		map.get(id).setName(newName);
	}
	
	public TreeMap<String, String> sameName(String name) {
		Set<String> ids = map.keySet();
		TreeMap<String, String> tm = new TreeMap<>();
		
		for(String id : ids) {
			String currentName = map.get(id).getName();
			if(currentName.equals(name)) {
				tm.put(id, name);
			}
		}
		return tm;
	}
	
	
}
