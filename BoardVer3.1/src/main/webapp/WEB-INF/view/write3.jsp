<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>
		<a href="/list3">돌아가기</a>
	</div>
	<form action="/write3" method="post">
		<div>
			제목: <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="content"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>