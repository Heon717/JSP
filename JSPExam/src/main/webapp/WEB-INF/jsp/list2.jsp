<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.JSPExam.*" %>
<% List<BoardVO2> list = (List<BoardVO2>)request.getAttribute("abc"); %>

<!DOCTYPE html>
<html>
<style>
	table,th,td {
		border: 1px solid gray;
		border-collapse:collapse;
	}
</style>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h1>리스트</h1>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
		</tr>

		<% for(int i=0; i<list.size(); i++) { %>
		<tr>
			<td id="idx"><%= i %></td>
			<td>
				<a href="/detail2?no=<%=i%>"><%= list.get(i).getTitle()%></a>
			</td>
		</tr>
		<% } %>
	</table>
	<div>
		<a href="/write2"><input type="button" value="글쓰기"/></a>
	</div>
</body>
</html> 