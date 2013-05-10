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
					goAction("/admin/user_remove.action?selectedId="+id);
				}
			}
		</script>
	</head>
	<body>
    <div class="row">
	    <div class="span15">
		    预留位置
		    <div class="row">
			    <div class="span3">
			    	 <%@ include file="/page/include/menu.jsp" %>
			    </div>
			    <div class="span12">
			    	<div class="navbar">
			    		<div class="navbar-inner">
							<div class="container">
								<a href="javascript:void(0);" class="brand">用户管理</a>
								<div class="nav-collapse">
									<ul class="nav">
										<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/user_add.action')" value="新增"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th width="15%">序号</th>
				    	    	<th width="35%">用户名</th>
				    	    	<th width="35%">姓名</th>
				    	    	<th width="15%">操作</th>
				    	    </tr>
			    	    	<s:iterator value="users" status="st">
				    	    	<tr>
				    	    		<td>${st.index+1}</td>
				    	    		<td>${username}</td>
				    	    		<td>${name}</td>
				    	    		<td>
				    	    			<a href="/admin/user_edit.action?selectedId=${id}">编辑</a> | <a href="javascript:void(0);" onclick="remove(${id});">删除</a>
				    	    		</td>
				    	    	</tr>
			    	    	</s:iterator>
	    				</table>
			    	</div>
			    </div>
		    </div>
	    </div>
    </div>
	</body>
</html>
