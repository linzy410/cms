<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理</title>
		<link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/public.js"></script>
		
		<script type="text/javascript">
			$(function() {
			});

			function remove(id){
				if(confirm("确定删除吗？")){
					goAction("/admin/news_remove.action?selectedId="+id);
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
										<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/news_add.action')" value="图片上传"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th width="25" style="text-align:center;"><input type="checkbox" name="newschk"/></th>
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
	</body>
</html>
