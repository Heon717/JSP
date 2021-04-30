<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.koreait.board.BoardVO" %>
    <% 
    	String no = request.getParameter("no"); 
    	BoardVO vo = (BoardVO) request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<style>
	div {background-color: beige;}
</style>
<head>
<meta charset="UTF-8">
<title>모드</title>
</head>
<body>
	<h1>글수정</h1>
	<form action="/mod" method="post">
		<input type="hidden" name="no" value="<%=no %>">
		<div>
			제목 : <input type="text" name= "title" value="<%=vo.getTitle()%>">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10" ><%=vo.getCtnt()%></textarea>
		</div>
		<div>
			<input type="submit" value="글수정">
		</div>
	</form>
</body>
</html>