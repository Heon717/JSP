package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// Get방식으로 보내면  댓글 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		Gson gson = new Gson();
		String json = gson.toJson(BoardCmtDAO.selBoardCmtList(param));
		System.out.println("json : "+ json);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append(json);
	}

	// Post형식으로 보내면   댓글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.insBoardCmt(param);
		
		// 결과물을 return;
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		// {"result": 1}
	}
}
