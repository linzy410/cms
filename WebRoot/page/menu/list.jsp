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
					goAction("/admin/menu_remove.action?selectedId="+id);
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
								<a href="javascript:void(0);" class="brand">菜单管理</a>
								<div class="nav-collapse">
									<ul class="nav">
										<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/menu_add.action')" value="新增"/></li>
										<li style="padding-left: 5px;"><input type="button" class="btn btn-primary" onclick="goAction('/admin/menu_order.action')" value="排序"/></li>
										<li style="padding-left: 5px;"><input type="button" class="btn btn-primary" onclick="goAction('/admin/menu_url.action')" value="链接设置"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th width="60">顺序</th>
				    	    	<th>中文名称</th>
				    	    	<th>英文名称</th>
				    	    	<th width="80">类型</th>
				    	    	<th width="140">操作</th>
				    	    </tr>
			    	    	<s:iterator value="menus" status="st">
				    	    	<tr>
				    	    		<td>${listOrder}</td>
				    	    		<td>${name}</td>
				    	    		<td>${nameEn}</td>
				    	    		<td><s:if test="type==1">页面内容</s:if><s:elseif test="type==2">指定链接</s:elseif><s:else>新闻资讯类</s:else></td>
				    	    		<td>
				    	    			<a href="/admin/menu_edit.action?selectedId=${id}">编辑</a> | <a href="javascript:void(0);" onclick="remove(${id});">删除</a> | 
				    	    			<s:if test="type==1"><a href="/admin/menu_content.action?selectedId=${id}">内容编辑</a></s:if>
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
