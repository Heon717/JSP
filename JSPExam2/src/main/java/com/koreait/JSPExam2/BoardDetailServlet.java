package com.koreait.JSPExam2;

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
		String num = request.getParameter("num");
		int intnum = Integer.parseInt(num);
		
		BoardVO li = BoardDAO.selectBoard(intnum);
		request.setAttribute("list", li);
		
		String jsp = "/WEB-INF/view/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}


}
