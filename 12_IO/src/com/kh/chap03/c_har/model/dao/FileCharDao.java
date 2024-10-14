package com.kh.chap03.c_har.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
	
	public void fileSave() {
		
		FileWriter fw = null;
		
		try {
			File f = new File("b_char.txt");
			fw = new FileWriter(f);
			
			fw.write("와 ! io최고 \n");
			fw.write(97);
			fw.write('A');
			
			char [] cArr = {'k','i','w','i'};
			fw.write(cArr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("b_char.txt");
			
			int value = 0;
			while( (value = fr.read()) != -1) {
				System.out.print( (char) value );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
}
