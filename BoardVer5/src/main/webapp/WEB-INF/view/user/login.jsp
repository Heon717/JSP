<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>${err}</div>
	<div>
		<form action="/user/login" method="post">
			<div><input type="text" placeholder="아이디" name="uid"></div>
			<div><input type="text" placeholder="비밀번호" name="upw"></div>
			<div><input type="submit" value="로그인"></div>
		</form>
		<a href="join">회원가입</a>
	</div> 
</body>
</html>