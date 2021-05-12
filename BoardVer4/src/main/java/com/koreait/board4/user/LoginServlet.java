package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(); // session 의 주소값
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser"); // 있으면 login
		if(loginUser != null) { // 로그인상태
			response.sendRedirect("/board/list");
			return;
		}
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
		//setAttribute 할수 있는 4개
		// pageContext
		// request
		// session
		// application
		
		doGet(request,response);			 
// 		둘다 같은데 조금 다른점은  위는 메소드호출로 해결했기땜에 위에서 받는 값이랑 여기 값이랑 같다.(다 연결이됨)
			
// 		호출하는순간 주소값이 이동됨.(쿼리스트링으로 이동)
//		response.sendRedirect("login?err="+result);
//		break;
	}

}
