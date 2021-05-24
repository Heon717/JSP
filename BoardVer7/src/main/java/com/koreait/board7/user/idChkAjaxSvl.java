package com.koreait.board7.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/idChk")
public class idChkAjaxSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		System.out.println("uid : " +uid);
		int result = UserDAO.selIdChk(uid);
		
		response.getWriter()
		.append("{\"result\": ")  // \"result\" json문법 "result" 로 만들어야하기때문에 \" 사용
		.append(String.valueOf(result))
		.append("}");
		
//		response.getWriter().append("{\"result\": " + String.valueOf(result) + "}" );
//		되긴 되나 더하기를 안쓰려고 위의 방식대로 사용
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
