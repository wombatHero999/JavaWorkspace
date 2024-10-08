package com.kh.chap02_absAndInter.part01_basic.model.vo;

public class Football extends Sports{

	@Override
	public void rule() {
		System.out.println("발로 공을 차서 골대에 넣는다.");
	}
}
