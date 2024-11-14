package com.kh.chap04_template.refactoring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class Template {
	/*
	 * Refactoring
	 *  - 기존의 코드를 변경하여 코드를 더 이해하기 쉽고 , 유지보수하기 쉽게 만드는 과정.
	 *  - 코드의 중복을 제거, 공용메소드나 클래스를 추출하고, 변수의 이름을 직관성있게 변경하는 작업등,
	 *    코드의 가독성과 유지보수성을 향상시키기 위해 수행하는 작업.
	 *  */
	
	/* 
	 * Connection 객체 생성 방식
	 * 1) 자바 어플리케이션에서 DBMS의 드라이버를 통해 커넥션을 조회.
	 * 2) DBMS드라이버는 DBMS와 TCP/IP 커넥션을 연결한다. (3 way handshake 발생)
	 *     1. 어플리케이션에서 db에 접속 요청을 보낸다.
	 *     2. db는 요청을 받고 요청을 수락한다는 메세지를 보낸다.
	 *     3. 어플리케이션에서는 db서버에 다시 접속한다는 요청을 보낸다. 이때 아이디, 비밀번호등을 전달한다.
	 * 3) DBMS드라이버는 TCP/IP 커넥션이 연결되면 아이디와 패스워드, 기타부가정보들을 오라클서버에 전달한다.
	 * 4) 오라클서버는 아이디, 패스워드를 통해 인증작업을 거친 후 DBMS커넥션을 생성한다.
	 * 5) 오라클서버는 커넥션 생성이 완료되었다는 응답 메세지를 보낸다.
	 * 6) DBMS드라이버는 커넥션 객체를 생성해서 클라이언트에게 반환해준다.
	 * 
	 * 커넥션은 객체를 생성 및 종료하는 작업은 굉장히 시간이 많이 드는 작업이며, 커넥션 객체를 자주 생성하는
	 * 것은 효율적이지 못하다. 
	 * 객체를 자주 생성하는 것이 문제이므로 객체를 사전에 미리 생성해두고, 필요할 때 마다 꺼내쓰는 방식으로 개
	 * 선한 것이 커넥션풀 (Connection Pool).
	 * */
	
	/* 
	 * ConnectionPool
	 *  - 커넥션객체를 미리 생성하여 보관해두는 커넥션 저장소.
	 *  - 커넥션객체를 생성하는 작업은 비용이 많이 드는 작업이므로, 사용자의 요청이 있을 때마다 생성하는 것이 아니
	 *    라 미러 커넥션 객체를 서넥션 풀에 생성해두고, 사용자의 요청이 들어올 때 마다 생성해둔 커넥션을 전달해주는
	 *    방식.
	 *  - 대표 커넥션풀 구현 라이브러리 : DBCP, HikariCP, Tomcat DataSource
	 *  - DBCP 라이브러리 다운로등방법
	 *    1) 메이븐 레파지토리 이용
	 *    2) Apache 공식 사이트에서 다운로드
	 * */
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		Connection conn = null;
		
		/* 
		 * BasicDataSource
		 *  - DBMS와의 연결, 커넥션풀 관리, 트랜잭션 관리 등의 기능을 구현한 클래스
		 *  - 데이터베이스에 연결 및 커넥션 풀 생성. 커넥션 생성 및 소멸관리와 예외처리등을 효율적으로 수행하는
		 *    메서드를 제공한다.
		 * */		
		BasicDataSource dataSource = new BasicDataSource();
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("resources/driver.properties"));
		
		// 생성하고자 하는 커넥션에 대한 정보를 기술.
		dataSource.setDriverClassName(prop.getProperty("driver"));
		dataSource.setUrl(prop.getProperty("url"));
		dataSource.setUsername(prop.getProperty("username"));
		dataSource.setPassword(prop.getProperty("password"));
		
		// 커넥션풀 설정
		dataSource.setInitialSize(10);// 초기 커넥션풀의 싸이즈.
		dataSource.setMaxTotal(50);// 커넥션풀의 최대 사이즈.
		dataSource.setDefaultAutoCommit(false); // 커넥션들의 자동커밋 설정
		dataSource.setMaxWaitMillis(10000); // 커넥션풀에서 커넥션이 없는 경우 대기할 최대시간 설정.
		dataSource.setRemoveAbandonedTimeout(300); // 사용하고 있지 않은 커넥션 삭제.
		
		conn = dataSource.getConnection();
		
		return conn;
		
		/*
		 *  커넥션풀의 장점
		 *   - 성능향상 : 커넥션풀은 데이터베이스와 미리 연결을 완료한 Connection객체를 생성해두고, 풀에 유지
		 *     시킴으로써 어플리케이션의 향상시킬 수 있다.
		 *     
		 *   - 메모리 누수 방지 : 사용하고 닫아두지 않은 커넥션들을 일정시간이 지났을때 자동으로 삭제시키는 기능이
		 *     추가되어 있음.
		 *   
		 *   - 확장성 : 커넥션풀 클래스에서 만들어 놓은 다양한 기능들을 추가하여 원하는 형태의 커넥션들을 생성할 수 있다.
		 *  
		 *  커넥션풀의 단점
		 *   - 설정이 귀찮다.
		 *   - 초기로딩이 오래걸림
		 *   - 메모리를 항상 점유하고 있으므로 메모리 낭비가 심하다. 
		 *  */
	}
	
	
	
	
	
}
