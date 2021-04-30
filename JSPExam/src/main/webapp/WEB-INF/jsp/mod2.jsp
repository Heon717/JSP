<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.koreait.JSPExam.*" %>
    <% 
    	String no = request.getParameter("no"); 
    	BoardVO2 vo = (BoardVO2) request.getAttribute("abc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모드</title>
</head>
<body>
	<h1>글 수정</h1>
	<form action="/mod2" method="post">
		<div>
			제목 : <input type="text" name= "title" value="<%=vo.getTitle()%>">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10" ><%=vo.getCtnt()%></textarea>
		</div>
		<div>
			<button>글수정</button>
		</div>
	</form>
</body>
</html>