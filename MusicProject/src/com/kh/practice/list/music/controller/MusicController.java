package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTtitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
//		try {
//			list.add(music);
//			
//			return 1;
//		}catch(Exception e) {
//			return 0;				
//		}
		if(list.add(music)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	public List printAll() {
		//System.out.println(list);
		return list;
	}
	
	public Music searchMusic(String title) {
		// 곡 명으로 Music객체 검색, 객체가 있으면 객체 정보 리턴, 없으면 null 리
		// List -> Music객체가 묶음으로 들어가 있음 -> 제목(title), 가수(singger)가 들어가 있음
		for(Music m : list) {
			String searchTitle = m.getTitle();
			if(title.equals(searchTitle)) {
				return m;
			}
		}
		
		return null;
	}
	
	public Music removeMusic(String title) {
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 삭제, 없으면 null 리턴
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				//Music m = list.get(i);
				return list.remove(i);
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 수정, 없으면 null 리턴
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				//Music m = list.get(i);
				return list.set(i, music);
				//return m;
			}
		}
		
		return null;
	}
	
	public int ascTitle() {
		// 리스트 곡 명 오름차순 정렬, 제목이 같으면 가수 명으로 오름차순 정렬, 1 리턴
		list.sort( new AscTtitle() );
		return 1;
	}
	
	public int descSinger() {
		// 리스트 가수 명 내림차순 정렬, 1 리턴
		Collections.sort(list);
		return 1;
	}
	
}
