<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.his.cms.util.IConstants" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<script type="text/javascript">
			function builder(id) {
				if (confirm("确认要删除吗？")){
					goAction("/admin/ad_remove.action?selectedId=" + id);
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
			    	<div class="navbar">
			    		<div class="navbar-inner">
								<div class="container">
								<a href="javascript:void(0);" class="brand">生成器管理</a>
							</div>
						</div>
			    	</div>
					<div class="data-list">
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th>名称</th>
				    	    	<th width="60">操作</th>
				    	    </tr>
			    	    	<s:iterator value="builders" status="st">
			    	    	<tr>
			    	    		<td>${title}</td>
			    	    		<td><a class="btn btn-primary" href="/admin/builder_builder.action?key=${key}">生成</a></td>
			    	    	</tr>
			    	    	</s:iterator>
	    				</table>
			    	</div>
		    	</div>
		    </div>
	    </div>
	</body>
</html>
