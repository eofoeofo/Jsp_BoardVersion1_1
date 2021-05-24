function ajax(iboard){
	const param ={iboard}
	const init = {
		method: 'POST',
		body: new URLSerachParams(param)
	}
	fetch('/board/detail,' init)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		setData(myJson);
	});
}
function setData(data) {
	var iboardElem = document.querySelector('#iboard');
	var titleElem = document.querySelector('#title');
	var regdtElem = document.querySelector('#regdt');
	var ctntElem = document.querySelector('#ctnt');
	iboardElem.innerText = data.iboard;
	titleElem.innerText = data.title;
	regdtElem.innerText = data.regdt;
	ctntElem.innerText = data.ctnt;
}
ajax(${param.iboard});