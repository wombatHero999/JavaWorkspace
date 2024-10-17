package com.kh.chap02_set.part01_hashSet.model.vo;

import java.util.Objects;

public class Student implements Comparable<Student>{
	private String name;
	private int age;
	private int score;
	
	public Student() {
		
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // instanceOf
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(name, other.name) && score == other.score;
	}

	@Override
	public int compareTo(Student o) {
		int result = this.name.compareTo(o.name);
		
		if(result == 0) {
			result = this.age - o.age;
		}
		return result;
	}
	
	/* 
	 * 두 객체간의 필드값이 동일하다면 equals의 결과가 true
	 * 두 객체간의 필드값이 동일하다면 해당 객체의 hashCode도 동일해야 "동일객체"로 간주
	 * */
	
	// 필드값을 기반으로 hashCode를 반환하도록 재정의
//	public int hashCode() {
//		// 공유40100
//		// 공유40100
//		return (name+age+score).hashCode();
//	}
//	
//	public boolean equals(Object anObject) {
//		//형 변환 전 타입 검사
//		if(!(anObject instanceof Student)) {
//			return false;
//		}
//		
//		Student s = (Student) anObject;
//		
//		if(this.age != s.age) {
//			return false;
//		}
//		
//		if(!this.name.equals(s.name)) {
//			return false;
//		}
//		
//		if(this.score != s.score) {
//			return false;
//		}
//		
//		return true;
//	}
	
	
	
	
	
	
}
