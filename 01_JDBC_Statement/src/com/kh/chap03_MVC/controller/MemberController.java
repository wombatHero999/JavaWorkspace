package com.kh.chap03_MVC.controller;

import java.util.List;

import com.kh.chap03_MVC.model.service.MemberService;
import com.kh.chap03_MVC.view.MemberView;
import com.kh.jdbc.model.vo.Member;

/* 
 * Controller : View를 통해 요청받은 기능처리를 담당
 *              view에서 전달받은 데이터들을 "가공처리" 한 후 , 알맞은 Service를 호출한다.
 *              Service로부터 작업 결과를 돌려받으면, 이에 맞춰 사용자가 보게될 응답화면을 지정.
 * */
public class MemberController {
	
	/** 
	 * 사용자의 회원추가 요청을 중계할 메소드.
	 * */
	
	private MemberService service = new MemberService();
	
	public void insertMember(String memberId, String memberPwd, String memberName) {
		// 전달받은 데이터 가공처리
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		m.setMemberName(memberName);
		
		// Service의 insertMember기능 호출
		// result는 service의 수행결과
		int result = service.insertMember(m);
		
		// 결과값(처리된 행의 갯수)에 따라 사용자가 보게될 응답화면을 지정
		if(result > 0) {
			// 성공 메세지 출력
			new MemberView().displaySuccess("회원 추가 성공");
		}else {
			// 실패 메세지를 출력
			new MemberView().displayFail("회원 추가 실패");
		}
	}

	public List<Member> selectAll() {
		List<Member> list = service.selectAll();
		
		if(list.isEmpty()) {
			new MemberView().displayFail("전체 조회 결과가 없습니다.");
		}else {
			new MemberView().displaySuccess("조회에 성공했습니다.");
		}
		
		return list;
	}

	public Member selectByUserId(String id) {
		
		Member m = service.selectByUserId(id);
		
		if(m == null) {
			new MemberView().displayFail("조회 결과가 없습니다.");
		}else {
			new MemberView().displaySuccess("조회 성공");
		}
		
		return m;
	}

	public List<Member> selectByUserName(String name) {
		
		List<Member> list = service.selectByUserName(name);
		
		if(list.isEmpty()) {
			new MemberView().displayFail("검색된 이름과 일치하는 회원이 없습니다.");
		}else {
			new MemberView().displaySuccess("검색된 이름과 일치하는 회원을 조회했습니다.");
		}
		return list;		
	}

	public void updateMember(String id, String pwd, String email, String phone, String address) {
		
		Member m = new Member();
		m.setMemberId(id);
		m.setMemberPwd(pwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = service.updateMember(m);
		
		if(result > 0) {
			new MemberView().displaySuccess("수정에 성공했습니다.");
		}else {
			new MemberView().displayFail("수정에 실패했습니다.");
		}
		
	}

	public void deleteMember(String id) {
		int updateCount = service.deleteMember(id);
		
		if(updateCount > 0) {
			new MemberView().displaySuccess("삭제에 성공했습니다.");
		}else {
			new MemberView().displayFail("삭제에 실패했습니다.");
		}
	}
	
	
	
	
	

}
