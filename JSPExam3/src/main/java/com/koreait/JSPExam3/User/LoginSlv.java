package com.koreait.JSPExam3.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.JSPExam3.MyUTL;

@WebServlet("/login")
public class LoginSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUTL.JSPutl("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		uvo.setUpw(upw);
		
		int result = UserDAO.UserLogin(uvo);
		System.out.println("result : " + result);
		
		// 1 : 로그인성공 (true일때)
		if(result == 1) {
			HttpSession hs = request.getSession();
			uvo.setUpw(null);
			// null 하는 이유는 객체에 upw 빼고 ( iuser, uid , unm 값만 담을려고 하기 때문)
			hs.setAttribute("loginUser", uvo);
			response.sendRedirect("list");
			return;
		}
		
		String err = null;
		switch (result) {
		case 0: 
			err = "에러가 발생하였습니다.";
			break;
		case 2:
			err = "아이디가 잘못입력되었습니다.";
			break;
		case 3:
			err = "비밀번호를 틀리렸습니다.";
			break;
		}
		request.setAttribute("err", err);
		
		doGet(request, response);

	}

}
