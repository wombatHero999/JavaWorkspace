package com.kh.chap02_absAndInter.part02_family.model.vo;

public class Mother extends Person implements Basic {

	public Mother(String name, double weight, int health) {
		super(name, weight, health);
	}

	@Override
	public void eat() {
		// 엄마가 밥을 먹으면?
		// 몸무게가 기존의 몸무게에서 10 증가
		setWeight(getWeight() + 10);
		
		// 건강도는 기존의 건강도에서 10 감소
		setHealth(getHealth() - 10);
	}

	@Override
	public void sleep() {
		setHealth(getHealth() + 10);
	}

	
	
	
	
	
	
}
