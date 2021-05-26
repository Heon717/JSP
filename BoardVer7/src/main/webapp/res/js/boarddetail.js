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
				cmtFormElem.cmt.value = '';
				getListAjax();
				break;
		}
	})
}

// 서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
	var iboard = cmtFormElem.dataset.iboard;
								// 디테일.jsp 에서 data-iboard의 데이터를 가져옴
	fetch('cmtInsSel?iboard='+iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		makeCmtElemList(myJson);
	})
}

function makeCmtElemList(data) {
	var cmtListElem = document.querySelector('#cmtList');
	cmtListElem.innerHTML = '';
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
	
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';
	
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
	
	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);
	
	var loginUserPK = cmtFormElem.dataset.loginUser_PK;   
									// data-이름 을 사용하면 js에서 dataset.이름 으로 값을 불러올수있다.
									//여기서 loginUserPk = 디테일.jsp에 data-loginUserPK
	
	data.forEach(function(item){
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
		
		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		
		
		if(parseInt(loginUserPK) === item.iuser) { // 아이디가 같을때 생기는 버튼부분
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			delBtn.addEventListener('click',function(){
				delAjax(item.icmt);
			});
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		tableElem.append(trElemCtnt);
	})
}
function delAjax(icmt){
	fetch('cmtDelUpd?icm='+icmt).then(function(res){
		return res.json;
	}).then(function(data){
		console.log(data);
		
		switch(data.result) {
			case 0:
				alert('댓글 삭제 실패!');
			break;
			case 1:
				getListAjax();
			break;
		}
	});
}

getListAjax(); // 이 파일이 임폴트 되면 함수 1회 호출
