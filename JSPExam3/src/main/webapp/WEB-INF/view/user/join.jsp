<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div id ="wrap">
		<form action="join" method="post">
			<div>아이디<input type="text" name="id" placeholder="아이디 입력 (5~11자)"></div>
			<div>비밀번호<input type="text" name="pw" placeholder="비밀번호"></div>
			<div><input type="text" name="" placeholder="비밀번호확인"></div>
			<div><input type="text" name="name" placeholder="이름"></div>
			<div>남<input type="radio" name = "gender" value="0" checked></div>
			<div>여<input type="radio" name = "gender" value= "1"></div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>