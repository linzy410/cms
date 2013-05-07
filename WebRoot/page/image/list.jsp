<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.his.cms.util.IConstants" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理</title>
		<link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<link href="/js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.4" type="text/css" media="screen" />
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/public.js"></script>
		<script type="text/javascript" src="/js/bootstrap-modal.js"></script>
		<script type="text/javascript" src="/js/fancybox/source/jquery.fancybox.pack.js?v=2.1.4"></script>
		<script type="text/javascript" src="/js/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="/js/uploadify/jquery.uploadify.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
			    $('#myModal').modal({
			        backdrop:false,
			        keyboard:false,
			        show:false
		        });
			    
			    $("#closebtn").click(function(){
			    	$('#myModal').modal('hide');
			    });

			    $('#myModal').on('hide', function () {
			    	$(".modal-backdrop").remove();
			    	if ($("#isUpload").val() == 1) {
					    window.location.reload();
			    	}
		        })

		        $("#uploadify").uploadify({
					'auto'           : false,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/admin/upload.action;jsessionid=<%=request.getSession().getId()%>?type=<%=IConstants.IMAGE_TYPE_SPACE%>',
					'buttonText'	 : '选择图片',
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
						
        			}
				});
			    
			    $(".fancybox").fancybox();
			});

			function showUpload(){
				var black = '<div class="modal-backdrop fade in"></div>';
				$("#myModal").before(black);
				$('#myModal').modal('show');
			}
			
			function uploadImage() {
				$("#isUpload").val(1);
				$('#uploadify').uploadify('upload','*');
			}
			
			function deleteImage() {
				var imgIds = "";
				$(":checkbox:checked").each(function(){
					imgIds+="," + this.value;
				});
				if (imgIds.length > 0) {
					if (confirm("确认要删除图片吗？")){
						goAction("/admin/image_remove.action?selectedIds=" + imgIds.substring(1));
					}
				}
			}
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
								<a href="javascript:void(0);" class="brand">图片空间</a>
								<div class="nav-collapse">
									<ul class="nav">
										<li><input type="button" class="btn btn-primary" onclick="deleteImage();" value="批量删除"/></li>
										<li style="padding-left: 5px;"><input type="button" class="btn btn-primary" onclick="showUpload();" value="图片上传"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
						<ul class="thumbnails">
			    	    	<s:iterator value="page.elements" status="st">
								<li class="span3">
									<a class="thumbnail fancybox" rel="group" href="/upload/${saveFile}" title="${name}"><img style="height:150px;" src="/upload/${saveFile}"/></a>
									<label class="checkbox"><input type="checkbox" value="${id}"/>${name}</label>
								</li>
			    	    	</s:iterator>
						</ul>
    				</div>
					<%@ include file="/page/include/page.jsp" %>
			    </div>
		    </div>
	    </div>
    </div>
    <input type="hidden" id="isUpload" value="0"/>
	<div class="modal hide" id="myModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal" href="#">×</a>
			<h3>图片上传</h3>
		</div>
		<div class="modal-body">
			<input type="file" name="uploadify" id="uploadify" />
			<a href="javascript:void(0);" onclick="uploadImage();" class="btn">图片上传</a>
		</div>
		<div class="modal-footer">
			<a href="javascript:void(0);" class="btn" id="closebtn">关闭</a>
		</div>
	</div>
	</body>
</html>
