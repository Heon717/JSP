<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<title>로그인</title>
</head>
<body>
	<div id= "wrap">
		<img id = "main_logo" src="../../images/blizzard.jpg">
		<div class="errMsg">${err}</div>
		<div>
			<form action="login" method="post">
				<div><input id ="id" type="text" name="uid" placeholder="아이디"></div>
				<div><input id ="pw" type="password" name="upw" placeholder="비밀번호"></div>
				<div><input id="btn1" type="submit" value="로그인"></div>
			</form>
		</div>
		<div id = "content">
			<div >
				<span class = "line_left"></span>
				<span class = "line_text">또는</span>
				<span class = "line_right"></span>
			</div>
			<span id = "leng_logo">
				<a href="#" onclick="leng_ko()"><img class = "leng_logo_1" src="../../images/ico_kr.png"></a>
				<a href="#" onclick="leng_us()"><img class = "leng_logo_2" src="../../images/ico_us.png"></a>
				<a href="#" onclick="leng_cn()"><img class = "leng_logo_3" src="../../images/ico_cn.png"></a>
			</span>
			<div>
				<a href="join"><input id="btn2" type="button" value="블리자드 무료 회원 가입"></a>
			</div>
			<div id = "text_id">
				<a href="#">로그인 문제 해결</a>
			</div>
			<div id = "text_id">
				<a href="#">탈퇴한 계정 복구</a>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function leng_ko() {
			document.getElementById('id').placeholder = "아이디";
			document.getElementById('pw').placeholder = "비밀번호";
			document.querySelector('#button1').value = "로그인";
			document.getElementByclassName('line_text').innerHTML = "또는";
			document.querySelector('#button2').value = "블리자드 무료 회원 가입";
			document.getElementById('button').value = "로그인 문제 해결";
			document.getElementById('button').value = "탈퇴한 계정 복구";
		}
		
		function leng_us() {
			document.getElementById('id').placeholder = "ID";
			document.getElementById('pw').placeholder = "PASSWORD";
			document.querySelector('#button1').value = "Login";
			document.getElementByclassName('line_text').innerHTML = "OR";
			document.querySelector('#button2').value = "Blizzard Free Membership";
			document.getElementById('button').value = "Troubleshooting Login";
			document.getElementById('button').value = "Recover accounts you left";
		}
		
		function leng_cn() {
			document.getElementById('id').placeholder = "用戶名";
			document.getElementById('pw').placeholder = "密碼";
			document.querySelector('#button1').value = "登錄";
			document.getElementByclassName('line_text').innerHTML = "或";
			document.querySelector('#button2').value = "暴雪免費加入會員";
			document.getElementById('button').value = "解決登錄問題";
			document.getElementById('button').value = "恢復退出賬戶";
		}
	</script>

</body>
</html>