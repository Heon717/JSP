<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table,tr,th,td { border: 1px solid gray;
					 border-collapse: collapse;
					 padding: 10px;}
	input{ margin: 20px;}
	
	.abc {
		cursor: pointer;
	}
	.abc:hover {
		background: #ecf0f1;
	}
	.abc:active {
		background: #dcf9f9;
	}
	
	tr>td:first-child {
		text-align: center;
		color: pink;
	}
	
	tr>td:nth-child(2){
		text-align: center;
		font-size: 16px;
		font-weight: bold;
	}
	
	
	tr>td:last-child {
		text-align: center;
		font-size: 12px;
		color: skyblue;
	}
</style>
<title>리스트</title>
</head>
<body>
	<h1>리스트</h1>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>게시글 등록시간</th>
		</tr>
		
		<c:forEach var="item" items="${list}">
			<tr class="abc" onclick="mouseclick(${item.num})">
				<td>${item.num}</td>
				<td>${item.title}</td>
				<td>${item.rg}</td>
			</tr>
		</c:forEach>

	</table>
		<a href="/write"><input type="submit" value="글쓰기"></a>
	<script>
		function mouseclick(num) {
			location.href = "/detail?num="+num;
		}
	</script>
</body>
</html>