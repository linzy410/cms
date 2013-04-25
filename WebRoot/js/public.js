function goAction(url){
	window.location.href = url;
}

/** show succ or error message  */
function hideMsg(){
	$("#msg_succ").hide();
	$("#msg_err").hide();
}

function showSuccMsg() {
	hideMsg();
	$("#msg_succ").slideDown();
	setInterval("$('#msg_succ').slideUp();",3000);
}
function showErrorMsg(){
	hideMsg();
	$("#msg_err").slideDown();
}
function showErrorMsg(msg){
	hideMsg();
	$("#text_err").html(msg);
	$("#msg_err").slideDown();
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

function showSuccMsg() {
	var operTag = getUrlParam("operTag")
	if (operTag == 'succ' && $(".alert").size() >0){
		$(".alert").slideDown();
		setTimeout("$('.alert').slideUp();",2000);
	}
}