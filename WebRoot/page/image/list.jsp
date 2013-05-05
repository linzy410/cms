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
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/public.js"></script>
		<script type="text/javascript" src="/js/bootstrap-modal.js"></script>
		<script type="text/javascript" src="/js/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="/js/uploadify/jquery.uploadify.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
			    $('#myModal').modal({
			        backdrop:false,
			        keyboard:false,
			        show:false
		        });

			    $('#myModal').on('hide', function () {
				    window.location.reload();
		        })

		        $("#uploadify").uploadify({
					'auto'           : true,
					'swf'            : '/js/uploadify/uploadify.swf',
					'uploader'       : '/admin/image_upload.action?type="<%=IConstants.IMAGE_TYPE_SPACE%>"',
					'buttonText'	 : '选择图片',
					'fileTypeExts'	 : '*.gif;*.jpg;*.png;*.jpeg',
					'onUploadSuccess':function(file, data, response){
						
        			}
				});
			});

			function showUpload(){
				var black = '<div class="modal-backdrop fade in"></div>';
				$("#myModal").before(black);
				$('#myModal').modal('show');
			}

			function remove(id){
				if(confirm("确定删除吗？")){
					goAction("/admin/image_remove.action?selectedId="+id);
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
										<li><input type="button" class="btn btn-primary" onclick="showUpload();" value="图片上传"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th width="25" style="text-align:center;"><input type="checkbox" name="imagechk"/></th>
				    	    	<th width="30">序号</th>
				    	    </tr>
			    	    	<s:iterator value="page.elements" status="st">
				    	    	<tr>
				    	    		<td>${st.index}</td>
				    	    	</tr>
			    	    	</s:iterator>
	    				</table>
    				</div>
					<div class="pagination">
						<ul>
							<li class="disabled"><a href="#">共有<font color="red">${page.total}</font>条记录</a></li>
							<li><a href="${page.previousPage}">«</a></li>
							<s:iterator value="page.links">
								<li class="<s:if test='state==1'>active</s:if><s:elseif test='state==2'>disabled</s:elseif>"><a href="${href}">${name}</a></li>
							</s:iterator>
							<li><a href="${page.nextPage}">»</a></li>
						</ul>
					</div>
			    </div>
		    </div>
	    </div>
    </div>
	<div class="modal hide" id="myModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal" href="#">×</a>
			<h3>图片上传</h3>
		</div>
		<div class="modal-body">
			<input type="file" name="uploadify" id="uploadify" />
			<a href="javascript:$('#uploadify').uploadify('upload','*')">图片上传</a>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn">关闭</a>
		</div>
	</div>
	</body>
</html>
