package com.kh.chap04_clone.part02_set.run;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;
import com.kh.chap04_clone.part02_set.model.clone.MyHashSet;

public class HashRun {
	public static void main(String[] args) {
		MyHashSet<Student> mhs = new MyHashSet<>();
		
		// 1) add
		mhs.add(new Student("홍길동", 25, 100));
		mhs.add(new Student("홍길동", 25, 100));
		mhs.add(new Student("김영희", 30, 100));
		mhs.add(new Student("고길동", 40, 50));
		
		// 2) remove
		mhs.remove(new Student("김영희", 30, 100));
		
		// 3) contains
		System.out.println(mhs.contains(new Student("김영희", 30, 100)));
		System.out.println(mhs.contains(new Student("홍길동", 25, 100)));
		
		// 4) size
		System.out.println(mhs.size());
		
		mhs.printAll();
	}
}
