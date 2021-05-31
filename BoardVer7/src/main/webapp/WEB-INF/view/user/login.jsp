<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>${requestScope.errMsg}</div>
<div>
	<div>${err}</div>
	<form action="login" method="post">
		<div><input type="text" placeholder="아이디" name="uid"></div>
		<div><input type="password" placeholder="비밀번호" name="upw"></div>
		<div>
			<input type="submit" value="로그인">
		</div>
	</form>
	<div>
		<a href="join">회원가입</a>
	</div>
</div> 
