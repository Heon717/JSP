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
		<form action="/join" method="post">
			<h1>회원가입</h1>
	
			<div><label>아이디 : <input type="text" name="id" id="id"></label></div>
		
			<div><label>비밀번호 : <input type="text" name="password1" id="pw1"></label></div>
		
			<div><label>비밀번호확인 : <input type="text" name="password2" id="pw2"></label></div>
		
			<button onclick="joinfnc()">가입하기</button>
		</form>
	</div>
	
	<script>
		function joinfnc() {
				if(pw1.value !== pw2.value) {
					alert("비밀번호가 다릅니다.");
				} else if (id.value=="" || pw1.value == "" || pw2.value == "") {
					alert("아이디와 비밀번호를 입력해주세요.");
				}  else {
					alert("회원가입이 완료되었습니다.");
				}
				
		}
	</script>
</body>
</html>