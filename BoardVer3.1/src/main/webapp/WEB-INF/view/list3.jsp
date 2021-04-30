<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table, tr , td 
	{border: 1px solid gray;
	 border-collapse: collapse; }
	 
	 .record {
	 	cursor: pointer;
	 }
	 
	 .record:hover {
	 background: #ecf0f1;
	 }
</style>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>no</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard});">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			// console().log(); (iboard : %d, ibord)
			location.href = '/detail3?iboard='+iboard;
		}
	</script>
</body>
</html>