package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	
	public static int getParamInt(String key,HttpServletRequest requset) {
		String val = requset.getParameter(key);
		int IntVal = parseStringToint(val);
		return IntVal;
	}
	
	public static int parseStringToint(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static void openJSP(String fileNm,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/"+fileNm+".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
		
	}
}
