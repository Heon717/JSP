<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글 쓰기</h1>
	<form action="/write2" method="post">
	<div>
		제목 : <input type="text" name="title">
		내용 : <textarea name="ctnt"rows="10" cols="10"></textarea>
	</div>
	<div>
		<button>저장</button>
		<!-- <input type="submit" value="버튼"> -->
		<input type="reset" value="초기화">
	</div>
	</form>

</body>
</html>