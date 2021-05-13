package com.koreait.JSPExam3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUTL {
	
	public static void JSPutl(String file,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/"+file+".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
