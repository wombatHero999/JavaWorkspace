package com.kh.chap01_URL.part01_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class NetworkTest {
	
	
	/** 
	 * InetAddress?
	 * IP주소에 대한 정보를 가진 클래스
	 * 
	 * - ip : 10.10.10.10 4바이트로 이루어진 실제 주소
	 * - hostname : www.naver.com / google.com과 같은 도메인명
	 * - InetAddress의 모든 메소드는 static메소드
	 * */
	public void test1() {
		try {
			InetAddress google = InetAddress.getByName("www.google.com");
			System.out.println(google); // www.google.com/142.250.197.100
			
			InetAddress[] googles= InetAddress.getAllByName("www.google.com");
			
			for(InetAddress i : googles) {
				System.out.println(i.getHostAddress());
			}
			// 내 컴퓨터의 ip주소 얻어오기
			// localhost(내 ip주소) == 127.0.0.1
			// 192.168.30.2
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * URL : 인터넷에 존재하는 서버들의 자원(웹페이지)에 접근할 수 있는 주소를 다루는 클래스.
	 *       실제 URL자원에 대한 객체를 생성하여 자원에 연결하거나, 데이터를 읽어올 수 있다.
	 *       
	 * File : 로컬환경상의 자원에 접근할때 사용하는 클래스.
	 * URL  : 원격환경상의 자원에 접근할때 사용하는 클래스. 
	 * 
	 * URL구조 : protocol + hostname + port + 자원경로(path)
	 *  https://shopping.naver.com:443/home
	 *  
	 *  protocol : 통신규약 http, https, ftp, stmp, file 등... 다양한 프로토콜 제시가 가능.
	 *   프로토콜 ? 네트워크환경에서 서버와 클라이언트간에 데이터의 전송,수신을 어떤식으로 할지를 정의한 규칙. 
	 *  hostname ? 도메인이름
	 *  port ? 서비스번호. 컴퓨터내에 특정 프로그램을 가리키는 논리적인 번호로, 하나의 서버로 포트번호 별로 여러
	 *          개의 다른 프로그램을 제공해 줄 수 있다.
	 *          각 프로토콜은 기본포트를 가지고 있으며, 기본포트에 존재하는 서비스는 포트번호 생략이 가능하다.
	 *          https-443, http-80, ftp-20....
	 *  자원경로 ? 도메인상에서 서버에 존재하는 자원의 경로
	 **/
	public void test2() {
		try {
			URL url = new URL("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%9F%AC%EC%8B%9C%EC%95%84+%EB%B6%81%ED%95%9C%EA%B5%B0");
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort() != -1 ? url.getPort() : url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
	}
	
	/* 
	 * URLConnection : 원격 서버와 통신하여 웹서버상의 자원을 입력할 수 있는 "스트림"을 가진 클래스
	 *                 url로 연결할 자원(웹페이지)을 기술하고, URLConnection을 통해 자원 입출력.
	 * */
	public void test3() {
		String address ="https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EC%9D%B4%EC%8A%A4%EB%9D%BC%EC%97%98+%ED%95%98%EB%A7%88%EC%8A%A4&oquery=%EB%9F%AC%EC%8B%9C%EC%95%84+%EB%B6%81%ED%95%9C%EA%B5%B0&tqi=ixmr8lqo1awss4QGowGssssssbC-384893";
		BufferedReader br = null; // 웹페이지의 정보를 읽어들이기
		BufferedWriter bw = null; // 읽어들인 정보를 html파일로 저장시키는 역할
		
		try {
			URL url = new URL(address);
			// 연결된 url과 입력할 수 있는 스트림을 가진 클래스.
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			bw = new BufferedWriter(new FileWriter("ㅋㅋㅋ.txt"));
			
			String data = "";
			while( (data = br.readLine()) != null) {
				bw.write(data);
				bw.newLine();
			}
			
			System.out.println("!!! 검색 완료 !!!");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}
