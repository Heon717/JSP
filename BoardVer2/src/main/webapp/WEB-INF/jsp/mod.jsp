<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모드</title>
</head>
<body>
	<h1>글쓰기</h1>
	<div>
		<a href="/list">돌아가기</a>
		<form action="/mod?no=${param.no}" method="post">
			<!--  <input type="hidden" name="no" value="${param.no}">-->
			<div>제목 : <input type="text" name="title" value="${vo.title}"></div>
			<div>내(안의 흑염)용 : <textarea name="ctnt" rows="10" cols="10">${vo.ctnt}</textarea></div>
			<div>
					<input type="submit" value="수정완료">
			</div>
		</form>
	</div>

</body>
</html> 