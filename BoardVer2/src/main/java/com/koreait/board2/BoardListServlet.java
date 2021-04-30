package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = Database.db;
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("lis", list);
		
		request.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(request, response);
		// get은 화면에 이동
		// post는 데이터,처리 등이라고 생각
		
	}

}
