package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/mod")
public class ModSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intiboard = Integer.parseInt(iboard);
		
		BoardVO li = BoardDAO.sleBoard(intiboard);
		HttpSession hs = request.getSession();
		UserVO loginuser = (UserVO) hs.getAttribute("loginUser");
		// 로그인중인 iuser
		int iuser = loginuser.getIuser();
		
		// 로그인중인 iuser와 주소로 입력해서들어온 iuser 값이 다르면 리턴한다.
		if (iuser != li.getIuser()) {
			response.sendRedirect("board/list");
			return;
		}
		
		request.setAttribute("list", li);
		
		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String iboard = request.getParameter("iboard");
		int intiboard = Integer.parseInt(iboard);
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setCtnt(ctnt);
		bvo.setIboard(intiboard);
		
		BoardDAO.updBoard(bvo);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
