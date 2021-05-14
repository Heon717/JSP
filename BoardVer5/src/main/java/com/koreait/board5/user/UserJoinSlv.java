package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/join")
public class UserJoinSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nm = request.getParameter("nm");
		String gender = request.getParameter("gender");
		int intgender = Integer.parseInt(gender);
		String hapw = BCrypt.hashpw(pw, BCrypt.gensalt());
		UserVO uvo = new UserVO();
		uvo.setUid(id);
		uvo.setUpw(hapw);
		uvo.setUnm(nm);
		uvo.setGender(intgender);
		
		UserDAO.joinUser(uvo);
		
		response.sendRedirect("login");
	}

}
