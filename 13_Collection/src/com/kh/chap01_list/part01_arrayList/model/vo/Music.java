package com.kh.chap01_list.part01_arrayList.model.vo;

public class Music implements Comparable<Music> {
	
	private String title;
	private String artist;
	
	public Music() {
		
	}

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}
	
	/*
	 *  두 객체간의 "필드값"이 동일하다면 true가 나오게끔 메소드 오버라이딩
	 *  
	 *  */
	
	@Override
	public boolean equals(Object o) {
		// 다운캐스팅 전 타입검사
		if(!(o instanceof Music)) {
			return false;
		}
		Music m = (Music) o;
		
		if(!this.title.equals(m.title)) {
			return false;
		}
		
		if(!this.artist.equals(m.artist)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Music o) {
		// 현재객체(this)와 매개변수로 들어온 객체(o)간의 비교 수행
		// this compareTo other -> 오름차순
		// other compareTo this -> 내림차순
		return this.title.compareTo(o.title);
	}

	
}
