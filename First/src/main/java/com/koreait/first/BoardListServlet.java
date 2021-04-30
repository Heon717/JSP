package com.koreait.first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그인 비밀번호에는 post 방식 (주소에 입력값이 안뜸 ) 둘다 서버에 요청 방식이 다름 오픈하는게 get 
	// 아니면 대부분 get 방식 사용 (주소에 이름들이 바뀜 )  숨기는게 post

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append("<html>")
		.append("<head><title>안녕</title><meta charset=\"UTF-8\"></head>")
		.append("<body>")
		.append("<dddd>")
		.append("</body>")
		.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doPost");
		doGet(request, response);
	}

}
