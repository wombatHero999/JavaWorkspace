package com.kh.chap01_constant.model.constant;

public class CarColor {
	private int color = 0;
	
	public static final CarColor BLACK = new CarColor(0);
	public static final CarColor RED   = new CarColor(1);
	public static final CarColor BLUE  = new CarColor(2);
//	public static final CarColor BLUE  = new CarColor(2);
//	public static final CarColor BLUE  = new CarColor(2);
//	public static final CarColor BLUE  = new CarColor(2);
//	public static final CarColor BLUE  = new CarColor(2);
	
	public CarColor(int color) {
		this.color = color;
	}
}
