package com.kh.chap01_URL.part03_request;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AirPolution {
	
	/* 
	 * URLConnection활용 예시
	 * 1) 웹크롤링
	 * 2) API서버로 데이터 요청
	 *  - API 서버 ? URL로 데이터에 대한 요청(request)을 보내면 그에대한 응답(response)데이터를 반환해주는 서버
	 *   
	 *    자바 API ? 자바 어플리케이션 개발에 도움을 주는 클래스들..
	 *    API ? 어플리케이션간에 상호작용을 위한 인터페이스
	 *          어플리케이션들중 데이터나 서비스를 제공하는 역할의 어플리케이션을 API서버라고 부름.
	 *          
	 *          대표적인 API서버 역할을 하는 애플리케이션은 카카오, 구글, 네이버...
	 *          일반사이트에서 API서버에서 제공하는 소셜로그인기능등을 구현하려면, API서버쪽에서 정한 규칙(인터페이스)을 지켜서
	 *          데이터요청을 보내야 한다.
	 *    
	 *   공공데이터포탈 API사용 방법
	 *   1) 회원가입
	 *   2) 사용하고자하는 API 검색( 한국환경공단_에어코리아_대기오염)
	 *   3) 활용신청
	 *   4) 활용신청 완료시 개인 API인증키 발급. -> 인증키 복사후 메모장등에 붙여넣기.
	 *   5) 사용하고자하는 API사용 메뉴얼 확인.
	 *   6) 요청주소, 요청변수와 그에 따른 응답데이터 확인. 
	 *   7) 요청주소+요청변수를 묶어서 api서버로 요청보내기.
	 *   8) api서버로부터 응답결과 돌려받기
	 *   9) 그 응답결과를 통해 프로그래밍
	 * */
	
	// 한국환경공단_에어코리아_대기오염정보에서 대기오염정보를 불러온 후 , 콘솔창에 출력
	// ymZ1HfLc6B8B%2Bh7a%2FsT3SCDVW2yhAC24FMvhndqKGUy%2F60%2BC%2B9%2BcJv3tQHPN6%2BU8%2BSQg9FWQqvF2oeBzJndX6A%3D%3D
	
	public static void main(String[] args) {
		
		String requestUrl = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		final String serviceKey = "ymZ1HfLc6B8B%2Bh7a%2FsT3SCDVW2yhAC24FMvhndqKGUy%2F60%2BC%2B9%2BcJv3tQHPN6%2BU8%2BSQg9FWQqvF2oeBzJndX6A%3D%3D";
		
		// 요청주소와 요청변수 묶어주기.
		// [표현법]
		// 요청주소?key=value&key=value
		try {
			requestUrl += "?serviceKey="+serviceKey;
			requestUrl += "&sidoName=" + URLEncoder.encode("서울","UTF-8");
			// URL로 전달되는 데이터에 한글이 포함된 경우 해석이 불가능하므로,
			// URL방식으로 인코딩해서 보내줘야한다.
			// (한글뿐 아니라 특수문자, 한자와 같은 문자열도 포함)
			
			//URL객체 생성
			URL url = new URL(requestUrl);
			URLConnection conn = url.openConnection();
			
			// 입력스트림 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter("환경오염.xml"));
			
			//html페이지 내용을 담을 변수
			StringBuilder content = new StringBuilder();
			String line;
			while( (line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
			writer.write(content.toString());
			
			reader.close();
			writer.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
	
	
	
}
