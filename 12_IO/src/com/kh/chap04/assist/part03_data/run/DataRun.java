package com.kh.chap04.assist.part03_data.run;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataRun {
	
	public static void main(String[] args) {
		DataRun dr = new DataRun();
		dr.fileSave();
		dr.fileRead();
	}
	
	public void fileSave() {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("sample.txt"));) {
			
			dos.writeBoolean(true);
			dos.writeInt(99999);
			dos.writeDouble(3.15);
			dos.writeChar('민');
			dos.writeUTF("안녕하시오");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileRead() {
		File f = new File("sample.txt");
		
		try (DataInputStream dis = new DataInputStream(new FileInputStream(f));){
			
			// 작성된 자료형 순서대로 읽어와야함.
			System.out.println(dis.readBoolean());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
