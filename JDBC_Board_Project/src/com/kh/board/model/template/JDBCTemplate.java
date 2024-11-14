package com.kh.board.model.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// JDBC의 주요 메서드들을 정의한 클래스
// getConnection, close, commit, rollback 메서드를 정의
// 단, db와의 연결정보는 resources/driver.properties에서 관리한다.
public class JDBCTemplate {
	// 1. db접속 및 Connection 생성
	public static Connection getConnection() {
		/*
		 * JDBC Driver, 접속할 URL, 계정명, 비밀번호를 자바 소스코드내에 명시적 작성하는 경우 보안상 위험할 수 있다.
		 * 
		 * DB와 관려된 정보들을 별도로 보관하는 외부파일을 생성하여 보안성을 향상
		 */
		Properties prop = new Properties();

		Connection conn = null;
		try {
			prop.load(new FileInputStream("resources/driver.properties"));

			// 1) Driver 등록
			Class.forName(prop.getProperty("driver"));

			// 2) Connection 생성
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
			// 3) autocommit설정
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 2. jdbc용 객체들을 대신 반납해주는 메소드들.
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. 전달받은 Connection을 통해 대신 트랜잭션을 수행하는 메소드.
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
