<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트</title>
</head>
<body>
	<div>
		<input type="text" id="num1" value="">
		<br>
		<input type="text" id="num2" value="">
		<button onclick="sum()">더하기</button>
		<button onclick="minus()">빼기</button>
	</div>
	<div>
	<input type="text" id="result">
	</div>
	
	<script>
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2');
		var resultElem = document.querySelector('#result');
		var num1 = num1Elem.value;
		var num2 = num2Elem.value;

		function sum() {
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			var num3 = Number(num1) + Number(num2);
			resultElem.value = num3;
		}
		
		function minus() {
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			var num4 = parseInt(num1) - parseInt(num2);
			resultElem.value = num4;
		}
	</script>
</body>
</html>