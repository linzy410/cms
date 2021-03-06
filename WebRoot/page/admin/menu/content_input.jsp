<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<script type="text/javascript" src="/js/tiny_mce/tiny_mce.js"></script>
		<script type="text/javascript">
			$(function() {
				tinyMCE.init({
	　　				mode : "exact",
					elements : "text,textEn",
					theme : "advanced",
					width : "100%",
					height : "500px",
					force_br_newlines : true,
					convert_urls : false,
					language : "zh-cn",
					
					theme_advanced_toolbar_location : "top",
					theme_advanced_toolbar_align : "left",
					theme_advanced_buttons1 : "bold,italic,underline,strikethrough,sub, sup,justifyleft, justifycenter, justifyright, justifyfull,image,insertimage,link,unlink,cleanup,table,charmap,fontsizeselect,fontselect,forecolor,fullscreen,preview,code",
					theme_advanced_buttons2 : "",
					theme_advanced_buttons3 : "",
					
					plugins : "table, paste,inlinepopups,fullscreen,preview",
			
					setup : function(ed) {
			    		// Add a custom button
			    		ed.addButton('insertimage', {
			    			title: '上传图片',
			    			image: '/img/img_upload.gif',
			    			onclick: function(){
								window.open("/admin/news_uploadImage.action", "", "height=560px,width=900px,top="+(window.screen.height-660)/2+",left="+(window.screen.width-900)/2+",toolbar=no,menubar=no,resizable=yes,scrollbars=yes,location=no, status=no");
			    			}
			    		});
					},
	　　			});
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
				    <li><a href="/admin/menu_list.action">菜单管理</a><span class="divider"> /</span></li>
				    <li class="active">内容编辑</li>
				</ul>
		    	<div>
				    <form class="form-horizontal" method="post" action="/admin/menu_updateContent.action">
				    	<input type="hidden" name="content.menuId" value="${content.menuId}"/>
					    <fieldset>
							<div class="control-group">
							    <label class="control-label">菜单名称</label>
							    <div class="controls">
								    <span class="input-xlarge uneditable-input">${content.menuName} | ${content.menuNameEn}</span>
							    </div>
						    </div>
						    <div class="control-group">
							    <label class="control-label" for="input01"><span class="required-input">*</span>内容</label>
							    <div class="controls">
								    <textarea name="content.content" id="text">${content.content}</textarea>
							    </div>
						    </div>
						    <div class="control-group">
							    <label class="control-label" for="input01"><span class="required-input">*</span>英文内容</label>
							    <div class="controls">
								    <textarea name="content.contentEn" id="textEn">${content.contentEn}</textarea>
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
