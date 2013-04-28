<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理</title>
		<link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		
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
								<a href="javascript:void(0);" class="brand">菜单管理 >> <s:if test="menu==null || menu.id==0">新增</s:if><s:else>编辑</s:else></a>
							</div>
						</div>
			    	</div>
			    	<div>
					    <form class="form-horizontal" method="post" action="/admin/<s:if test="menu.id==0">menu_save.action</s:if><s:else>menu_update.action</s:else>">
					    	<input type="hidden" name="id" value="${menu.id}"/>
						    <fieldset>
								<div class="control-group">
							   		<label class="control-label">中文名称</label>
								    <div class="controls">
									    <input type="text" class="input-xlarge" placeholder="请输入中文名称" name="name" value="${menu.name}"/>
								    </div>
							    </div>
								<div class="control-group">
								    <label class="control-label">英文名称</label>
								    <div class="controls">
									    <input type="text" class="input-xlarge" placeholder="请输入英文名称" name="nameEn" value="${menu.nameEn}"/>
								    </div>
							    </div>
							    <label class="control-label" for="input01">菜单类别</label>
							    <div class="controls">
					              <label class="radio" title="该菜单详细页面仅有一张页面组成"><input name="type" value="1" <s:if test="menu.type==1">checked=""</s:if> type="radio">单张页面内容</label>
					              <label class="radio" title="指向一个特定的链接"><input name="type" value="2" <s:if test="menu.type==2">checked=""</s:if> type="radio">指定链接</label>
					              <label class="radio" title="做为新闻资讯的一个类别"><input name="type" value="3" <s:if test="menu.type==3">checked=""</s:if> type="radio">新闻资讯类</label>
							    </div>
							    <label class="control-label" for="input01">是否显示</label>
							    <div class="controls">
					              <label class="radio"><input name="isShow" value="0" <s:if test="menu.isShow==0">checked=""</s:if> type="radio">显示</label>
					              <label class="radio"><input name="isShow" value="1" <s:if test="menu.isShow==1">checked=""</s:if> type="radio">隐藏</label>
							    </div>
							    <div class="controls" style="padding-top:10px;">
							    	<button class="btn btn-primary" type="submit">确定</button>
							    	<a href="/admin/menu_list.action" class="btn">返回</a>
							    </div>
						    </fieldset>
					    </form>
			    	</div>
			    </div>
		    </div>
	    </div>
    </div>
	</body>
</html>
