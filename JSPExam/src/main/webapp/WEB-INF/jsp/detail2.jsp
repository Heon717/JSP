<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.koreait.JSPExam.*" %>
<% 
	String no = request.getParameter("no");
	BoardVO2 vo = (BoardVO2)request.getAttribute("abc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일 <%= no %></h1>
	<div>
		<a href="/mod2?no=<%=no %>"><button>수정</button></a>
		<a href="/del2?no=<%=no %>"><button>삭제</button></a>
	</div>
	<div> 제목 : <%= vo.getTitle()%></div>
	<div> 내용 : <%= vo.getCtnt()%></div>
</body>
</html>