<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/write.css">
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div id = "wrap">
		<h1>글쓰기</h1>
		<div>
			<form action="write" method="post">
				<div><input type="text" name="title"></div>
				<div><textarea name="ctnt"></textarea></div>
				<div>
					<input id="button" type="submit" value="글쓰기">
					<input id="button" type="reset" value="초기화">
				</div>
			</form>
		</div>
	</div>
</body>
</html>