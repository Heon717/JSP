package com.koreait.board5.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.MyUtils;
import com.koreait.board6.user.UserDAO;

@WebServlet("/user/login")
public class UserLoginSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " +result );
		
		if(result == 1) {
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo); 
			// vo 가 가리키는 UserVo객체는 (iuser,uid,unm 값만 담고있다.)
			response.sendRedirect("/board/list");
			return;
		}
		
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인헤 주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요";
			break;
		}
		request.setAttribute("err", errMsg);
		doGet(request, response);
	}

}
