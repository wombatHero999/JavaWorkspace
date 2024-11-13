package com.kh.chap03_MVC.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.chap03_MVC.model.dao.MemberDao;
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
		
		// 사용자의 포인트 정보를 보관하는 테이블이 있다고 가정
		// MemberPoint 테이블에 1행의 데이터 추가.
		
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
		Connection conn = getConnection();
		
		List<Member> list = dao.selectAll(conn);
		
		return list;
	}
	
	
	
	

}
