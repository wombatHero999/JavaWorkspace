package com.kh.chap04.assist.part01_buffered.run;

import java.io.IOException;

import com.kh.chap04.assist.part01_buffered.model.dao.BufferedDao;

public class BufferRun {
	public static void main(String[] args) {
		/* 
		 * 보조스트림 
		 *  기반 스트림들의 부족한 기능들을 확장시킬 수 있는 스트림.
		 *  단, 보조스트림은 외부매체와 직접 연결이 불가하기 때문에 단독으로는 사용이 불가능.
		 * 
		 * [표현법]
		 * 보조스트림 변수명 = new 보조스트림(new 보조스트림(new 보조스트림(기반스트림 객체))) // 데코레이터패턴
		 * 
		 * 속도 성능 향상 목적의 보조 스트림 : BufferedXXX
		 *  => 데이터 입출력시 버퍼라는 저장공간을 제공해서 데이터를 모아두었다가 한번에 입출력을 진행.
		 * 
		 * */
		BufferedDao bd = new BufferedDao();
		
//		try {
//			bd.fileSave();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		bd.fileRead();
	}
}








