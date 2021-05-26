package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getParamInt("iuser", request); 
		//  iuser는 실제로 댓글 쓴사람이 맞는지 알아야하기떄문에 필요
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.delBoardCmt(param);
	}

	// 댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
