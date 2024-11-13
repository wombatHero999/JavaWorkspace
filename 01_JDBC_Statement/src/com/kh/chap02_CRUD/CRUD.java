package com.kh.chap02_CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.model.vo.Member;

public class CRUD {

	public static void main(String[] args) {
		CRUD crud = new CRUD();
		//crud.delete("' OR 1=1 --");
		//crud.selectOne("user01");
		//crud.execPlSql();
		crud.execProcedure();
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
			// EXCUTE() + getUpdateCount()
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
			 * PreparedStatement 
			 *  - 쿼리문을 미리 준비(Prepared)해둔 클래스.
			 *  - Statement인터페이스를 상속받은 인터페이스.
			 *  
			 * Statement의 단점을 개선하였음. 
			 * - Statement 단점 
			 * 	1) 하드코딩한 데이터가 그대로 들어가 있어서 가동성이 좋지 못함. 
			 *  2) 재사용성이 좋지 못함. Statement객체는 똑같은 sql문을 실행하더라도 매번 sql문을 새롭게 검사하여 실행함. 
			 *  3) ★★ sql인젝션을 방어할 수 없다. 
			 *  4) 매개변수와 쿼리문을 조합하기 어렵다.
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
	
	/* 
	 * DQL(SELECT) JDBC 코딩 흐름
	 * 
	 * 1) Driver 등록
	 * 2) DBMS 연결
	 * 3) PreparedStatement 생성
	 * 4) SQL실행
	 * 5) 결과값 반환
	 * 6) 돌려받은 RESULTSET을 알맞은 VO클래스로 매핑. 
	 * 7) 다쓴 자원은 반납. 
	 * */
	
	// 1개의 행을 조회할 경우
	public void selectOne(String userId) {
		
		// 1)
		
		try {
			// 2) DBMS연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			// 3) PreparedStatement 생성
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			// 4,5) sql실행후 값 반환
			ResultSet rset = pstmt.executeQuery();
			/* 
			 * ResultSet
			 *  - SELECT를 호출한 결과값이 담겨있는 객체.
			 *  - 커서(Cursor)를 사용하여 ResultSet의 각 행에 접근하여 데이터를 읽어올 수 있음.
			 *   * 커서(Cursor) 
			 *    -> ResultSet내부에서 특정 "행"을 가리키는 포인터
			 *  - 커서의 위치를 변경하는 메소드들.
			 *    1) next() : boolean -> 커서를 다음 행으로 이동 시키고(+1) 행이 있다면 true / 없다면 false값을 반환.
			 *    2) previous() : boolean -> 커서를 이전행으로 이동 시키고(-1) 행이 있다면 true / false
			 *    3) first() : boolean -> 커서를 반드시 첫 번째(1번행) 행으로 이동 시키고 행이 있다면 true / false
			 *    4) last() : boolean  -> 커서를 반드시 마지막 행으로 이동시키고 있다면 true / false
			 *    5) absolute(int row) : boolean -> 커서를 지정된 행으로 이동시키는 메서드. 있다면 true/false
			 *    6) relative(int rows) : boolean -> 커서를 "현재위치에서" 지정된 수만큼 의 행을 이동시키고 
			 *                                      해당 위치에 행이 있다면 true / false;
			 * */
			//6) rest을 vo객체로 매핑.
			// 커서의 위치를 0에서 1로 옮긴 후 , 1번 행에 데이터가 존재하는지 확인.
			// 존재한다면 사용자가 있는것이고, 존재하지 않는다면 잘못된 id를 기술한 것
			if(rset.next()) {
				// 현재 커서의 위치에서 해당 행의 데이터를 하나씩 뽑아서 Member객체로 변환.
				
				// rset으로부터 어떤 컬럼에서 어떤 값을 뽑을건지 제시.
				// rset.getXXX(컬럼명, 컬럼의순번) 
				// XXX : int, string, date
				String memberId = rset.getString("MEMBER_ID"); // "MKM"
				String memberPwd = rset.getString("MEMBER_PWD"); // "1234"
				String memberName = rset.getString("MEMBER_NAME"); //"민경민"
				String email = rset.getString("EMAIL");
				String gender = rset.getString("GENDER"); // M , F
				String phone = rset.getString("PHONE");
				String address = rset.getString("ADDRESS");
				int age = rset.getInt("AGE");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age, enrollDate);
				System.out.println(m);
			}
			
			//7 ) 자원 반납
			rset.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 여러행의 데이터를 조회
	public void selectAll() {
		
		try {
			// 2) DBMS연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			// 3) 문장객체생성
			String sql = "SELECT * FROM MEMBER";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 4,5)
			ResultSet rset = pstmt.executeQuery();
			
			// 6) 결과값을 vo로 매핑
			List<Member> list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID"); // "MKM"
				String memberPwd = rset.getString("MEMBER_PWD"); // "1234"
				String memberName = rset.getString("MEMBER_NAME"); //"민경민"
				String email = rset.getString("EMAIL");
				String gender = rset.getString("GENDER"); // M , F
				String phone = rset.getString("PHONE");
				String address = rset.getString("ADDRESS");
				int age = rset.getInt("AGE");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age, enrollDate);
				list.add(m);
				System.out.println(m);
			}
			System.out.println(list.size());
			
			// 7) 자원반납(사용한 자원 역순)
			rset.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// JDBC로 PL/SQL문 실행하기
	public void execPlSql() {
		
		try {
			// 2) DBMS연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			// 3) PreparedStatment 생성
			String plSql = "BEGIN UPDATE MEMBER SET MEMBER_NAME = ? WHERE MEMBER_ID = ? ; END;";
			PreparedStatement pstmt = conn.prepareStatement(plSql);
			
			pstmt.setString(1, "강아지");
			pstmt.setString(2, "user01");
			
			pstmt.execute();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// jdbc로 프로시져 생성 및 실행
	// 1) KH계정에 PRO_SELECT_EMP
	public void execProcedure() {
		try {
			//2) DBMS연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					,"C##KH"
					,"KH");
			
			//3) CallableStatement 생성
			// CallableStatement?
			// - 저장된 프로시저를 호출하기위한 객체
			// - PreparedStatement처럼 ?를 이용할 수 있다.
			// [표현법] {call 프로시저명(매개변수...)}
			String sql = "{call PRO_SELECT_EMP(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, 200); // EMP_ID
			cstmt.registerOutParameter(2, Types.VARCHAR); // emp_name : varchar2
			cstmt.registerOutParameter(3, Types.INTEGER); // salary : number(정수)
			cstmt.registerOutParameter(4, Types.DOUBLE); // bonus : number(실수)
			
			cstmt.execute();
			
			String empName = cstmt.getString(2);
			int salary = cstmt.getInt(3);
			double bonus = cstmt.getDouble(4);
			
			System.out.println(empName +" , "+salary+", "+bonus);
			
			// 5) 자원반납
			cstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
