package com.kh.chap03_UDP.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerRun {
	
	/* 
	 * UDP(User Datagram Protocol) 
	 *  - 비연결지향형 프로토콜로, 클라이언트가 데이터를 잘 전달받았는지 보다, 데이터를 빠르게 전송하는데
	 *    초첨을 맞춘 프로토콜. 전달받은쪽에서 데이터가 제대로 전달되었는지 확인하거나 수신하지 않기때문에 
	 *    데이터 손실이 발생할 수 있다.
	 *  
	 *  - 번거로운 확인절차를 모두 날려버림으로써 빠른 데이터전송이 가능하다.
	 *    실시간 스트리밍, 온라인게임, 유투브 등에서 사용하는 프로토콜.
	 *  
	 * UDP의 특징
	 *  - 데이터그램이라는 단위로 데이터를 전송한다.
	 *  - 클라이언트의 요청을 받아주는 "서버"소켓이 존재하지 않음.
	 *  - 클라이언트와 서버 각자 소켓을 생성한 후 , IP주소와 PORT를 통해 특정 프로세스로 데이터를 송,수신함.
	 *    연결된 소켓이 동작중이던 아니던 그저 데이터를 전송한다.
	 *  - 이때 전송하고자 하는 데이터는 DatagramPacket에 담아서 전달
	 *  
	 *  
	 * */	
	public static void main(String[] args) {
		
		// 1. 서버의 포트 번호 설정
		int port = 10001;
		
		// 2. UDP소켓 생성
		try {
			DatagramSocket socket = new DatagramSocket(port);
			
			System.out.println("서버 가동중.. 클라이언트가 데이터를 전달하기까지 대기합니다...");
			
			// DatagramPacket 어떤 ip주소에서 전송된 데이터인지 확인이 가능.
			byte[] receiveData = new byte[1024]; // 클라이언트가 전달한 데이터를 저장할 저장공간
			DatagramPacket clientPacket = new DatagramPacket(receiveData, 1024);
			
			socket.receive(clientPacket); // 현재 소켓으로 전송된 데이터를 clientPacket으로 받겠다.
			
			// 클라이언트의 ip주소 및 포트번호 확인.
			InetAddress clientIp = clientPacket.getAddress();
			int clientPort = clientPacket.getPort();
			System.out.println(clientIp.toString() + clientPort);
			
			String str = "서버에서 전송하는 데이터.. 잘받으십쇼...";
			
			// 전달할 데이터 포장
			byte[] data = str.getBytes();
			// 데이터그램 패킷 생성(데이터, 데이터의길이, 클라이언트의 ip, 클라이언트의 port)
			DatagramPacket packet = new DatagramPacket(data, data.length, clientIp, clientPort);
			
			socket.send(packet); // 데이터 전송.
			System.out.println("데이터 전송 완료.");
			
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
