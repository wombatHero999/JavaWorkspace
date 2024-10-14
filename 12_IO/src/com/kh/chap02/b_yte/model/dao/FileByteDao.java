package com.kh.chap02.b_yte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDao {
	
	/* 
	 * 자바프로그램상의 데이터를 외부매체로 "출력"하거나 입력장치로부터 "입력"받는 과정을 진행하고자 한다면
	 * 반드시 프로그램과 그 외부매체와의 "통로"를 만들어야 한다.
	 * 
	 * 이 통로는 입력장치가 무었이든 일관성있게 데이터를 입력받을 수 있도록 설계하였고, 이 통로를 Stream이라고
	 * 부름.
	 * 
	 * 스트림의 특징 
	 *  - 단반향 : 입력이면 입력, 출력이면 출력
	 *           입출력용 스트림이 따로 존재.
	 *  - 선입선출구조 : 먼저 전달한 값이 먼저 나오게 됨(FIFO)
	 *  - 시간지연문제가 발생할 수 있다
	 *    => 데이터의 전송속도보다 , 수신속도가 빠르거나 느릴수 있다.
	 *    => 네트워크지연, 버퍼링, 코딩적인 문제로 시간이 지연될수 있다.
	 *    => 이러한 문제들은 네트워크 최적화, 코딩 최적화 등으로 해결할 수 있다.
	 * 
	 *  스트림의 구분 
	 *  - 통로(스트림)의 사이즈
	 *     바이트 스트림(InputStream/OutputStream)
	 *      - InputStream/OutputStream이 바이트 스트림의 최상위 추상 클래스.
	 *      - 각 입력매체에 맞는 입/출력 기능을 하위클래스에서 직접 구현하여서 입/출력장치가 무엇이든 일관성
	 *        있게 작동할 수 있게 하였다.
	 *      ex) File을 기준으로 입/출력시 FileInput/OutputStream을 사용하며,
	 *          메모리데이터 입출력 구현시 ByteArrayInput/OutputStream을 사용한다.
	 *          이때 동일한 read(), write()메소드를 사용하면 된다.
   	 *      - 1byte 짜리 데이터가 이동할 수 있는 사이즈를 가짐. (동영상,음악파일등을 읽고 쓸때 사용) 
	 *     문자 스트림(Reader/Writer)
	 *      - 2byte 짜리 데이터가 이동할 수 있는 사이즈를 가짐. (byte로 표현 불가능한 문자를 읽고 쓸때)
	 * 
	 *  - 외부매체와의 직접적인 연결 여부 :
	 *     기반 스트림 : 외부매체와 직접 연결되는 통로를 수립.
	 *     보조 스트림 : 기반스트림만으로 부족한 성능을 향상시켜주는 용도의 스트림(외부매체와 직접적으로 연결x)
	 *                -> 단독 사용 불가능. 반드시 외부매체와 연결을 해주는 기반스트림과 함께 사용된다.
	 * */
	
	
	// dao(Data Access Object) : 데이터가 보관되어있는 공간과 직접 접근해서 데이터를 입출력 하는 클래스.
	public void fileSave() {
		// 자바 프로그램에서 -> 외부매체(파일)로 데이터를 내보내기(출력)
		
		// "파일"과 출력을할 때 사용하는 스트림
		FileOutputStream fout = null; // null초기화
		
		try {
			/* 
			 * FileOutputStream객체 생성 => 매개변수로 전달한 이름의 파일과 "직접 연결되는 통로"를 만들겠다.
			 * 단, 연결하고자 하는 파일이 존재하지 않는 경우 해당 파일이 "생성"되면서 통로를 만든다.
			 *     존재하는 경우 그냥 통로를 만든다.(true를 함께 제시)
			 * */			
			//fout = new FileOutputStream("a_byte.txt"); // 기본객체생성 -> 덮어쓰기
			fout = new FileOutputStream("a_byte.txt", true);// 두번째 매개변수로 true제시시 => 이어쓰기
			
			// 연결통로를 통해 파일로 데이터 출력시 write()메소드 사용
			// 1byte의 데이터만 주고 받을 수 있다.
			// 1byte의 범위 -128 ~ 127까지만 가능
			fout.write(97); // 'a'
			fout.write('b'); // 'b'			
			//fout.write('민'); // 문자열 깨짐. 1byte의 범위를 초과했기 때문에
			
			byte[] bArr = {99,100,101};
			fout.write(bArr);
			
			fout.write(bArr, 1, 2);// 1번 인덱스 부터 2개 
			//abcdede
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 다 사용한 스트림은 반드시 자원을 반납해줘야함.
			// 어떤 예외가 발생하든 실행될 수 있도록 finally블럭 안에 작성.
			try {
				fout.close();// 사용한 자원을 반납하는 메서드
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 자바프로그램 <-- 외부매체(파일)
	// 파일로부터 데이터를 가져오는 메서드
	public void fileRead() {
		
		
		// FileInputStream : 파일로부터 데이터를 1바이트단위로 입력받는 스트림
		FileInputStream fis = null;
		
		try {
			// 존재하지 않는 파일이 제시될 경우 에러발생
			fis = new FileInputStream("a_byte.txt");
			
			// 통로로부터 read()메서드를 통해 1byte단위로 데이터 입력받기
//			int value = 0;
//			while(true) {				
//				value = fis.read();
//				if(value == -1) break;
//				System.out.println(value);
//			}
			
			int value = 0;
			while( (  value = fis.read()  ) != -1 ) {				
				System.out.println(value);
			}
//			int value = fis.read();// 더 뽑을 데이터가 없는 순간 -1이 반환
//			System.out.println(value);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
