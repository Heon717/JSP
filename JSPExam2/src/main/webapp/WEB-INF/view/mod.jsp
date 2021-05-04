<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모드</title>
</head>
<body>
	<div>
		<form action="/mod" method="post">
			<input type="hidden" name="num" value="${param.num}">
			<div>제목 : <input type="text" name="title" value="${list.title}"></div>
			<div>내용 : <textarea rows="10" cols="22" name="ctnt">${list.ctnt}</textarea></div>
			<div>
				<button>수정하기</button>
				<a href="/list"><button>돌아가기</button></a>
			</div>
		</form>
	</div>
</body>
</html>