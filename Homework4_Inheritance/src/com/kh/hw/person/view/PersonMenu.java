package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {

	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		while(true) {
			int[] arr = pc.personCount();// 0 -> 학생수, 1-> 사원수
			
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+arr[0]+"명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+arr[1]+"명입니다.");
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴번호 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 : studentMenu(); break;
			case 2 : employeeMenu(); break;
			case 9 : System.out.println("시스템 종료"); return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}

	public void studentMenu() {
		while(true) {
			int studentCount = pc.personCount()[0];
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			
			if(studentCount == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}
			System.out.print("메뉴 번호 :");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				if(studentCount == 3) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
					continue;
				}
				insertStudent(); 
				break;
			case 2: printStudent(); break;
			case 9: System.out.println("메인으로"); return;
			default: System.out.println("다시 입력해주세요.");
			}
		}
			
	}

	public void employeeMenu() {

	}

	public void insertStudent() {
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.next();
			
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			
			System.out.print("학생 몸무게 : ");
			double weitht = sc.nextDouble();
			
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			
			System.out.print("학생 전공 : ");
			String major = sc.next();
			
			pc.insertStudent(name, age, height, weitht, grade, major);
			
			int studentCount = pc.personCount()[0];
			
			if(studentCount != 3) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 :");
				char ch = sc.next().charAt(0);
				
				if(ch == 'N' || ch == 'n') {
					return;
				}
				//continue;
			}else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
		}
	}

	public void printStudent() {
		// pc의 printStudent() 메소드의 반환 값을 이용하여 학생 객체 배열에 저장된
		// 모든 데이터 출력
		Student[] s = pc.printStudent();
		for(Student std : s) {
			if(std != null) {
				System.out.println(std);
			}
		}
	}

	public void insertEmployee() {

	}

	public void printEmployee() {

	}
}
