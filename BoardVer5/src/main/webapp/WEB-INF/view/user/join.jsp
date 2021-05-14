<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<form action="join" method="post">
			<div>아이디 : <input type="text" name="id"></div>
			<div>비밀번호 : <input type="text" name="pw"></div>
			<div>이름 : <input type="text" name="nm"></div>
			<div>여<input type="radio" name="gender" value="0" checked></div>
			<div>남<input type="radio" name="gender" value="1"></div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>