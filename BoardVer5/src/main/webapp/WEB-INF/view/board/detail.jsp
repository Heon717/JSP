<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<script type="text/javascript" defer src="/res/js/boardList.js"></script>
</head>
<body>
	<h1>디테일 페이지 ${param.iboard}</h1>
	<div>
		<div>글 번호 : ${data.iboard}</div>
		<div>글 제목 : ${data.title}</div>
		<div>글쓴이 : ${data.unm}</div>
		<div>글 내용 : ${data.ctnt}</div>
		<div>작성시간 : ${data.regdt}</div>
	</div>
	<c:if test="${loginUser.iuser == data.iuser}">
		<div><a href="mod?iboard=${param.iboard}">수정</a></div>
		<div><a href="del?iboard=${param.iboard}">삭제</a></div>
	</c:if>
	
	<h3>댓글</h3>
	<div>
		<form action="regCmt" method="post">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="it" items="${list}">
			<tr>
				<td>${it.cmt}</td>
				<td>${it.unm}</td>
				<td>${it.regdate}</td>
				<td>
					<c:if test="${loginUser.iuser == it.iuser}">
						<input type="button" value="수정">
						<button onclick="delCmt(${data.iboard},${it.icmt})">삭제</button>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<a href="list">리스트로</a>
</body>
</html>