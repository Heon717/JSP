function moveToDetail(iboard) {
	location.href = '/board/detail?iboard='+iboard;
}

function delCmt(iboard,icmt) {
	// 여기서 $은 EL 식이아님
	// 예 = true  / 아니오 = false
	if(confirm('삭제하시겠습니까?')){
		location.href=`/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	} // location은 GET 방식으로 간다.
}