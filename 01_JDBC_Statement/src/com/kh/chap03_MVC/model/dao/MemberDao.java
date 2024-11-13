package com.kh.chap03_MVC.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.kh.chap03_MVC.model.template.JDBCTemplate;
import com.kh.jdbc.model.vo.Member;

/* 
 * DAO(Data Access Object)
 *  - Service에 의해 호출되며, 맡은 기능을 수행하기 위해 db에 직접 접근하여 sql문을 호출한 후 
 *    처리 결과값을 반환시켜주는 객체. *    
 * */
public class MemberDao {
	
	private Properties prop = new Properties();
	
	{
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member m) {
		
		// 1) 변수들 초기화
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			
			result = pstmt.executeUpdate();
			
			//pstmt = conn.prepareStatement("");
			//result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;		
	}

	public List<Member> selectAll(Connection conn) {
		// select -> ResultSet
		List<Member> list = new ArrayList<>(); // 반환시킬 값들을 저장할 컬렉션
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	

}
