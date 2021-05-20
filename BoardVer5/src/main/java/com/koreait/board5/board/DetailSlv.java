package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;

@WebServlet("/board/detail")
public class DetailSlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String iboard = request.getParameter("iboard");
		int intiboard = Integer.parseInt(iboard);
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardVO data = new BoardVO();
		data.setIboard(intiboard);
		data.setIuser(iuser);
		data = BoardDAO.sleBoard(data);
		request.setAttribute("data", data);
		
		request.setAttribute("list", CmtDAO.selListCmt(intiboard));
		
		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
