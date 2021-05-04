<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	button { margin: 10px;
	}
</style>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>
		<form action="/write" method="post">
			<div>제목 : <input type="text" name="title"></div>
			<div>내용 : <textarea rows="10" cols="22" name="ctnt"></textarea></div>
			<div>
				<button>등록하기</button>
				<button type="reset">초기화</button>
				<a href="/list"><button>돌아가기</button></a>
			</div>
		</form>
	</div>
</body>
</html>