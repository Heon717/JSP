<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body{
		background-image: url('../../images/sea.jpg');
	}

	#wrap{
	background:linear-gradient(to bottom, #4b79a1, #283e51);
	position: absolute;
	top:20%;
	left: 40%;
	box-sizing: border-box;
	}
	
	img {
		margin-left: 100px;
	}

	input {
	width: 460px;
	height : 48px;
	margin: 10px;
	}
	
	input:hover{
	 cursor: pointer;
	}

	#button {
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
	
	.errMsg {
		color:white;
		font-size: 16px;
		text-align: center;
		padding:20px;
	}
	
	#line{
	background-color: gray;
	width: 460px;
	height: 1px;
	margin-left: 15px;
	}
	
	#login_on{
		margin-bottom: 10px;
	}
	
	.cls1{
	color: white;
	margin:15px;
	}
	
	.cls2{
	color: white;
	float: right;
	margin-right: 24px;
	}
	
	.easy_login{
		margin-top:30px;
		margin-bottom:20px;
		font-weight: bold;
		font-size: 24px;
		color:white;
		text-align: center;
	}
	.login_box{
		display:inline-block;
		border: 1px solid #03C75A;
		background-color: white;
		font-weight: bold;
		margin:2px;
		width:226px;
		height: 56px;
		box-sizing: border-box;
		padding-top:15px;
		text-align: center;
	}
	
	.box_left{
		margin-left: 18px;
	}
	
	.box_right{
		margin-right: 20px;
	}
	
	.login_box:hover {
		cursor: pointer;
	}
	
	.id_pw_join{
		font-size:14px;
		color: gray;
		margin-top:16px;
		margin-left: 120px;
	}
	.ipj:hover{
		cursor:pointer;
	}
	
	.Pillar{
		display:inline-block;
		width:1px;
		height:11px;
		background: gray;
	}
</style>

<title>로그인</title>
</head>
<body>
	<div id= "wrap">
		<div class="errMsg">${err}</div>
		<img src="../../images/blizzard.jpg">
		<div>
			<form action="login" method="post">
				<div><input id ="idpw" type="text" name="uid" placeholder="아이디" onclick="solid()"></div>
				<div><input id ="idpw" type="password" name="upw" placeholder="비밀번호" onclick="solid()"></div>
				<div><input id="button" type="submit" value="로그인"></div>
			</form>
		</div>
		<div>
			<a href="join"><input id="button" type="button" value="회원가입"></a>
		</div>
		<div id="login_on">
			<span class="cls1">로그인 상태 유지</span>
			<span class="cls2">ip 보안 ON</span>
		</div>
		<div id = "line"></div>
		<div>
			<div class="easy_login">더욱 간편한 로그인</div>
			<span class="login_box box_left">QR코드 로그인</span>
			<span class="login_box box_right">일회용 번호 로그인</span>
			<div class="id_pw_join">
				<span class="ipj">아이디 찾기</span>
				<span class="Pillar"></span>
				<span class="ipj">비밀번호 찾기</span>
				<span class="Pillar"></span>
				<span class="ipj">회원가입</span>
			</div>
		</div>
		<div>
			이미지
		</div>
		<footer>
			주소
		</footer>
	</div>
	
	<script>
		function solid() {
			document.getElementId('idpw').style.border = "1px solid #03C75A";
		}
	</script>
</body>
</html>