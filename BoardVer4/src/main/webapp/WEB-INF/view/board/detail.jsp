<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div>${param.iboard}</div>
	<div>
		<div>제목 : ${data.title}</div>
		<div>글쓴이 : ${data.unm}</div>
		<div>작성일시 : ${data.regdt}</div>
		<div>내용 : ${data.ctnt}</div>
	</div>
	
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	<a href="list">리스트로 돌아가기</a>
</body>
</html>