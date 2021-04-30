<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<a href="/write">글쓰기</a>
	</div>

	<c:forEach var="i" begin="0" end="${data.size()}">
		<span>${i}</span>
	</c:forEach>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
		</tr>
<!-- foreach var="for문 내부에서 사용할 변수" items="${리스트가 받아올 배열이름}" varStatus="상태용 변수" -->
		<c:forEach var="item" items="${lis}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td><a href="/detail?no=${status.index}">${item.title}</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>