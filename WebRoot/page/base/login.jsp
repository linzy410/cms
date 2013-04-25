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
		</script>
	</head>
	<body>
		<div class="row">
		<div class="span10"  style="padding-left:500px;padding-top:180px;">
	    <form class="form-horizontal" method="post" action="/login.action">
		    <fieldset>
				<legend>登录</legend>
				<div class="control-group">
				    <label class="control-label" for="input01">用户名</label>
				    <div class="controls">
					    <input type="text" class="input-xlarge" placeholder="请输入用户名" name="username"/>
				    </div>
			    </div>
			    <label class="control-label" for="input01">密  码</label>
			    <div class="controls">
				    <input type="text" class="input-xlarge" placeholder="请输入密码" name="password"/>
			    </div>
			    <div class="controls" style="padding-top:10px;">
			    	<button class="btn btn-primary" type="submit">登录</button>
			    </div>
		    </fieldset>
	    </form>
	    </div>
	    </div>
	</body>
</html>
