<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<div class="nav-collapse">
				<ul class="nav">
					<li><a>欢迎你：${sessionScope.user.name}</a></li>
					<li><a href="/logout.action">退出</a></li>
					<li>
						<div class="btn-group" data-toggle="buttons-radio">
							<button class="btn btn-primary<s:if test='#session.lang=="0"'> active</s:if>" data-lang="0">中文版</button>
							<button class="btn btn-primary<s:if test='#session.lang=="1"'> active</s:if>" data-lang="1">英文版</button>
						</div>
					</li>
				</ul>
				<ul class="nav pull-right">
					<li>
						<a href="/cn/" target="_blank">中文</a>
					</li>
					<li>
						<a href="/en/" target="_blank">英文</a>
					</li>
				</ul>
				<ul class="pull-right">
				<a class="brand" style="padding: 8px 0 12px;">预览</a>
				</ul>
			</div>
		</div>
	</div>
</div>