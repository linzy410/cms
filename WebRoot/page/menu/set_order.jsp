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
								<a href="javascript:void(0);" class="brand">菜单管理 >> 排序</a>
							</div>
						</div>
			    	</div>
			    	<form method="post" action="/admin/menu_setOrder.action">
		    	    <table class="table table-bordered table-condensed">
		    	    	<tr>
		    	    		<th>中文名</th>
		    	    		<th width="100">序号</th>
		    	    	</tr>
		    	    	<s:iterator value="menus" status="st">
			    	    	<tr>
			    	    		<td>${name}</td>
			    	    		<td><input type="hidden" name="menus[${st.index}].id" value="${id}"/><input type="text" name="menus[${st.index}].listOrder" class="input-small" value="${listOrder}" /></td>
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
    </div>
	</body>
</html>
