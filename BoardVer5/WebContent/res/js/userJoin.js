var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var unmElem = frmElem.unm;
var chkUpwElem = frmElem.chkUpw;
var btnChkIdElem = frmElem.btnChkId;
var chkUidResultElem = frmElem.querySelector('#chkUidResult');

btnChkIdElem.addEventListener('click',function(){
	idChkAjax(uidElem.value);
});

function idChkAjax(uid){
	console.log(uid);
	fetch('/user/idChk?uid='+uid)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		switch(myJson.result){
			case 0:
				chkUidResultElem.innerText = '이 아이디는 사용 할 수 있습니다.';
				break;
			case 1:
				chkUidResultElem.innerText = '이 아이디는 사용 할 수 없습니다.';
				break;
		}
	});
}
function frmChk() {
	var uidVal = uidElem.value;
	if(uidVal.length < 3){
		if(uidVal.length == 0){
			alert('아이디를 입력 해 주세요.');
		} else {
			alert('아이디는 2자 이상 입력 해 주세요.');
		} return false;
	}
	var upwVal = upwElem.value;
	var chkUpwVal = chkUpwElem.value;
	if(upwVal.length < 4){
		if(upwVal.length == 0){
			alert('비밀번호를 입력 해 주세요.');
		} else {
			alert('비밀번호는 4자 이상 입력 해 주세요.');
		} return false;
	} else if(upwVal != chkUpwVal){
		alert('비밀번호를 확인 해 주세요.');
		return false;
	}
	if(unmElem.value.length < 2){
		alert('이름은 2자 이상 입력 해 주세요.');
		return false;
	}
}