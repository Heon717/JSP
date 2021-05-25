package com.koreait.board7.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/detail")
public class BoardDetailSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardDTO dto = new BoardDTO();
		dto.setIboard(iboard);
		
		request.setAttribute("data", BoardDAO.sleBoard(dto));
		MyUtils.openJSP("디테일", "board/detail", request, response);
		
	}

}
