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
				showSuccMsg();
				$(".close").click(function() {
					$(".alert").slideUp();
				});
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
								<a href="javascript:void(0);" class="brand">新闻管理</a>
								<div class="nav-collapse">
									<ul class="nav">
									<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/news_add.action')" value="新增"/></li>
									</ul>
									<form class="navbar-form pull-left" action="/admin/news_list.action">
										<input type="text" placeholder="请输入标题" class="span3 searchIpt" />
										<input type="button" class="btn searchBtn" value="搜索"/>
									</form>
								</div>
							</div>
						</div>
			    	</div>
			    	<div style="position: relative;">
				    	<div class="alert alert-success hide"  style="margin-bottom:3px;position: absolute; width:100%;"><a data-dismiss="alert" class="close">×</a>操作成功</div>
			    	    <table class="table table-striped table-bordered table-condensed">
				    	    <tr>
				    	    	<th width="25" style="text-align:center;"><input type="checkbox" name="newschk"/></th>
				    	    	<th width="30">序号</th>
				    	    	<th>标题</th>
				    	    	<th width="70">创建者</th>
				    	    	<th width="130">创建时间</th>
				    	    	<th width="70">操作</th>
				    	    </tr>
			    	    	<s:iterator value="list" status="st">
				    	    	<tr>
				    	    		<td style="text-align:center;"><input type="checkbox" value="${id}" name="newschk"/></td>
				    	    		<td>${st.index+1}</td>
				    	    		<td>${title}</td>
				    	    		<td>${creator}</td>
				    	    		<td>${createTime}</td>
				    	    		<td><a href="/admin/news_edit.action?selectedId=${id}">编辑</a> | <a href="javascript:void(0);" onclick="remove(${id});">删除</a></td>
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
