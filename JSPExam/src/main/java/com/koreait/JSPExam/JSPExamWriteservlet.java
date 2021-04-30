package com.koreait.JSPExam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write2")
public class JSPExamWriteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/jsp/write2.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO2 abc = new BoardVO2();
		abc.setTitle(title);
		abc.setCtnt(ctnt);
		Database2.list.add(abc);

		response.sendRedirect("/list2");
	}

}
