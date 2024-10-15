package com.kh.chap04.assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {

	public void fileSave() throws IOException {
		
		// 1. 기반스트림객체 먼저 생성
		
		//FileWriter fw = new FileWriter("c_buffer.txt");
		
		BufferedWriter bw = null;
		
		bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
		
		bw.write("안녕하세요..\n");
		bw.newLine(); // 개행 메서드
		bw.write("저리 가십쇼..");
		
		// bw.flush(); // 버퍼 저장공간을 비워주는 메소드
		// 버퍼저장공간에 데이터가 다 들어가지 않은 상태에서 메소드가 종료될경우 데이터 누락이 발생할 수 있으므로,
		// 버퍼공간을 비워줘야한다.
		bw.close();
	}
	
	public void fileRead() {
		
		/* 
		 * try ~ with ~ resource 구문
		 * 
		 * try (스트림객체생성; 스트림객체생성; 스트림객체생성;){
		 * 
		 * } catch(예외클래스명 변수명){
		 * 
		 * }
		 * 스트림 객체를 try(여기)에서 생성하면 스트림 객체 생성후 try블럭이 종료될때 객체가 자동으로
		 * 반납(close)된다. 
		 * */		
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));){
			
//			System.out.println( br.readLine()  );
//			System.out.println( br.readLine()  );
//			System.out.println( br.readLine()  );
//			System.out.println( br.readLine()  );
			
			String value = null;
			while( (value = br.readLine()) != null ) {
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
