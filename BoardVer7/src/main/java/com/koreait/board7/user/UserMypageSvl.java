package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMypageSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getServletContext().getRealPath("res/img");
		int maxFileSize = 10_485_760; // 10 * 1024 * 1024 (10mb)
		
		System.out.println(uploadPath);
		
		MultipartRequest multi =  new MultipartRequest(request,
				uploadPath+"/temp",
				maxFileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		int loginUserPk = MyUtils.getLoginUserPK(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder);
	
		folder.mkdirs(); // mkdir은 무조건 폴더하나만 만들어줌 그래서 mkdirs 쓰는게 좋음
		
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println("fileNm: " + fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf(".");
		String ext = fileNm.substring(lastDotIdx); // 확장자 구함
		
		String newFileNm = UUID.randomUUID().toString() + ext; // 이름을 랜덤으로 바꿈
													// UUID : 범용 고유 식별자 
		
		File imgFile = new File(uploadPath +"/tmep/"+fileNm);
		imgFile.renameTo(new File(targetFolder+"/"+ newFileNm));
		
		doGet(request, response);
	}

}
