<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div id = "wrap">
		<div>로그인 성공!</div>
		<div>${loginUser.uid},(${loginUser.unm})님이 접속하였습니다.  </div>
		<table>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성시간</th>
			</tr>
			<tr>
				<td>iboard</td>
				<td>title</td>
				<td>ctnt</td>
				<td>tm</td>
			</tr>
		</table>
		<a href="write"><button>글쓰기</button></a>
		<a href="user/logot"><button>로그아웃</button></a>
	</div>
</body>
</html>