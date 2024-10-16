package com.kh.chap01_list.part01_arrayList.model.compare;

import java.util.Comparator;
import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class MusicComparator implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		// o1과 o2비교 -> 오름차순
		// o2와 o1비교 -> 내림차순
		return o2.getTitle().compareTo(o1.getTitle()); 
	}
	
}

// 정렬기준 여러개 생성
class MusicComparator2 implements Comparator <Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return 0;
	}
	
}







