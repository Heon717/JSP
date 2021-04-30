package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class boardListsevlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/write.jsp").forward(request, response);

	}
	// 클라이언트(부라우저)값이 서버쪽으로 넘어왔을 때 
	//	<값 빼는 방법>
	// request.getParameter(키값);
	// -------------------------------------------
	// 서블릿에서 jsp 로 값 전달하는 방법
	//	<값 넣는 방법>
	// request.setAttribute(키값,벨류값);
	//	<값 빼는 방법>
	// request.getAttribute(키값)
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // post에서 한글 깨짐현상 방지
		String title = request.getParameter("title"); // 
		String ctnt = request.getParameter("ctnt");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database.list.add(vo);
		
		response.sendRedirect("/list"); // Get방식으로 주소 이동
	}

}
