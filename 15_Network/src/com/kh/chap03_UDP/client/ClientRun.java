package com.kh.chap03_UDP.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientRun {
	public static void main(String[] args) {
		
		try {
			//서버의 ip주소와 포트번호 확인.
			InetAddress serverAddress = InetAddress.getByName("localhost");
			int serverPort = 10001;
			
			DatagramSocket socket = new DatagramSocket();// 랜덤포트사용.
			String message = "클라이언트에서 데이터 요청보냄";
			byte[] sendData = message.getBytes();
			
			DatagramPacket sendPacket = 
					new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
			
			// 서버로 데이터 전송(자동으로 요청을보내는 클라이언트의 ip주소와, 포트번호가 함께 전달된다)
			socket.send(sendPacket);
			
			DatagramPacket receivePacket = 
					new DatagramPacket(new byte[1024], 1024);
			// 서버로부터 데이터 수신 대기
			socket.receive(receivePacket); // 패킷 재사용
			
			// 전달받은 데이터 처리
			String receiveData = new String( receivePacket.getData() , 0, receivePacket.getLength());
			System.out.println("수신한 데이터 : "+receiveData);
			
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
