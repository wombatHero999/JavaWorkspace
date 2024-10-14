package com.kh.chap03.c_har.run;

import com.kh.chap03.c_har.model.dao.FileCharDao;

public class CharRun {
	public static void main(String[] args) {
		FileCharDao fc = new FileCharDao();
		//fc.fileSave();
		fc.fileRead();
	}
}
