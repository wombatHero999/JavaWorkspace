package com.kh.chap02_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) {
		CRUD crud = new CRUD();
		crud.delete("' OR 1=1 --");
	}

	public void insert(String name) {
		/*
		 * DML작업시의 코딩 흐름. 1) Driver 등록 2) DBMS연결 3) autoCommit 설정하기. 기본값 true / false 4)
		 * Statement 객체 생성 5) SQL문 실행 -> executeUpdate(dml문); -> execute +
		 * getUpdateCount() 6) 트랜잭션 처리 7) 다쓴자원 반납.
		 */

		try {
			// 1) 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2) DBMS 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");

			// 3) autocommit설정
			conn.setAutoCommit(false); // 개발자가 직접 트랜잭션을 관리하겠다.

			// 4) Statement객체 생성
			Statement stmt = conn.createStatement();

			// 5, 6) DBMS에 완성된 SQL문을 전달하면서 쿼리를 실행하고, 실행된 결과값을 받기
			// Statement
			// - 실행할 SQL문을 완전한 "문장"형태로 만들어서 실행해야하는 클래스.

			int result = stmt.executeUpdate("INSERT INTO MEMBER \r\n" + "VALUES ('mkm','1234'," + name
					+ ",'M','user01@gmail.com','010-4121-3393','서울',32, SYSDATE)");

			// 7) 트랜잭션 처리
			if (result > 0) { // 1개 이상의 행이 추가된 경우 == 성공
				conn.commit();
			} else {
				conn.rollback();
			}

			// 8) 자원 반납
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			// 8) 자원 반납
//			stmt.close();
//			conn.close();
		}
	}

	public void update() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// 1)드라이버등록

		try {
			// 2)dbms연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			// 3) autocommit
			conn.setAutoCommit(false);

			// 4_1) PreparedStatement 생성
			/*
			 * PreparedStatement - 쿼리문을 미리 준비(Prepared)해둔 클래스. - Statement인터페이스를 상속받은 인터페이스.
			 * Statement의 단점을 개선하였음. - Statement 단점 1) 하드코딩한 데이터가 그대로 들어가 있어서 가동성이 좋지 못함. 2)
			 * 재사용성이 좋지 못함. Statement객체는 똑같은 sql문을 실행하더라도 매번 sql문을 새롭게 검사하여 실행함. 3) ★★
			 * sql인젝션을 방어할 수 없다. 4) 매개변수와 쿼리문을 조합하기 어렵다.
			 * 
			 * - 객체를 생성시 "미완성된" 상태의 sql문을 미리 전달하여 실행계획을 "준비"시키고, 실행하기 전 "완성된 형태"로 만든다.
			 */
			// 미완성된 sql문 ?
			// - 쿼리문에 필요한 값들을 채워 넣지 않은 쿼리문. 실제로 넣어줘야하는 값들은 ?(위치홀더)로 표시만 해둔다.
			String sql = "UPDATE MEMBER SET EMAIL = ? , PHONE = ?, ADDRESS = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);

			/*
			 * 4_2) 미 완성된 쿼리문을 실행 가능한 상태로 완성. pstmt의 setXXX함수를 통해 ?의 값에 내가원하는 값을 대입.
			 */

			pstmt.setString(1, "rudals@naver.com"); // (?의 위치, 변경할 값)
			// pstmt.setString(1, "111-111-111"); // (?의 위치, 변경할 값)
			// pstmt.setString(1, "경기도 김포시"); // (?의 위치, 변경할 값)
			pstmt.setString(2, "111-111-111");
			pstmt.setString(3, "경기도 김포시");
			pstmt.setString(4, "mkm");

			// 5 , 6) sql문 실행 및 결과값 반환.
			int result = pstmt.executeUpdate();

			// 7) 트랜잭션처리
			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	// DML(INSERT, UPDATE, DELETE)
	public void delete(String userId) {
		
		try {
			// 2)
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			// 3)
			conn.setAutoCommit(false);
			
			// Statement vs PreparedStatement
			// 4_1) Statement
			Statement stmt = conn.createStatement();
			
			// 쿼리문 실행
			int result = stmt.executeUpdate("DELETE FROM MEMBER WHERE MEMBER_ID = '"+userId+"'");
			
			System.out.println(result); // ' OR 1=1 -- 모든행 삭제			
			conn.rollback();
			
			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId); // sql인젝션 공격 방어.
			
			result = pstmt.executeUpdate();
			
			System.out.println(result); // 0행이 삭제
			conn.rollback();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
