<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.his.cms.util.IConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<link href="/js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/js/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="/js/uploadify/jquery.uploadify.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#uploadify").uploadify({
					'auto'           : false,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/json/upload.action?type="<%=IConstants.IMAGE_TYPE_NEWS%>"',
					'buttonText'	 : '选择图片',
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
           				document.getElementById('f1').contentWindow.location.reload();
        			}
				});
			});	
			
			function selectImg(images){
				$(images).each(function(){
					window.opener.tinyMCE.activeEditor.setContent(window.opener.tinyMCE.getInstanceById("text").getBody().innerHTML + "<img src='"+$(this).attr("src")+"'/>");
				});
			}
		</script>
	</head>
	<body>
		<div class="alert alert-success hide" style="width: 350px;" id="msg_succ">操作成功</div>
		<div class="alert alert-error hide" style="width: 350px;" id="msg_err"><a class="close">×</a><span id="text_err">操作失败</span></div>
		<div class="thumbnail" style="margin:25px;">
			<legend>图片上传</legend>
			<input type="file" name="uploadify" id="uploadify" />
			<a href="javascript:$('#uploadify').uploadify('upload','*')">图片上传</a>
		</div>
		<div style="margin:25px;">
			<iframe id="f1" src="/admin/news_showImage.action" width="100%" height="350" frameborder="0"></iframe>
		</div>
	</body>
</html>