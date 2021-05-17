<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<script type="text/javascript" defer src="/res/js/boardList.js"></script>
<link rel="stylesheet" type="text/css" href="/res/css/boardList.css">
</head>
<body>
	<div>${loginUser.uid} (${loginUser.unm}님) 환영합니다 !</div>
	<div><a href="/user/logout">로그아웃</a></div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>글쓴이</th>
				<th>제목</th>
				<th>시간</th>
			</tr>
			<c:forEach var="i" items="${list}">
			<tr class = "record" onclick="moveToDetail(${i.iboard})">
				<td>${i.iboard}</td>
				<td>${i.unm}</td>
				<td>${i.title}</td>
				<td>${i.regdt}</td>
			</tr>
			</c:forEach>
		</table>
		<a href="write">글작성하기</a>
	</div>
	
</body>
</html>