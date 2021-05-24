package com.koreait.board7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board7.user.UserEntity;


public class MyUtils {
	public static int getLoginUserPK(HttpServletRequest requset) {
		UserEntity loginUser = getLoginUser(requset);
		int iuser = loginUser.getIuser();
		return iuser;
	}
	
	public static UserEntity getLoginUser(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		HttpSession hs = request.getSession();
		return (UserEntity) hs.getAttribute("loginUser");
	}
	
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
	 
	public static void openJSP(String title,String jsp,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("title", title);
		req.setAttribute("jsp", jsp);
		
		String temp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(temp).forward(req, res);
	}
	
	

}
