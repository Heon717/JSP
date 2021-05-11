<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	

	#form{
	background:linear-gradient(to bottom, #4b79a1, #283e51);
	position: absolute;
	top:20%;
	left: 40%;
	box-sizing: border-box;
	}

	form>div>input {
	width: 460px;
	height : 48px;
	margin: 10px;
	}

	#button {
	margin-left: 20px;
	margin: 15px;
	width:460px;
	height:56px;
	border: 1px solid skyblue;
	background-color:rgba(0,0,0,0);
	color: skyblue;
	padding:10px;
	border-radius: 6px;
	cursor: pointer;
	}
	
	#button:hover{
	background-color:skyblue;
	color:white;
	}
	
	#button:active{
	background-color: #82b5f0 ;
	}
	
	#radio{
		color:white;
		margin-left: 20px;
	}
</style>
<title>회원가입</title>
</head>
<body>
	<div id = "wrap">
		<form id = "form" action="join" method="post">
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="password" name="upw" placeholder="비밀번호"></div>
			<!-- <div><input type="password" name="upw" placeholder="비밀번호 확인"></div>-->
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div id="radio">
				<label>여성<input type="radio" name="gender" value="0" checked></label>
				<label>남성<input type="radio" name="gender" value="1"></label>
			</div>
			<div><input id="button" type="submit" value="회원가입"></div>
			<div><a href="login"><input id="button" type="button" value="로그인 돌아가기"></a></div>
		</form>
	</div>
</body>
</html>