<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<div class="well" style="padding: 8px 0;">
	<ul class="nav nav-list">
	    <li class="nav-header" style="font-size: 12px;">菜单</li>
	    <li <s:if test='menuTag=="menu"'>class="active"</s:if>><a href="/admin/menu_list.action"><i class="icon-book"></i>导航菜单</a></li>
	    <li <s:if test='menuTag=="news"'>class="active"</s:if>><a href="/admin/news_list.action"><i class="icon-home"></i>新闻资讯</a></li>
	    <li><a href="#"><i class="icon-pencil"></i></a></li>
	    <li class="nav-header">另一个列表头</li>
	    <li><a href="#"><i class="icon-user"></i> 介绍</a></li>
	    <li><a href="#"><i class="icon-cog"></i> 设置</a></li>
	    <li class="divider"></li>
	    <li><a href="#"><i class="icon-flag"></i> 帮助</a></li>
    </ul>
</div>