<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.his.cms.util.IConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理</title>
		<link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<link href="/js/uploadify/uploadify.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="/js/uploadify/jquery.uploadify.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$("#uploadify").uploadify({
					'auto'           : true,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/json/upload_single_image.action;jsessionid=<%=request.getSession().getId()%>?type=<%=IConstants.IMAGE_TYPE_AD%>',
					'buttonText'	 : '选择图片',
					'multi'			 : false,
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
						data = eval('('+data+')');
						alert(data.image.id);
        			}
				});
			});
		</script>
	</head>
	<body>
    <div class="row">
	    <div class="span12">
		    预留位置
		    <div class="row">
			    <div class="span3">
			    	 <%@ include file="/page/include/menu.jsp" %>
			    </div>
			    <div class="span9">
			    	<div class="navbar">
			    		<div class="navbar-inner">
								<div class="container">
								<a href="javascript:void(0);" class="brand">菜单管理 >> <s:if test="ad==null || ad.id==0">新增</s:if><s:else>编辑</s:else></a>
							</div>
						</div>
			    	</div>
			    	<div>
					    <form class="form-horizontal" method="post" action="/admin/<s:if test="ad.id==0">ad_save.action</s:if><s:else>ad_update.action</s:else>">
					    	<input type="hidden" name="id" value="${ad.id}"/>
					    	<input type="hidden" name="imgId" value="${ad.imgId}"/>
						    <fieldset>
								<div class="control-group">
							   		<label class="control-label">标题</label>
								    <div class="controls">
									    <input type="text" class="input-xlarge" placeholder="请输入标题" name="title" value="${ad.title}"/>
								    </div>
							    </div>
								<div class="control-group">
								    <label class="control-label">图片</label>
								    <div class="controls">
									    <input type="file" name="uploadify" id="uploadify" />
								    </div>
							    </div>
							    <label class="control-label" for="input01">是否显示</label>
							    <div class="controls">
					              <label class="radio"><input name="isShow" value="0" <s:if test="ad.isShow==0">checked=""</s:if> type="radio">显示</label>
					              <label class="radio"><input name="isShow" value="1" <s:if test="ad.isShow==1">checked=""</s:if> type="radio">隐藏</label>
							    </div>
							    <div class="controls" style="padding-top:10px;">
							    	<button class="btn btn-primary" type="submit">确定</button>
							    	<a href="/admin/ad_list.action" class="btn">返回</a>
							    </div>
						    </fieldset>
					    </form>
			    	</div>
			    </div>
		    </div>
	    </div>
    </div>
	</body>
</html>
