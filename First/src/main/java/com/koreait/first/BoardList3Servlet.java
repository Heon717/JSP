package com.koreait.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list3")
public class BoardList3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 쿼리스트링 (QueryString)
	// - Get 방식으로 서버 응답을 보낼 때 같이 보내는 data
	// ? 로 시작한다 . 구분: &  ,  구성: 키=값
	// 예) 이름, 나이 정보를 보낸다. (서버에서 원한다.)
	// 주소?name=홍길동&age=20

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		String jsp = "/WEB-INF/jsp/list3.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}



}
