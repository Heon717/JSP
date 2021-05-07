package com.koreait.JSPExam2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/view/join.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");

		if (!pass1.equals(pass2) || id=="" || pass1 == "" || pass2 == "") {
			response.sendRedirect("/join");
		} else {
			BoardVO vo = new BoardVO();
			vo.setId(id);
			vo.setPassword1(pass1);
			vo.setPassword2(pass2);
			BoardDAO.memberJoin(vo);
			response.sendRedirect("/list");
		}
	}

}
