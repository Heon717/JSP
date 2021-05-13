package com.koreait.JSPExam3.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.JSPExam3.MyUTL;

@WebServlet("/join")
public class JoinSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUTL.JSPutl("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		String unm = request.getParameter("name");
		String gender = request.getParameter("gender");
		int Intgender = Integer.parseInt(gender);
		
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		uvo.setUpw(upw);
		uvo.setUnm(unm);
		uvo.setGender(Intgender);
		
		UserDAO.UserJoin(uvo);
		
		response.sendRedirect("login");
	}

}
