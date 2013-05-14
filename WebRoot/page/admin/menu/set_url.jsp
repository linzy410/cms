<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
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
				    <li class="active">链接设置</li>
				</ul>
		    	<form method="post" action="/admin/menu_setUrl.action">
	    	    <table class="table table-bordered table-condensed">
	    	    	<tr>
	    	    		<th width="150">中文名</th>
	    	    		<th width="150">英文名</th>
	    	    		<th>链接</th>
	    	    	</tr>
	    	    	<s:iterator value="menus" status="st">
		    	    	<tr>
		    	    		<td>${name}</td>
		    	    		<td>${nameEn}</td>
		    	    		<td><input type="hidden" name="menus[${st.index}].id" value="${id}"/><input type="text" name="menus[${st.index}].url" style="width: 353px;" value="${url}" /></td>
		    	    	</tr>
	    	    	</s:iterator>
   				</table>
   				<div class="controls">
			    	<button class="btn btn-primary" type="submit">确定</button>
			    	<a href="/admin/menu_list.action" class="btn">返回</a>
			    </div>
		    	</form>
		    </div>
	    </div>
    </div>
	</body>
</html>
