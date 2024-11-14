package com.kh.board.controller;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.view.BoardView;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {

	BoardService service = new BoardServiceImpl();
	
	public int login(String id, String pwd) {
		
		int count = service.login(id, pwd);
		
		if(count == 1) {
			// 사용자가 있는 경우
			new BoardView().displaySuccess("로그인 성공");
		}else {
			// 없는 경우
			new BoardView().displayFail("로그인 실패");
		}
		return count;
	}
	// service 변수 선언 및 초기화
	
	// view의 login요청을 담당할 메서드
	
	// view의 selectBoardList요청을 담당할 메서드
	
	// view의 selectBoard요청을 담당할 메서드
	
	// view의 insertBoard요청을 담당할 메서드
	
	// view의 updateBoard요청을 담당할 메서드
	
	// view의 deleteBoard요청을 담당할 메서드
	
	
			
}
