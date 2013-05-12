$(function() {
	showSuccMsg();
	$(".close").click(function() {
		$(".alert").slideUp();
		setTimeout("$('.alert').remove()",2000);
	});
	if ($(".alert").text().length<=1){
		$(".alert").hide();
	}
	$(".btn-group > button").click(function(){
		goAction('/admin_lang.action?lang=' + $(this).attr("data-lang"));
	});
});
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
	if (operTag != null) {
		createAlert(operTag);
		$(".alert").slideDown();
		if (operTag == 'succ'){
			setTimeout("$('.alert').slideUp();",2000);
		//	setTimeout("$('.alert').remove()",2500);
		}
	}
}

function createAlert(tag){
	var alertHtml = null;
	if (tag == "succ") {
		alertHtml = '<div class="alert alert-success" style="top:0px;margin-bottom:3px;position: absolute; width:35%;margin-left: 609px;"><a data-dismiss="alert" class="close">×</a>操作成功</div>';
	} else {
		var msg = null;
		if ('hasNews'==tag) {
			msg = '该目录下存在新闻资讯，不能删除，请先移除新闻资讯。';
		}else if ('exsitUsername'==tag) {
			msg = '该用户名已存在。';
		} else {
			msg = '操作失败';
		}
		alertHtml = '<div class="alert alert-error" style="top:0px;margin-bottom:3px;position: absolute; width:100%;"><a data-dismiss="alert" class="close">×</a>'+msg+'</div>';
	}
	$(".span12 > .navbar").append(alertHtml);
}