package com.koreait.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.user.UserVO;

public class MyUtils {
	public static int getLoginUserPK(HttpServletRequest requset) {
		UserVO loginUser = getLoginUser(requset);
		int iuser = loginUser.getIuser();
		return iuser;
	}
	
	public static UserVO getLoginUser(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		HttpSession hs = request.getSession();
		return (UserVO) hs.getAttribute("loginUser");
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
	
	public static void openJSP(String fileNm,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/"+fileNm+".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
		
	}
}
