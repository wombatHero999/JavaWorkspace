package com.kh.chap02.b_yte.run;

import com.kh.chap02.b_yte.model.dao.FileByteDao;

public class ByteRun {
	public static void main(String[] args) {
		FileByteDao fbd = new FileByteDao();
		
		//fbd.fileSave();		
		fbd.fileRead();
	}
}
