package com.kh.chap02_TCP.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientRun {
	
	public static void main(String[] args) {
		new ClientRun().clientStart();
	}
	
	public void clientStart() {
		// 클라이언트용 TCP소켓 프로그래밍 순서..
		// 1) 서버와 연결요청 -> 서버의 IP주소와 서버소켓의 포트번호가 필요.
		
		// 서버의 ip확인 : 192.168.30.2
		String serverIp = "192.168.30.2"; // InetAddress.getLocalHost();
		int port = 10000; // 서버에서 지정한 포트번호 확인.
		Socket socket = null;
		
		try {
			// ### 서버에 연결요청을 보내는 구문. 존재하지 않는 서버면 null값이 반환.
			socket = new Socket(serverIp, port); // 연결성공시 서버의 accept()이후의 코드가 활성화.
			
			if(socket != null) { // 소켓이 연결되었다면
				// 2, 3) 서버와의 입출력 스트림 생성 , 보조스트림을 통해 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
				
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); 
				Scanner sc = new Scanner(System.in);
				
				// 4) 스트림을 통해 읽고쓰기
				while(true) {
					System.out.print("서버에 보낼 내용 : ");
					String str = sc.nextLine();
					
					pw.println(str);
					if(str.equals("exit")) {
						System.out.println("접속종료 !! ");
						break;
					}
					
					String message = br.readLine();
					System.out.println("서버로부터 받은 메세지 : "+message);
				}
				// 5) 통신종료
				pw.close();
				br.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}
