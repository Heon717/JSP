var cmtFormElem = document.querySelector('#cmtForm');	

function regCmt() {
	var cmtVal = cmtFormElem.cmt.value;
	
	var param = {
		iboard: cmtFormElem.dataset.iboard,
		cmt: cmtVal
	};
	
	regAjax(param);
}

// 서버에게 등록을 요청
function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};

	fetch('cmtInsSel', init)
	.then(function(res){
		return res.json();
	}) //(res),(myJson) 익명함수
	.then(function(myJson){
		console.log(myJson); 
		switch(myJson.result) {
			case 0:
				alert('등록 실패!');
				break;
			case 1:
				alert('등록 성공!');
				break;
		}
	})
}

// 서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
	var iboard = cmtFormElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard='+iboard)
	.then(function(res){
		return res.json();
	})
	.then((myJson) => console.log(myJson))
}

getListAjax(); // 이 파일이 임폴트 되면 함수 1회 호출