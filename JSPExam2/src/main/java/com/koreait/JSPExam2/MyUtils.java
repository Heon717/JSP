package com.koreait.JSPExam2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String fileNm,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/view/"+fileNm+".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);

	}

	public static int parseStringToint(String num) {
		try {
		int i = Integer.parseInt(num);
		return i;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getParamInt(String key , HttpServletRequest request) {
		String strVal = request.getParameter(key);
		return parseStringToint(strVal);
	}
	
	
}
