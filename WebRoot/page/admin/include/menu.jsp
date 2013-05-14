<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<div class="well" style="padding: 8px 0;">
	<ul class="nav nav-list">
	    <li class="nav-header" style="font-size: 12px;">菜单</li>
	    <li <s:if test='menuTag=="website"'>class="active"</s:if>><a href="/admin/webSite_list.action"><i class="icon-home"></i>基本信息</a></li>
	    <li <s:if test='menuTag=="menu"'>class="active"</s:if>><a href="/admin/menu_list.action"><i class="icon-th-list"></i>导航菜单</a></li>
	    <li <s:if test='menuTag=="news"'>class="active"</s:if>><a href="/admin/news_list.action"><i class="icon-list-alt"></i>新闻资讯</a></li>
	    <li <s:if test='menuTag=="image"'>class="active"</s:if>><a href="/admin/image_list.action"><i class="icon-picture"></i>图片空间</a></li>
	    <li <s:if test='menuTag=="user"'>class="active"</s:if>><a href="/admin/user_list.action"><i class="icon-user"></i>用户管理</a></li>
	    <li <s:if test='menuTag=="ad"'>class="active"</s:if>><a href="/admin/ad_list.action"><i class="icon-th-large"></i>广告管理</a></li>
	    <li <s:if test='menuTag=="builder"'>class="active"</s:if>><a href="/admin/builder_list.action"><i class="icon-calendar"></i>生成器管理</a></li>
    </ul>
</div>