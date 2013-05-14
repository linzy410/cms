<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<script type="text/javascript">
			function remove(id){
				if(confirm("确定删除吗？")){
					goAction("/admin/user_remove.action?selectedId="+id);
				}
			}
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
				    <li class="active">用户管理</li>
					<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/user_add.action')" value="新增"/></li>
				</ul>
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
	</body>
</html>
