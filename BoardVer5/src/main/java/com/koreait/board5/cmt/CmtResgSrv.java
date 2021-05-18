package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/regCmt")
public class CmtResgSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// delete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request);
		int iboard = MyUtils.getParamInt("iboard", request);
		
		CmtVO cvo = new CmtVO();
		cvo.setIcmt(icmt);
		cvo.setIuser(iuser);
		cvo.setIboard(iboard);
		
		CmtDAO.delCmt(cvo);
		
		response.sendRedirect("detail?iboard="+iboard);

	}

	// insert , update
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmt = request.getParameter("cmt");
		int iboard = MyUtils.getParamInt("iboard", request);
		
		int iuser = MyUtils.getLoginUserPK(request);
			
		CmtVO cvo = new CmtVO();
		cvo.setIboard(iboard);
		cvo.setCmt(cmt);
		cvo.setIuser(iuser);
		
		CmtDAO.insCmt(cvo);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
