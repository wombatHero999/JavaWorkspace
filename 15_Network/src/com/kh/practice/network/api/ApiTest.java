package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTest {
	public static void main(String[] args) {
	  //0)  홈페이지에서  요청주소,  요청변수  확인후  필수값에  해당하는  변수  초기화 
      //    serviceKey를  제외한  필수데이터는  샘플데이터를  추가한다 
      // 1) URL  객체  생성 
      // 2)URLConnection  객체  생성 
      // 3)입력  스트림  생성 
      // 4)전달받은  데이터를  화면에  출력
    try {
		  String address = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
		  String serviceKey = "ymZ1HfLc6B8B%2Bh7a%2FsT3SCDVW2yhAC24FMvhndqKGUy%2F60%2BC%2B9%2BcJv3tQHPN6%2BU8%2BSQg9FWQqvF2oeBzJndX6A%3D%3D";
		  String stationName = "종로구";
		  String dataTerm = "Daily";
		  address += "?serviceKey="+serviceKey;
		  address += "&stationName=" + URLEncoder.encode(stationName,"UTF-8");
		  address += "&dataTerm="+dataTerm;
		  URL url = new URL(address);
		  
		  URLConnection conn = url.openConnection();
		  BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		  
		  String line;
		  while( (line = br.readLine()) != null) {
			  System.out.println(line);
		  }
		  
		  br.close();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 
	  

	  
	  
	  
	  
	  
	  
	}
}
