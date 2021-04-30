package com.koreait.JSPExam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod2")
public class JSPExamModservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("abc", Database2.list.get(Integer.parseInt(request.getParameter("no"))));
		request.getRequestDispatcher("WEB-INF/jsp/mod2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int idx = Integer.parseInt(no);
		
		BoardVO2 vo = Database2.list.get(idx);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database2.list.set(idx, vo);
		
		response.sendRedirect("/detail2?no="+no);
	}

}
