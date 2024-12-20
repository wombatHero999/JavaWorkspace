package com.kh.practice.network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		//키보드로  호스트명  또는  도메인명을  입력받는다.   
		//입력받은  호스트명을  가지고,  모든  ip  주소를  조회해서  출력한다.     
		//출력시  호스트명과  ip  주소를  분리해서, ip  주소만  출력되게  한다. 
		//조회한  ip  갯수가  1개  이상이면  루프문으로  모두  출력하고,   
		//예외처리는  try~catch로  직접  처리한다. 
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("호스트명 : ");
			String hostName = sc.nextLine();
			
			InetAddress[] ips = InetAddress.getAllByName(hostName);
			System.out.println(hostName+"는 "+ips.length+"개의 IP주소를 가지고 있습니다.");
			
			for(int i=0; i<ips.length; i++) {
				System.out.println((i+1)+"번 IP = " + ips[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
