<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.his.cms.util.IConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<link href="/js/uploadify/uploadify.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/js/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="/js/uploadify/jquery.uploadify.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#uploadify1,#uploadify2").uploadify({
					'auto'           : true,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/json/upload_single_image.action;jsessionid=<%=request.getSession().getId()%>?type=<%=IConstants.IMAGE_TYPE_WEBSITE_BANNER%>',
					'buttonText'	 : '选择图片',
					'multi'			 : false,
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
						data = eval('('+data+')');
						$("#topImg").val(data.image.saveFile);
						$("#topImgShow > img").remove();
						$("#topImgShow").append('<img style="height:150px;" src="/upload/'+data.image.saveFile+'"/>');
					}
				});
				$("#uploadify2").uploadify({
					'auto'           : true,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/json/upload_single_image.action;jsessionid=<%=request.getSession().getId()%>?type=<%=IConstants.IMAGE_TYPE_WEBSITE_BANNER%>',
					'buttonText'	 : '选择图片',
					'multi'			 : false,
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
						data = eval('('+data+')');
						$("#bottomImg").val(data.image.saveFile);
						$("#bottomImgShow > img").remove();
						$("#bottomImgShow").append('<img style="height:150px;" src="/upload/'+data.image.saveFile+'"/>');
					}
				});
				
				<s:if test="webSite.topImg!=null&&webSite.topImg!=''">
				$("#topImgShow").append('<img style="height:150px;" src="/upload/${webSite.topImg}"/>');
				$("#div_top_img").show();
				</s:if>
				<s:if test="webSite.bottomImg!=null&&webSite.bottomImg!=''">
				$("#bottomImgShow").append('<img style="height:150px;" src="/upload/${webSite.bottomImg}"/>');
				$("#div_bottom_img").show();
				</s:if>
			});
		</script>
	</head>
	<body>
    <%@ include file="/page/admin/include/top.jsp" %>
    <div class="container">
	    <div class="row">
		    <div class="span3">
		    	 <%@ include file="/page/admin/include/menu.jsp" %>
		    </div>
		    <div class="span12">
		    	<ul class="breadcrumb">
		    	    <li class="active">网站基本信息</li>
		     	</ul>
		    	<div>
		    		<div class="alert alert-error action-error"><a data-dismiss="alert" class="close">×</a><s:actionerror/></div>
				    <form class="form-horizontal" method="post" action="/admin/webSite_update.action">
					    <fieldset>
							<div class="control-group">
						   		<label class="control-label"><span class="required-input">*</span>网站标题</label>
							    <div class="controls">
								    <input type="text" class="input-xxlarge" placeholder="请输入网站名称" name="title" value="${webSite.title}"/>
							    </div>
						    </div>
							<div class="control-group">
							    <label class="control-label">网站描述</label>
							    <div class="controls">
								    <textarea rows="3" class="input-xxlarge" placeholder="请输入网站描述 " name="description">${webSite.description}</textarea>
							    </div>
						    </div>
							<div class="control-group">
							    <label class="control-label">网站关键词</label>
							    <div class="controls">
								    <input type="text" class="input-xxlarge" placeholder="请输入网站关键词" name="keywords" value="${webSite.keywords}"/>
							    </div>
						    </div>
						    <div class="control-group" id="div_top_img">
						    	<input type="hidden" name="topImg" id="topImg" value="${webSite.topImg}"/>
							    <label class="control-label"><span class="required-input">*</span>顶部banner背景图</label>
							    <div class="controls">
								    <input type="file" name="uploadify1" id="uploadify1"/>最佳尺寸：宽=1146px 高=152px
							    	<div class="data-list">
										<ul class="thumbnails">
											<li class="span3" id="topImgShow"></li>
										</ul>
				    				</div>
							    </div>
						    </div>
						    <div class="control-group" id="div_bottom_img">
						    	<input type="hidden" name="bottomImg" id="bottomImg" value="${webSite.bottomImg}"/>
							    <label class="control-label"><span class="required-input">*</span>底部banner背景图</label>
							    <div class="controls">
								    <input type="file" name="uploadify2" id="uploadify2"/>最佳尺寸：宽=1146px 高=119px
							    	<div class="data-list">
										<ul class="thumbnails">
											<li class="span3" id="bottomImgShow"></li>
										</ul>
				    				</div>
							    </div>
						    </div>
						    <div class="controls" style="padding-top:10px;">
						    	<button class="btn btn-primary" type="submit">确定</button>
						    	<a href="/admin/menu_list.action" class="btn">返回</a>
						    </div>
					    </fieldset>
				    </form>
		    	</div>
		    </div>
	    </div>
    </div>
	</body>
</html>
