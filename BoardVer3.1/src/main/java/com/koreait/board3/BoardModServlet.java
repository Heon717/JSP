package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 data = BoardDAO.selBoard(intIboard);
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard =  request.getParameter("iboard");
		String title =  request.getParameter("title");
		String ctnt = request.getParameter("content");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setContent(ctnt);
		
		BoardDAO.updBoard(vo);
		
		response.sendRedirect("/detail3?iboard="+iboard);
	}

}
