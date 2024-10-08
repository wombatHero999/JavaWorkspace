package com.kh.chap01_beforeVsAfter.after.model.vo;

public class SmartPhone extends Product{

	private String agency;
	
	public SmartPhone() {
		
	}

	public SmartPhone(String brand, String pCode, String pName, int price , String agency) {
		super(brand, pCode, pName, price);
		this.agency = agency;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public String information() {
		return super.information()+", "+agency;
	}
	
	
}
