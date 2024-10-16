package com.kh.practice.list.music.model.vo;

public class Music implements Comparable<Music> {
	private String title;
	private String singer;

	public Music() {

	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	// 수정필요
	public int hashCode() {
		return 0;
	}
	// 수정필요	
	public boolean equals(Object obj) {
		return true;
	}
	
	public int compareTo(Music m) {
		return m.singer.compareTo(this.singer);
	}
	
}
