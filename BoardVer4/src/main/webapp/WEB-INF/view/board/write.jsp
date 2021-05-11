<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body{
	background-image: url('../../images/sea.jpg');
	}

	#wrap{
	background:linear-gradient(to bottom, #4b79a1, #283e51);
	position: absolute;
	top:20%;
	left: 20%;
	box-sizing: border-box;
	}

	input, textarea {
	width: 460px;
	height : 48px;
	margin: 10px;
	}
	
	input:hover{
	cursor: pointer;
	}

	#button {
	margin: 15px;
	width:460px;
	height:56px;
	border: 1px solid skyblue;
	background-color:rgba(0,0,0,0);
	color: skyblue;
	padding:10px;
	border-radius: 6px;
	cursor: pointer;
	}
	
	#button:hover{
	background-color:skyblue;
	color:white;
	}
	
	#button:active{
	background-color: #82b5f0 ;
	}
	</style>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div id = "wrap">
		<h1>글쓰기</h1>
		<div>
			<form action="write" method="post">
				<div><input type="text" name="title" placeholder="제목"></div>
				<div><textarea name="ctnt"></textarea></div>
				<div>
					<input id="button" type="submit" value="글쓰기">
					<input id="button" type="reset" value="초기화">
				</div>
			</form>
		</div>
	</div>
</body>
</html>