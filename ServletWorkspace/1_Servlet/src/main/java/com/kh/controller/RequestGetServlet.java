package com.kh.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestGetServlet extends HttpServlet {
	
	
	
	
	
	
	/* 
	 * 클라이언트가 get방식으로 요청 했을 때 처리할 메서드를 정의
	 * */	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 	1. HttpServletRequest는 클라이언트가 요청시 전달한 내용들이 담기는 객체
		 *     (사용자가 입력한 값, 요청전송방식 , 사용자의 ip 등등)
		 *  2. HttpServletResponse는 요청 처리 후 html을 응답해줄 때 사용하는 객체
		 *  
		 *  요청 처리를 위해서는 클라이언트가 쿼리스트링으로 전달한 값들을 뽑아야함.
		 *  이때 request의 parameter객체안에 정보들이 존재하므로 parameter에서 값을 뽑아주는 작업이 필요.
		 *  
		 *  1. request.getParameter("키값") : String -> 사용자가 전달한 값을 문자열로 반환받는 메서드
		 *  2. request.getParameterValues("키값") : String[] -> 사용자가 동일한 key값으로 전달한 값
		 *  들을 문자열 배열로 반환받는 메서드(checkbox에서 사용)
		 *  */
		
		//클라이언트가 전달한 값들 뽑기
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age")); // "13" => 13
		String city = req.getParameter("city");
		double height = Double.parseDouble(req.getParameter("height"));// "200" => 200.0
		String [] foods = req.getParameterValues("food");
		
		
	
	
	}
	
	
	
	
}
