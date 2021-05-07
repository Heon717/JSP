<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#login_id:focus, #login_pw:focus {
		background-color:"#fafafa";
		border:"1px solid #e9e9e9";
	}
</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>
		<form action="/login" method="post">
			<h1>로그인 화면</h1>
	
			<div><label>아이디 <input type="text" name="id" id="login_id" placeholder="아이디" required></label></div>
		
			<div><label>비밀번호 <input type="text" name="pw" id="login_pw" placeholder="비밀번호" required></label></div>
		
			<button>로그인</button>
		</form>
	</div>
		<script>
		function id_hide() {
			document.getEementById('login_id').style.background-color="#fafafa";
			document.getEementById('login_id').style.border="1px solid #e9e9e9";

		}
		
		function pw_hide() {
			document.getEementById('login_pw').style.background-color="#fafafa";
			document.getEementById('login_pw').style.border="1px solid #e9e9e9";
		}
	</script>
</body>
</html>