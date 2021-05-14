<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<div>
		<form action="mod" method="post">
			<div>글번호 : ${param.iboard}<input type="hidden" name="iboard" value="${param.iboard}"></div>
			<div>제목 : <input type="text" name="title" value="${list.title}"></div>
			<div>내용 : <textarea name="ctnt">${list.ctnt}</textarea></div>
			<div><input type="submit" value="글수정"></div>
		</form>
		<a href="detail?iboard=${param.iboard}">뒤로가기</a>
	</div>
</body>
</html>