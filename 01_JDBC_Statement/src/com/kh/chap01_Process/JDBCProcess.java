package com.kh.chap01_Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProcess {
	/* 
	 * JDBC(Java Database Connectivity)
	 *  - Java 어플리케이션과 데이터베이스간의 연동시 필요한 연결방법 및 sql문을 전달하고 결과값을 돌려받는 방법들을 정의한
	 *    java api.    
	 *  - JDBC는 연결하고자 하는 데이터베이스가 무었이던 일관된 방법으로 통신할 수 있게 표준화 시켰다.
	 *  
	 *  JDBC를 알아야하는 이유
	 *   - Spring, MyBatis, JAP등에서 내부코드 구현시 jdbc를 활용했기 때문에 프레임워크의 작동방식을 이해하기 위하여
	 *     JDBC를 알아두어야 한다.
	 *  
	 *  JDBC의 주요 객체들
	 *   - DBMS와 "연결"하여 실행할 SQL문을 DBMS에 "전달"하고 "결과값을" 반환 받는 객체들이 존재한다.
	 *   1) xxxDriver : DB와 연결을 담당하는 핵심 클래스.(OralceDriver) . 각 밴더사에서 Driver라는 인터페이스를 구현
	 *                  한 클래스.(별도의 다운로드가 필요)
	 *   2) DriverManger : Driver들을 관리하는 클래스. 여러개의 Driver들 중 어떤 Driver를 통해 db와 연결할지
	 *                  선택할 수 있다.
	 *   
	 *   3) Connection : db와 연결된 상태임을 나타내는 객체. 연결 설정 및 연결 해제, statement 생성 및 트랜잭션 관리
	 *                   를 수행할 수 있다.
	 *   
	 *   4) (Prepared)Statement : 연결된 db에 실행할 sql문을 전달하고, 실행한 후 결과값(ResultSet, int)을 받아내는 객체
	 * 
	 *   5) ResultSet : Statement로 실행한 sql문이 SELECT(DQL)일 경우 조회된 결과를 담아내는 객체.
	 * */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/* 
		 * JDBC 코딩 흐름
		 * 
		 * 1) Driver 등록 -> 연결하고자 하는 dbms의 Driver클래스 등록
		 * 2) DBMS 연결 -> 접속하고자 하는 DB정보를 입력하여 DB에 연결.
		 * 3) Statment 생성 -> Connection객체를 통해 생성
		 * 4) SQL 실행 -> Statement를 통해 sql 실행.
		 * 5) 결과값 반환 -> 수행한 sql이 DQL인 경우 ResultSet반환, 그 외에 DML일 경우 INT값 반환
		 * 6) 트랜잭션 처리 / ResultSet데이터 변환
		 * 7) 사용한 자원방법
		 * 
		 * */
		
		//1) 오라클 드라이버 등록
		/* 
		 * 오라클 드라이버 등록방법
		 * 1. 프로젝트 우클릭 -> Properties -> Java build path로 이동
		 * 2. 라이브러리 이동 -> Module path 선택
		 * 3. Add External Jars 선택후 ojdbc11.jar파일 추가.
		 * 
		 * OracleDriver클래스 파일 확인 방법
		 * 1. 디컴파일러 다운로드(decompiler) - enhanced class decompiler
		 * 2. window -> preperference -> general -> editors -> file Associations이동
		 *    *.class with source 선택 후, class decompiler viewer를 default로 설정.
		 * */
		// 명시적 드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		/* 
		 * OracleDriver클래스 내부의 static초기화 블럭을 통해
		 * DriverManger.registerDriver(등록할 드라이버객체)를 자동 호출하고 있다.
		 * */
		
		// 2) 등록된 드라이버 목록 확인
		// drivers() : 등록된 Driver들을 Stream으로 반환해주는 함수.
		DriverManager.drivers()
		.forEach( driver -> System.out.println(driver));
		
		// 3) DBMS연결 == Connection 객체 생성 
		// dbms와 연결하기 위해서는 URL,계정, 비밀번호
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"C##JDBC",
				"JDBC");
		
		// 4) Statement 객체 생성
		Statement stmt = conn.createStatement();
		
		// 5) DB에 SQL문을 전달 후 실행
		
		boolean result = stmt.execute("SELECT 'HELLO JDBC' as TEST FROM DUAL");	
		//System.out.println(result);
		// 조회에 성공했다면 
		if(result) {
			ResultSet rset =stmt.getResultSet(); // sql문을 select로 호출한 경우 조회결과가 resultSet에 저장된다.
			                     // 만약 update/delete/insert문을 수행한 경우 수행 결과가
			                     //     updateCount필드에 저장된다.
			rset.next(); // 커서의 위치를 다음 행으로 이동. 0 -> 1;
			System.out.println( rset.getString("TEST"));
		}
		// 6) execute + getResultSet 합친 함수 => executeQuery		
		ResultSet rset = stmt.executeQuery("SELECT 'HELLO JDBC' AS TEST FROM DUAL");
		
		if(rset.next()) System.out.println(rset.getString("TEST"));
		
		// 사용한 자원 반납
		// 자원 반납시에는 생성된 자원의 역순으로 반환.
		rset.close();
		stmt.close();
		conn.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
