var formElem = document.querySelector('#form');
var	uidElem = formElem.uid; // formElem . 뒤에는 name 이나 id/class 가능
var upwElem = formElem.upw;
var chkUpwElem = formElem.chkUpw;
var unmElem = formElem.unm;
var chkUidResultElem = formElem.querySelector('#chkUidResult');

var btnChkIdElem = formElem.btnChkId; // 중복 ID 체크버튼
// btnChkIdElem.onclick = function() { ddd() };  html 에서 onclick 하는거랑 같음
btnChkIdElem.addEventListener('click',function(){
	idChkAjax(uidElem.value);
});

function idChkAjax(uid) {
	console.log(uid);
	
	// fetch(usl , [options]) 옵션을 따로 설정안하면 get방식으로 컨텐츠가 다운로드됨
	fetch('/user/idChk?uid='+uid).then(function(res){
		return res.json();
	}).then(function(myJson){ // myJson == response.getWriter().append() 부분내용이 뜸
		console.log(myJson);
		switch(myJson.result) {
			case 0:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';
			break;
			case 1:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 없습니다.';
			break;
		}
	});
}

function formChk() {
	var uidVal = uidElem.value;
	if(uidVal.length == 0 ) {
		alert('아이디를 작성해 주세요');
		return false;
	} else if (uidVal.length <= 2) {
		alert('아이디는 3자 이상 작성해 주세요');
		return false;
	}
	
	var upwVal = upwElem.value;
	var chkUpwVal = chkUpwElem.value;
	if(upwVal.length < 3) {
		if(upwVal.length == 0) {
			alert('비밀번호를 작성해주세요.');
		} else {
			alert('비밀번호를 4자 이상 작성해주세요.')
		}
		return false;
	} else 	if (upwVal != chkUpwVal) {
		alert('비밀번호를 확인해 주세요');
		return false;
	}
}