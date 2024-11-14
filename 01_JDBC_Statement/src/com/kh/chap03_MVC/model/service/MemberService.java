package com.kh.chap03_MVC.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.chap03_MVC.model.dao.MemberDao;
import com.kh.chap04_template.refactoring.Template;

import static com.kh.chap03_MVC.model.template.JDBCTemplate.*;
import com.kh.jdbc.model.vo.Member;
/* 
 * Service
 *  - 컨트롤러에 의해 실행되는 메소드들
 *  - Dao에 존재하는 메소드들을 호출하여 논리적으로 연관이 있는 여러개의 메소드들을 묶음으로 호출할 수 있다.
 *  - 처리 결과값을 항상 컨트롤러에게 반환해주는 역할을 한다.
 * */
public class MemberService {
	
	private MemberDao dao = new MemberDao();

	public int insertMember(Member m) {
		// 커넥션 객체 생성
		Connection conn = getConnection();
		// 회원가입 서비스
		// Member테이블에 1행의 데이터(m) 추가
		int rows = dao.insertMember(conn, m);
		
		// 사용자의 회원가입 일자를 저장하는 테이블이 있다고 가정
		// MemberEnroll 테이블에 1행의 데이터 추가
		// rows = dao.insertMemberEnroll(conn, m);
		
		// 사용자의 포인트 정보를 보관하는 테이블이 있다고 가정
		// MemberPoint 테이블에 1행의 데이터 추가.
		// rows = dao.insertMemberPoint(conn, m);
		
		if(rows > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		// 커넥션 반환
		close(conn);
		
		return rows;
	}

	public List<Member> selectAll() {
		Connection conn = null;
		try {
			conn = Template.getConnection();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Member> list = dao.selectAll(conn);
		
		return list;
	}

	public Member selectByUserId(String id) {
		Connection conn = getConnection();
		
		Member m = dao.selectByUserId(conn, id);
		
		return m;
	}

	public List<Member> selectByUserName(String name) {
		Connection conn = getConnection();
		
		List<Member> list = dao.selectByUserName(conn, name);
		
		close(conn);
		
		return list;
	}

	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteMember(String id) {
		Connection conn = getConnection();
		
		int updateCount = dao.deleteMember(conn , id);
		
		if(updateCount == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return updateCount;
	}
	
	
	
	

}
