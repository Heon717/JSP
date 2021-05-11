package com.koreait.JSPExam2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MyUtils.openJSP("login",request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (BoardDAO.UserLoginCheck(id, pw) == 1) {
			request.getSession().setAttribute("user", id);
			response.sendRedirect("/list");
		} else {
			request.getSession().setAttribute("user", "");
			response.sendRedirect("/login");
		}
		
	}

}
