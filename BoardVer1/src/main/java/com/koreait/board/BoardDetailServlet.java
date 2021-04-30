package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String no = request.getParameter("no");
//		System.out.println("no : "+no);
		
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));
		String js = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(js).forward(request, response);
	}

}
