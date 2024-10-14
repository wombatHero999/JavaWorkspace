package com.kh.chap01.file;

import java.io.File;
import java.io.IOException;

public class FileRun {
	
	public static void main(String[] args) {
		// java.io.File -> 로컬상의 파일의 개념을 추상화시킨 클래스. 입출력기능은 없고,
		//        파일의 정보, 이름, 속성 크기 등등을 얻어올 수 있음.
		//        파일의 삭제, 생성이 가능
		
		try {
			// 1. 경로지정을 하지 않은 상태로 파일생성.
			File file1 = new File("test.txt");
			file1.createNewFile();
			
			// 3. 폴더를 생성하고 그 안에 파일을 생성
			File folder = new File("C:/aaa/bbb/ccc/ddd");
			//folder.mkdir(); // 디렉토리 1개 생성
			folder.mkdirs(); // makedirectorys. 디렉토리 n개 생성
			
			// 2. 경로를 지정한 상태로 파일 생성
			File file2 = new File("C:/aaa/bbb/ccc/ddd/test.txt");
			file2.createNewFile();
			
			// 4. File에서 제공하는 메서드들.
			System.out.println(folder.exists()); // 폴더 및 디렉토리가 존재하는지 확인
			System.out.println(folder.isFile()); // 폴더이므로 false
			System.out.println(file2.isFile()); // 파일이므로 true
			
			System.out.println("파일명 : "+file2.getName());
			System.out.println("상위폴더명 : "+file2.getParent());
			System.out.println("파일 용량 : "+file2.length());
			System.out.println("파일 위치 : "+file2.getAbsolutePath());
			
			file2.delete();
			
			File folder2 = new File("C:/aaa/bbb/ccc/ddd");
			//특정 폴더(디렉토리)내부의 모든 파일을 배열로 얻어오고 싶은 경우
			File[] fArr = folder2.listFiles();
			for(File file  : fArr) {
				System.out.println("파일명 : "+file.getName());
				System.out.println("파일용량 : "+file.length());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}	
}
