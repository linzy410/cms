$(function() {
	showSuccMsg();
	$(".close").click(function() {
		$(".alert").slideUp();
		setTimeout("$('.alert').remove()",2000);
	});
	if ($(".action-error").text().length<=1){
		$(".action-error").hide();
	}
	$(".btn-group > button").click(function(){
		goAction('/admin_lang.action?lang=' + $(this).attr("data-lang"));
	});
});
function goAction(url){
	window.location.href = url;
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
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
		alertHtml = '<div class="alert alert-success" style="top:2px;margin-bottom:3px;position: absolute; width:35%;margin-left: 593px;"><a data-dismiss="alert" class="close">×</a>操作成功</div>';
	} else {
		var msg = null;
		if ('hasNews'==tag) {
			msg = '该目录下存在新闻资讯，不能删除，请先移除新闻资讯。';
		}else if ('exsitUsername'==tag) {
			msg = '该用户名已存在。';
		} else {
			msg = '操作失败';
		}
		alertHtml = '<div class="alert alert-error" style="top:2px;margin-bottom:3px;position: absolute; width:35%;margin-left: 593px;"><a data-dismiss="alert" class="close">×</a>'+msg+'</div>';
	}
	$(".breadcrumb").append(alertHtml);
}