<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<script type="text/javascript" defer src="/res/js/boardList.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css
">
<link rel="stylesheet" type="text/css" href="/res/css/detail.css">
</head>
<body>
	<h1>디테일 페이지 ${param.iboard}</h1>
	<div>
		<div>글 번호 : ${data.iboard}</div>
		<div>글 제목 : ${data.title}</div>
		<div>글쓴이 : ${data.unm}</div>
		<div>글 내용 : ${data.ctnt}</div>
		<div>작성시간 : ${data.regdt}</div>
		<c:if test="${data.isFav eq 0}">
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isFav == 1}">
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</div>
	<c:if test="${loginUser.iuser == data.iuser}">
		<div><a href="mod?iboard=${param.iboard}">수정</a></div>
		<div><a href="del?iboard=${param.iboard}">삭제</a></div>
	</c:if>
	
	<h3>댓글</h3>
	<div>
		<form id="insFrm" action="regCmt" method="post">
		<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		
		<form id="updFrm" action="regCmt" method="post" class="hidden">
		<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="댓글취소" onclick="showInsFrm()">
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
						<input onclick="updCmt(${it.icmt},'${it.cmt}')" type="button" value="수정">
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