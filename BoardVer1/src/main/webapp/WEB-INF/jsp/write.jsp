<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	div {background-color: beige;}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/write" method="post">
		<div id="div1">
			제목 : <input type="text" name= "title">
		</div>
		<div id="div1">
			내용 : <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기">
			<input type="reset" value= "초기화">
		</div>
	</form>
</body>
</html>