<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/write.css">
<title>글쓰기</title>
</head>
<body>
	<div id = "wrap">
		<h1>수정</h1>
		<div>
			<form action="mod" method="post">
				<div> 글번호 : <input type="hidden" name="iboard" value="${param.iboard}"></div>
				<div><input type="text" name="title" value="${list.title}"></div>
				<div><textarea name="ctnt">${list.ctnt}</textarea></div>
				<div>
					<input id="button" type="submit" value="수정완료">
					<input id="button" type="reset" value="초기화">
					<a href="detail?iboard=${param.iboard}">뒤로가기</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>