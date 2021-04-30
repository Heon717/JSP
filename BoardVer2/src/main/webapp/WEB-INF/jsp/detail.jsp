<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>

	<div>제목 : ${data.title}</div> <!-- setAttribute 에서의 data -->
	<div>1. ${data.ctnt}</div>
		<a href="/mod?no=${param.no}"><button>수정하기</button></a>
		<a href="/del?no=${param.no}"><button>삭제</button></a>
</body>
</html>