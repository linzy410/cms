<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<script type="text/javascript">
			$(function() {
			});
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
				    <li class="active">后台管理</li>
				</ul>
				<s:if test='result.webSite.title==""'>
				<div class="alert alert-error">您还未对网站基本信息进行设置，请先完成网站基本信息设置！<a href="/admin/webSite_list.action">马上设置</a></div>
				</s:if>
				<div class="alert alert-info">本网站前台页面为静态页面，全站每隔10分钟重新生成一次，如需即时查看页面效果，请在<a href="/admin/builder_list.action">生成器管理</a>中进行手动生成。</div>
		    	<div class="data-list">
		    	    <table class="table table-striped table-bordered table-condensed">
		    	    	<tr>
		    	    		<td width="50%">新闻资讯数量</td>
		    	    		<td width="50%">${result.newsCount}</td>
		    	    	</tr>
		    	    	<tr>
		    	    		<td>图片空间数量</td>
		    	    		<td>${result.imageCount}</td>
		    	    	</tr>
		    	    	<tr>
		    	    		<td>Banner广告数量</td>
		    	    		<td>${result.adCount}</td>
		    	    	</tr>
    				</table>
		    	</div>
		    </div>
	    </div>
    </div>
	</body>
</html>
