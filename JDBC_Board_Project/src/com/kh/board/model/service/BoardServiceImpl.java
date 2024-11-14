package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.template.JDBCTemplate;
import com.kh.board.model.vo.Board;

// BoardService 인터페이스를 구현하는 클래스.
// 각 메서드의 설명에 맞게 기능을 작성.
public class BoardServiceImpl implements BoardService{
	
	BoardDao dao = new BoardDao();
	
	@Override
	public int login(String memberId, String memberPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = dao.login(conn, memberId, memberPwd);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(int boardNo, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
