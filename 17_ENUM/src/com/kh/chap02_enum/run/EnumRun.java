package com.kh.chap02_enum.run;

import com.kh.chap02_enum.model.constant.CarColor;

public class EnumRun {
	public static void main(String[] args) {
		System.out.println(CarColor.BLACK);
		System.out.println(CarColor.BLACK.getColor());
		System.out.println(CarColor.BLACK.getLowerColor());
		System.out.println(CarColor.valueOf(0));
	}
}
