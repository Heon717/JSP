package com.koreait.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write3")
public class BoardWriteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("WEB-INF/view/write3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title :"+title);
		System.out.println("content :"+content);
		
		BoardVO3 vos = new BoardVO3();
		vos.setTitle("title");
		vos.setContent("content");
		
		BoardDAO.insertBoard(vos);
		response.sendRedirect("/list3");
	
	}

}
