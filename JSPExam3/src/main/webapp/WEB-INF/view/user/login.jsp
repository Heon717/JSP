<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../../css/login.css">
</head>
<body>
	<h1>로그인</h1>
	<div id = "wrap">
		<form action="login" method="post">
			<div><input type="text" name="id" placeholder="아이디를 입력해 주세요."></div>
			<div><input type="text" name="pw" placeholder="비밀번호를 입력해 주세요."></div>
			<div><input type="submit" name="login_btn" value="로그인"></div>
			<div><input type="radio">자동로그인</div>
		</form>
		<div>
			<div>
				<span><a href="join">회원가입</a></span>
				<span></span>
				<span><a href="">아이디 찾기</a></span>
				<span></span>
				<span><a href="">비밀번호 찾기</a></span>
			</div>
			<div>
				카카오 로그인
			</div>
			<div>
				Apple로 로그인
			</div>
		</div>
		<div>
			
		</div>
		<footer>
			
		</footer>
	</div>
</body>
</html>