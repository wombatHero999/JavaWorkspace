package com.kh.chap04.assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04.assist.part02_object.model.vo.Phone;

public class ObjectDao {
	
	
	public void fileSave() {
		Phone ph = new Phone("아이폰", 1700000, "애플");
		// 객체단위 입출력에 필요한 보조스트림
		// ObjectOutputStream
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phone.txt"))){
			oos.writeObject(ph);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void fileRead() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"));){
			
			Object o = ois.readObject();
			System.out.println(((Phone) o).getName());
			System.out.println(o);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
