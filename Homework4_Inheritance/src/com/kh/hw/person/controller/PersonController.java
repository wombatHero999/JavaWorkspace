package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.*;

public class PersonController {
	private Student[] s = new Student[3]; // [ null,null,null]
	                                      // [Student ,Student , null]
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int [] arr = new int[2];// [0, 0]
		
		for(Student student : s) {
			if(student != null) { // 학생 객체가 생성되었다면.
				arr[0]++;				
			}
		}
		
		for(Employee emp : e) {
			if(emp != null) {
				arr[1]++;
			}
		}
		return arr;
	}
	
	public void insertStudent(String name, int age , double height, double weight, int grade, String major) {
		Student std = new Student(name, age, height, weight, grade, major);
		
		// 0, 1, 2 
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				s[i] = std;
				break;
			}
		}
		
		//int studentCount = personCount()[0];
		//s[studentCount] = std;
	}
	
	public Student[] printStudent() {
		//학생 객체 배열의 주소를 반환하는	메소드
		return s;
	}
	
	public void insertEmployee(String name, int age , double height, double weight, int salary, String dept) {
		
	}
	
	public Employee[] printEmployee() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
