var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm')

function moveToDetail(iboard) {
	location.href = '/board/detail?iboard='+iboard;
}

function delCmt(iboard, icmt) {
	// 여기서 $은 EL 식이아님
	// 예 = true  / 아니오 = false
	if(confirm('삭제하시겠습니까?')){
		location.href=`/board/regCmt?icmt=${icmt}&iboard=${iboard}`;
	} // location은 GET 방식으로 간다.
	console.log(iboard, icmt);
}

function updCmt(icmt, cmt) {
	updFrmElem.icmt.value = icmt;
	updFrmElem.cmt.value = cmt;
	
	insFrmElem.className = 'hidden';
	updFrmElem.className = '';
}
function showInsFrm() {
	insFrmElem.className = '';
	updFrmElem.className = 'hidden';
}

