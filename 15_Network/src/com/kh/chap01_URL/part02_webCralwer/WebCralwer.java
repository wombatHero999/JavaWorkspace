package com.kh.chap01_URL.part02_webCralwer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCralwer {
	
	/* 
	 * URL을 활용한 웹 크롤링
	 * 웹크롤링? 웹페이지를 탐색하여 정보를 수집하는 프로그램. 다양한 웹페이지를 방문하고 내용을 분석하여 필요한
	 *        정보만 추출하는 자동화기법.
	 *        단, 웹페이지 소유주가 크롤링을 허용하지 않을 경우 법적 책임이 따를 수 있다.
	 *  
	 * 일반적인 웹 크롤링 순서 
	 * 1) 내가 수집하고자 하는 데이터가 존재하는 웹페이지의 시작과 끝페이지를 확인한다.
	 * 2) 수집하고자 하는 데이터가 웹페이지상에서 어떤 특징을 가지고 있는지 확인한다.
	 * 3) URL과 URLConnection을 통해 각 웹페이지와 연결하고, 해당 페이지의 모든 데이터를 저장.
	 * 4) 저장된 데이터(문자열)에서 내가 원하는 데이터만 추출하기. ex) <img src="">와 같은 자원경로만 가져오기.    
	 * 5) 저장된 데이터에서 내가 원하는 "문자열패턴"안의 데이터만 가져오기 위해서는 정규식이란것을 활용한다.
	 * 6) 추출한 데이터로 내가 원하는 작업을 한다. 
	 * 
	 * */	
	public void test4() {
		// 데이터를 수집하고자 하는 웹페이지 주소.
		for(int i =1; i<=44; i++) {
			String address = "https://khedu.co.kr/project/team.kh?cpage="+i;
			
			BufferedReader reader = null;
			List<String> imgList = new ArrayList();
			
			try {
				URL url = new URL(address);
				URLConnection conn = url.openConnection();
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				StringBuilder htmlContent = new StringBuilder();
				String line;
				
				while( (line = reader.readLine()) != null) {
					htmlContent.append(line).append("\n");
				}
				
				// html의 문서를 한줄씩 읽어서 htmlContent에 저장
				
				// <img src=""> 와 일치하는 문자열을 찾을때마다 imgList에 저장
				String regEx = "<img\\s+src=\"([^\"]+)\"";
				Pattern pattern = Pattern.compile(regEx); // 정규표현식을 검사해주는 객체
				Matcher matcher = pattern.matcher(htmlContent); // 일치하는 문자열을 검사하는 방법
				
				// 검사를 통해 일치하는 문자열을 찾을대마다 실행
				while(matcher.find()) {
					//<img src="/resources/images/main/main_renewal/top_line2.jpg">
					String imgUrl = matcher.group(1); // "/resources/images/main/main_renewal/top_line2.jpg"
					System.out.println(imgUrl);
					imgList.add(imgUrl);
				}
				
				System.out.println("검색 완료");
				// 검색된 이미지를 기준으로 다시한번 웹서버 자원과 연결하여 파일 다운로드하기.
				saveFile(imgList);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	private void saveFile(List<String> imgList) {
		for(String imgPath :  imgList) {
			
			if(!imgPath.contains("/upload/project/")) {
				continue;
			}
			
			// imgPath경로를 통해 이미지 다운로드하기
			
			String fileName = imgPath.substring( imgPath.lastIndexOf("/") );
			String savePath = "C:/upload/project/"+fileName;
			
			URL url;
			BufferedOutputStream out;
			BufferedInputStream in;
			
			try {
				url = new URL("https://khedu.co.kr"+imgPath);
				URLConnection conn = url.openConnection();
				
				out = new BufferedOutputStream(new FileOutputStream(savePath));
				in  = new BufferedInputStream(conn.getInputStream());
				
				int bytes;
				while( (bytes = in.read()) != -1) {
					out.write(bytes);
				}
				
				out.close();
				in.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}
