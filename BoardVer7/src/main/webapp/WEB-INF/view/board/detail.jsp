<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/boarddetail.css">

<div><a href="#" onclick="goBack();">리스트로 돌아가기</a></div>
<h1>${requestScope.data.title}</h1>
<div> 글번호 : ${requestScope.data.iboard}</div>
<div> 작성자 : ${requestScope.data.writerNm} | 작성일 : ${requestScope.data.regdt}</div>
<div><c:out value="${requestScope.data.ctnt}"></c:out></div>

<div>
	<form id="cmtForm" onsubmit="return false;">
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt()">
	</form>
</div>
<div id="cmtList" data-logindata="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}">

</div>

<div id="modal" class="displayNone">
	<div class="modal_content">
		<form id="cmtModForm" action="#">
			<input type="hidden" id="icmt">
			<input type="text" id="cmt">
		</form>
		<input type="button" value="댓글 수정" onclick="modAjax()">
		<input type="button" value="취소" onclick="closeModModal()">
	</div>
</div>

<script src="/res/js/boarddetail2.js"></script>
