package com.koreait.JSPExam2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		int intNum = Integer.parseInt(num);
		
		BoardVO li = BoardDAO.selectBoard(intNum);
		request.setAttribute("list", li);
		
		String jsp = "WEB-INF/view/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int intNum = Integer.parseInt(num);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setNum(intNum);
		BoardDAO.updboard(vo);
		
		response.sendRedirect("/detail?num="+num);
	}

}
