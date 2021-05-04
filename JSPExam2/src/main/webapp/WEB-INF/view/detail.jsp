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
<title>디테일</title>
</head>
<body>
	<div>
		<div> 제목 : ${list.title} </div>
		<div> 내용 : ${list.ctnt} </div>
		<div> 작성일 : ${list.rg} </div>
	</div>
	<div>
		<a href="/mod?num=${param.num}"><button>수정하기</button></a>
		<a href="/del?num=${param.num}"><button>삭제</button></a>
		<a href="/list"><button>리스트</button></a>
	</div>
</body>
</html>