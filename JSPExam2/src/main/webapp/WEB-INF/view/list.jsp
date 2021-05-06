<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table,tr,th,td { border-top: 1px solid gray;
					 border-bottom: 1px solid gray;
					 border-collapse: collapse;
					 padding: 10px;}
	input{ margin: 20px;}
	#kbs{
		float: right;
	}
	
	.abc1 {
		background: #FBFBFB;
	} 
	
	.abc1>th:nth-child(2){
		width: 500px;
	}
	
	.abc2 {
		cursor: pointer;
	}
	.abc2:hover {
		background: #ecf0f1;
	}
	.abc2:active {
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
	
	#header{
		height: 150px;
	}
	
	#header>img {
		position: relative;
		left:800px;
	}
	
	
	#tb_list{
		padding-left: 600px;
	}
</style>
<title>리스트</title>
</head>
<body>

	<div id="header">
		<div id="kbs">
			<a href="/join"><button>회원가입</button></a>
			<a href="/login"><button>로그인</button></a>
			<select>
				<option>한국어</option>
				<option>중국어</option>
				<option>일본어</option>
				<option>영어</option>
			</select>
		</div>
		<img src="../../images/title.jpg">
	</div>
	<div id="tb_list">
		<table>
			<tr class="abc1">
				<th>게시글 번호</th>
				<th>제목</th>
				<th>게시글 등록시간</th>
			</tr>
		
		<c:forEach var="item" items="${list}">
			<tr class="abc2" onclick="mouseclick(${item.num})">
				<td>${item.num}</td>
				<td>${item.title}</td>
				<td>${item.rg}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="/write"><input type="submit" value="글쓰기"></a>
	</div>

	<script>
		function mouseclick(num) {
			location.href = "/detail?num="+num;
		}
	</script>
</body>
</html>