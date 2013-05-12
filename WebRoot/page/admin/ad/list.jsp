<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.his.cms.util.IConstants" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<link href="/js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		<link href="/js/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/js/fancybox/source/jquery.fancybox.pack.js?v=2.1.4"></script>
		<script type="text/javascript">
			$(function() {
				if ($(".fancybox").length>0) {
			    	$(".fancybox").fancybox();
				}
			});
			
			function removeAd(id) {
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
								<a href="javascript:void(0);" class="brand">广告管理</a>
								<div class="nav-collapse">
									<ul class="nav">
										<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/ad_input.action');" value="新增"/></li>
									</ul>
								</div>
							</div>
						</div>
			    	</div>
			    	<div class="data-list">
						<ul class="thumbnails">
			    	    	<s:iterator value="adList" status="st">
								<li class="span3" style="position: relative;">
									<a class="thumbnail fancybox" rel="group" href="/upload/${saveFile}" title="${title}"><img style="height:150px;" src="/upload/${saveFile}"/></a>
									<s:if test='isShow==1'><span class="hideAd">隐藏</span></s:if>
									${title}
									<a href="/admin/ad_edit.action?selectedId=${id}">编辑</a> | <a href="javascript:void(0);" onclick="removeAd(${id});">删除</a>  
								</li>
			    	    	</s:iterator>
						</ul>
    				</div>
			    </div>
		    </div>
	    </div>
	</body>
</html>
