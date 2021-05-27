var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');
var cmtUpdModalElem = document.querySelector('#modal');
function regCmt() {
	var CmtVal = cmtFrmElem.cmt.value;
	
	var param = {
				iboard: cmtListElem.dataset.iboard;
				cmt: cmtVal
	};
				regAjax(param);
}
// 댓글 등록 Ajax
function regAjax(param) {
	const init = {
				 method: 'POST';
				 body: new URLSearchParams(param)
				 };
			
		 fetch('cmtInsSel',init)
	
		 .then(function(res){
			return res.json();
		 })
	
		 .then(function(myJson){
			
		 	switch(myJson.result){
			case 0:
				alert('등록 실패');
				break;
			case 1:
				cmtFrmElem.cmt.value='';
				getListAjax();
				break;
		}
	});
}