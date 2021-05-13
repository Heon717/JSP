<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div id="wrap">
		<form action="write" method="post">
			<div>제목 : <input type="text" name="title"></div>
			<div>내용 : <textarea cols="30" rows="10"></textarea></div>
			<div><input type="submit" value="작성하기"></div>
		</form>
			<a href="list"><button>돌아가기</button></a>
	</div>
</body>
</html>