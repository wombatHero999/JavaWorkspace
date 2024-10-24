package com.kh.chap02_TCP.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerRun {
	/*
	 *  TCP(Transmission Control Protocol)
	 *   - 연결지향 프로토콜. 서버와 클라이언트간에 "연결"이 되어 있어야 데이터를 교환함.
	 *   - 신뢰성 있고 안전한 데이터 전달이 가능.
	 *   - 클라이언트와 서버간에 소켓을 통해 연결 한다. 연결된 소켓을통해 데이터를 주고 받는다.
	 *   - 채팅,메일전송,웹브라우징등 다양한 영역에서 소켓, TCP프로코톨을 사용한다.
	 *  
	 *  소켓 ?
	 *   - 클라이언트와 서버간에 "통신"에 사용되는 객체
	 *   - 소켓이 소유한 IP번호와 포트번호(프로세스)를 통해 , 어떤 호스트의 어떤 포트번호인지 식별한다.
	 *   - Input/Output이 둘다 존재.
	 *  
	 *  ServerSocket
	 *   - 서버에서 생성하는 소켓으로 클라이언트에서 서버로 연결요청이 들어오기까지 대기한다.
	 *   - 클라이언트에서 연결요청이 들어오면 소켓객체를 생성하여 클라이언트에게 전달해준다. 이렇게 생성된
	 *     소켓객체를 통해 서버-클라이언트간에 데이터 송수신이 가능.
	 *   
	 *  (Client)Socket
	 *   - 클라이언트에서 서버에 요청하거나, 서버의 데이터를 응답받을때 사용하는 클래스
	 *   - 서버의 ip주소와 포트번호를 제시하여 서버에 "연결요청"을 보내면, 서버가 소켓객체를 생성하여 전달.
	 *  */
	public static void main(String[] args) {
		new ServerRun().serverStart();
	}
	
	public void serverStart() {
		// 서버용 TCP소켓 프로그맹 순서
		// 1.서버의 포트번호 지정
		// 0~1023번 포트는 시스템 포트 번호
		// 1024~65535의 포트번호를 사용 하는것 추천
		int port = 10000;
		int clientCount = 0; // 접속한 클라이언트의 수를 세기위한 변수.
		
		// 2-1. 서버용 소켓객체 생성(변수선언)
		ServerSocket server = null;
		
		// 2-2) 서버 소캣객체 생성(객체생성 후 대입)
		try {
			server = new ServerSocket(port);// 10000번 포트 대입
			
			System.out.println("### 서버 가동중 ###");
			while(true) {
				// 3) 클라이언트의 접속 요청 대기 server.accept()
				// 4) 접속요청이 오면 요청 수락 후 클라이언트와의 통신을 위한 소켓 객체 생성.
				//    생성된 소켓은 클라이언트에게도 전달후 , Server도 해당 소켓을 저장.
				System.out.println("### 클라이언트의 요청 대기중 ###");
				Socket clientSocket = server.accept();// 대기
				System.out.println(++clientCount+"번째 클라이언트 연결 됨...");
				
				// 5, 6) 연결된 클라이언트와 입출력 스트림 생성, 보조스트림으로 성능 개선
				OutputStream os = clientSocket.getOutputStream(); // 클라이언트로 값을 출력
				InputStream is = clientSocket.getInputStream(); // 클라이언트로부터 값을 입력
				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				// 값을 한줄씩 출력하는 스트림
				PrintWriter pw = new PrintWriter(os,true);
				Scanner sc = new Scanner(System.in);
				
				// 7) 스트림을 통해 읽고 쓰기
				while(true) {
					// 클라이언트가 전달한 메세지
					String message = br.readLine();
					
					if(message == null || message.equals("exit")) {
						System.out.println("접속 종료");
						break;
					}
					
					System.out.println( clientSocket.getInetAddress().getHostAddress()+"가 보낸 메세지 : " +message  );
					//pw.println("메세지 받기 성공... 다음 메세지를 입력해주세요...");
					pw.println(sc.nextLine());
				}
				//8) 사용한 자원 반납
				br.close();
				pw.close();
				clientSocket.close();				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}













