package com.koreait.JSPExam2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class BoardDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String num = request.getParameter("num");
			int intNum = Integer.parseInt(num);
			
			BoardVO vo = new BoardVO();
			vo.setNum(intNum);
			
			BoardDAO.delboard(vo);
			
			response.sendRedirect("/list");
	}

}
